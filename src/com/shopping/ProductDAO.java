package com.shopping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends Dao{
private static ProductDAO instance;
	
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

	
	List<ProductDTO> selectAllProducts() {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String query = "SELECT * FROM " + tableName;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setProduct_name(rs.getString(1));
				p.setAge_group(rs.getString(2));
				p.setType(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscount(rs.getInt(5));
				p.setHot(rs.getBoolean(6));
				p.setCreated_date(rs.getDate(7));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt, rs);
		}

		return list;
	}

	
	ProductDTO selectProduct(ProductDTO p) {
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
		String query = "DELETE FROM " + tableName + " WHERE product_name = ?";
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
		String sql = "UPDATE " + tableName + " SET product_name=?, age_group=?, type=?, price=?, discount=?, hot=?, created_date=?"
				+ " WHERE product_name = ?"; 
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			ps.setString(1, p.getProduct_name());
			ps.setString(2, p.getAge_group());
			ps.setString(3, p.getType());
			ps.setInt(4, p.getPrice());
			ps.setInt(5, p.getDiscount());
			ps.setBoolean(6, p.isHot());
			ps.setDate(7, p.getCreated_date());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
