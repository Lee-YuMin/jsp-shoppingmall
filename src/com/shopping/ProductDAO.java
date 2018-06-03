package com.shopping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductDAO extends Dao{
private static ProductDAO instance;
	private ResultSet rs;
	PreparedStatement pstmt;
	
	public ProductDAO() {
		// TODO table name insert
		super(null, "products");
	}

	public ProductDAO(Connection conn) {
		super(conn, "products");
	}
	
	public static ProductDAO getInstance(){
		if(instance==null)
			instance=new ProductDAO();
		return instance;
	}

	public int getSeq()
	{
		int result = 1;
		
		
		try {
			// 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT sequence.NEXTVAL FROM products");
			
			pstmt = conn.prepareStatement(sql.toString());
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			if(rs.next())	result = rs.getInt(1);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return result;	
	} // end getSeq
	
	// 상세보기
	public ProductDTO getDetail(int sequence)
	{	
		ProductDTO product = null;
		
		try {
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM products WHERE sequence = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sequence);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				product = new ProductDTO();
				product.setSequence(sequence);
				product.setProduct_name(rs.getString("product_name"));
				product.setAge_group(rs.getString("age_group"));
				product.setType(rs.getString("type"));
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				product.setHot(rs.getBoolean("hot"));
				product.setCreated_date(rs.getDate("created_date"));
			
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return product;
	} // end getDetail()
	
		
	ArrayList<ProductDTO> getProductList(HashMap<String, Object> listOpt) {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		
		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
		String condition = (String)listOpt.get("condition"); // 검색내용
		int start = (Integer)listOpt.get("start"); // 현재 페이지번호
		
		ResultSet rs = null;
		Statement stmt = null;

		try {
//			StringBuffer sql = new StringBuffer();
			String sql;
			
			// 글목록 전체를 보여줄 때
			if(opt == null)
			{
				// BOARD_RE_REF(그룹번호)의 내림차순 정렬 후 동일한 그룹번호일 때는
				// BOARD_RE_SEQ(답변글 순서)의 오름차순으로 정렬 한 후에
				// 10개의 글을 한 화면에 보여주는(start번째 부터 start+9까지) 쿼리
				// desc : 내림차순, asc : 오름차순 ( 생략 가능 )
//				sql.append("SET @rownum:=0; ");
//				sql.append("select * from ");
//				sql.append("(select @rownum:=@rownum+1 as rownum, sequence, product_name, age_group, type, price, discount, hot, created_date ");
//				sql.append("FROM");
//				sql.append(" (select * from products order by sequence desc, created_date asc)A)B ");
//				sql.append("where rownum>=? and rownum<=?");
				
//				sql = "SET @rownum:=0; SELECT @rownum:=@rownum+1, sequence, product_name, age_group, type, price, discount, hot, created_date FROM products ORDER BY sequence desc, created_date asc WHERE @rownum:=@rownum+1>=? AND @rownum:=@rownum+1<=?";
				sql = "SELECT * FROM products WHERE sequence>=? AND sequence<=? ORDER BY sequence desc, created_date asc";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, start+9);
				
				// StringBuffer를 비운다.
//				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("0")) // 이름으로 검색
			{
//				sql.append("SET @rownum:=0; ");
//				sql.append("select * from ");
//				sql.append("(select @rownum:=@rownum+1 as rownum, sequence, product_name, age_group");
//				sql.append(", type, price, discount, hot, created_date");
//				sql.append("FROM ");
//				sql.append("(select * from products where product_name like ? ");
//				sql.append("order BY sequence desc, created_date asc)A)B ");
//				sql.append("where rownum>=? and rownum<=?");
//				
//				pstmt = conn.prepareStatement(sql.toString());
//				pstmt.setString(1, "%"+condition+"%");
//				pstmt.setInt(2, start);
//				pstmt.setInt(3, start+9);
				sql = "SELECT * FROM (SELECT * from(SELECT * FROM products WHERE product_name like ? ORDER BY sequence desc, created_date asc)as A)as B WHERE sequence>=? AND sequence<=? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
//				
//				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("1")) // 연령대로 검색
			{
//				sql.append("SET @rownum:=0; ");
//				sql.append("select * from ");
//				sql.append("(select @rownum:=@rownum+1 as rownum, sequence, product_name, age_group");
//				sql.append(", type, price, discount, hot, created_date");
//				sql.append("FROM ");
//				sql.append("(select * from products where age_group like ? ");
//				sql.append("order BY sequence desc, created_date asc)A)B ");
//				sql.append("where rownum>=? and rownum<=?");
//				
//				pstmt = conn.prepareStatement(sql.toString());
//				pstmt.setString(1, "%"+condition+"%");
//				pstmt.setInt(2, start);
//				pstmt.setInt(3, start+9);
//				
//				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("2")) // 타입으로 검색
			{
//				sql.append("SET @rownum:=0; ");
//				sql.append("select * from ");
//				sql.append("(select @rownum:=@rownum+1 as rownum, sequence, product_name, age_group");
//				sql.append(", type, price, discount, hot, created_date");
//				sql.append("FROM ");
//				sql.append("(select * from products where type like ?");
////				sql.append("(select * from products where where1 like ? OR where2 like ? ");  조건이 2개 이상일때 표현
//				sql.append("order BY sequence desc, created_date asc)A)B ");
//				sql.append("where rownum>=? and rownum<=?");
//				
//				pstmt = conn.prepareStatement(sql.toString());
//				pstmt.setString(1, "%"+condition+"%");
////				pstmt.setString(2, "%"+condition+"%");
//				pstmt.setInt(3, start);
//				pstmt.setInt(4, start+9);
//				
//				sql.delete(0, sql.toString().length());
			}

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ProductDTO product = new ProductDTO();
				product.setSequence(rs.getInt("sequence"));
				product.setProduct_name(rs.getString("product_name"));
				product.setAge_group(rs.getString("age_group"));
				product.setType(rs.getString("type"));
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				product.setHot(rs.getBoolean("hot"));
				product.setCreated_date(rs.getDate("created_date"));
				list.add(product);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return list;
	}

	
	ProductDTO selectProduct(ProductDTO p) {
		// 현재는 안쓰는듯
		String query = "SELECT * FROM " + tableName + " WHERE product_name = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getProduct_name());
			rs = ps.executeQuery(); // rs = ps.executeQuery(query);

			while (rs.next()) {
				p.setProduct_name(rs.getString(1));
				p.setAge_group(rs.getString(2));
				p.setType(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscount(rs.getInt(5));
				p.setHot(rs.getBoolean(6));
				p.setCreated_date(rs.getDate(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, rs);
		}

		return p;
	}

	int deleteProduct(ProductDTO p) {
		int result = 0;
		String query = "DELETE FROM " + tableName + " WHERE sequence = ?";
		try (PreparedStatement ps = conn.prepareStatement(query);) {
			conn.setAutoCommit(true);
			
			ps.setString(1, p.getProduct_name());
			result = ps.executeUpdate(); // ps.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	int insertProduct(ProductDTO p) {
		int result = 0;
		String sql = "INSERT INTO " + tableName + " VALUES " + " (null,?,?,?,?,?,?,?)";
		
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			ps.setString(1, p.getProduct_name());
			ps.setString(2, p.getAge_group());
			ps.setString(3, p.getType());
			ps.setInt(4, p.getPrice());
			ps.setInt(5, p.getDiscount());
			ps.setBoolean(6, p.isHot());
			
			long time = System.currentTimeMillis(); 
			SimpleDateFormat dayTime = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
			String str = dayTime.format(new Date(time));
			ps.setString(7, str);

			result = ps.executeUpdate(); // ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	int updateProduct(ProductDTO p) {
		int result = 0;
		String sql = "UPDATE " + tableName + " SET product_name=?, age_group=?, type=?, price=?, discount=?, hot=?"
				+ " WHERE sequence = ?"; 
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			ps.setString(1, p.getProduct_name());
			ps.setString(2, p.getAge_group());
			ps.setString(3, p.getType());
			ps.setInt(4, p.getPrice());
			ps.setInt(5, p.getDiscount());
			ps.setBoolean(6, p.isHot());
			ps.setInt(7, p.getSequence());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// get Count
	public int getProductListCount(HashMap<String, Object> listOpt)
	{
		int result = 0;
		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
		String condition = (String)listOpt.get("condition"); // 검색내용
		
		try {
			StringBuffer sql = new StringBuffer();
			
			if(opt == null)	// 전체글의 개수
			{
				sql.append("select count(*) from products");
				pstmt = conn.prepareStatement(sql.toString());
				
				// StringBuffer를 비운다.
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("0")) // 제품 이름으로 검색한 글의 개수
			{
				sql.append("select count(*) from products where product_name like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("1")) // 연령대로 검색한 글의 개수
			{
				sql.append("select count(*) from products where age_group like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("2")) // 타입으로 검색한 글의 개수
			{
				sql.append("select count(*) from products where type like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			
			rs = pstmt.executeQuery();
			if(rs.next())	result = rs.getInt(1);
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return result;
	}
}
