package com.shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserDAO extends Dao {
	private static UserDAO instance;
	
	public UserDAO() {
		// TODO table name insert
		super(null, "users");
	}

	public UserDAO(Connection conn) {
		super(conn, "users");
	}
	
	public static UserDAO getInstance(){
		if(instance==null)
			instance=new UserDAO();
		return instance;
	}

	
	List<UserDTO> selectAllUsers() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		String query = "SELECT * FROM " + tableName;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				UserDTO u = new UserDTO();
				u.setId(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setName(rs.getString(3));
				u.setAge(rs.getInt(4));
				u.setGender(rs.getString(5));
				u.setPhone(rs.getString(6));
				u.setIntroduction(rs.getString(7));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt, rs);
		}

		return list;
	}

	
	UserDTO selectUser(UserDTO u) {
		String query = "SELECT * FROM " + tableName + " WHERE ID = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, u.getId());
			rs = ps.executeQuery(); // rs = ps.executeQuery(query);

			while (rs.next()) {
				u.setId(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setName(rs.getString(3));
				u.setAge(rs.getInt(4));
				u.setGender(rs.getString(5));
				u.setPhone(rs.getString(6));
				u.setIntroduction(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, rs);
		}

		return u;
	}

	int deleteUser(String id) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		String dbpw = "";
		
		try {
			// 비밀번호 조회
			StringBuffer query1 = new StringBuffer();
			query1.append("SELECT PASSWORD FROM users WHERE ID=?");

			// 회원 삭제
			StringBuffer query2 = new StringBuffer();
			query2.append("DELETE FROM users WHERE ID=?");

			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			// 1. 아이디에 해당하는 비밀번호를 조회한다.
			ps = conn.prepareStatement(query1.toString());
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) 
			{
//				dbpw = rs.getString("password");
//				if (dbpw.equals(pw)) // 입력된 비밀번호와 DB비번 비교
//				{
					// 같을경우 회원삭제 진행
					ps = conn.prepareStatement(query2.toString());
					ps.setString(1, id);
					ps.executeUpdate();
					conn.commit(); 
					result = 1; // 삭제 성공
//				} else {
//					result = 0; // 비밀번호 비교결과 - 다름
//				}
			}

			return result;

		} catch (Exception sqle) {
			try {
				conn.rollback(); // 오류시 롤백
			} catch (SQLException e) {
				e.printStackTrace();
			}
			throw new RuntimeException(sqle.getMessage());
		}
	}

	int insertUser(UserDTO u) {
		int result = 0;
		String sql = "INSERT INTO " + tableName + " VALUES " + " (null,?,?,?,?,?,?,?)";
		// String sql = "insert into USER_INFO values (?,?,?,?, sysdate, sysdate)";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			ps.setString(1, u.getId());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getGender());
			ps.setString(6, u.getPhone());
			ps.setString(7, u.getIntroduction());

			result = ps.executeUpdate(); // ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	int updateUser(UserDTO u) {
		int result = 0;
		String sql = "UPDATE " + tableName + " SET password=?, name=?, age=?, gender=?, phone=?, introduction=? "
				+ " WHERE id = ?"; 
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getName());
			ps.setInt(3, u.getAge());
			// ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
			ps.setString(4, u.getGender());
			ps.setString(5, u.getPhone());
			ps.setString(6, u.getIntroduction());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public int loginCheck(String id, String pw) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
		int x = -1;

		try {
			// 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
			String query = "SELECT password FROM users WHERE ID=?";

			pstmt = conn.prepareStatement(query);
			conn.setAutoCommit(true);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
			{
				dbPW = rs.getString("password"); // 비번을 변수에 넣는다.

				if (dbPW.equals(pw)) 
					x = 1; // 넘겨받은 비번과 꺼내온 비번 비교. 같으면 인증성공
				else 				 
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
				
			} else {
				x = -1; // 해당 아이디가 없을 경우
			}

			return x;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
//			try{
//				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
//				if ( conn != null ){ conn.close(); conn=null;	}
//			}catch(Exception e){
//				throw new RuntimeException(e.getMessage());
//			}
		}
	}
}
