package com.shopping;

import java.sql.*;

public class UserDAO extends Dao{
	public UserDAO() {
		//TODO table name insert
		super(null, "table_name");
	}
	
	public UserDAO(Connection conn) {
		super(conn, "table_name");
	}
	
	
//	 List<User> selectAllUsers() {
//		  List<User> list = new ArrayList<User>();
//		     String query = "SELECT * FROM " + tableName; // 모든 사용자의 정보를 가져온다.
//		  ResultSet rs = null;
//		  Statement stmt = null;
//
//		        try {
//		       stmt = conn.createStatement();             // Statement를 가져온다.
//		       rs = stmt.executeQuery(query); // SQL문을 실행한다.
//
//		          while (rs.next()) {
//		           User u = new User();
//		        u.setUser_id(rs.getString(1));
//		        u.setName(rs.getString(2));
//		        u.setPassword(rs.getString(3));
//		        u.setEmail(rs.getString(4));
//		        u.setIn_date(rs.getDate(5));
//		        u.setUp_date(rs.getDate(6));
//		        list.add(u);
//		          }
//		        } catch ( Exception e ) {
//		             e.printStackTrace();
//		        } finally {
//		         DBUtil.close(stmt, rs);
//		        }
//
//		     return list;
//		 }
//
//		    User selectUser(User u) {
//		     String query = "SELECT * FROM "+ tableName
//		            +" WHERE USER_ID = ?"; // 사용자 정보를 가져온다. ''를 사용하지 않음에 주의
//		     PreparedStatement ps = null;
//		  ResultSet rs = null;
//
//		        try {
//		             ps = conn.prepareStatement(query);
//		       ps.setString(1, u.getUser_id());
//		       rs = ps.executeQuery(); // rs = ps.executeQuery(query);과 같이 하지 않음에 주의
//
//		          while (rs.next()) {
//		        u.setUser_id(rs.getString(1));
//		        u.setName(rs.getString(2));
//		        u.setPassword(rs.getString(3));
//		        u.setEmail(rs.getString(4));
//		        u.setIn_date(rs.getDate(5));
//		        u.setUp_date(rs.getDate(6));
//		          }
//		        } catch ( Exception e ) {
//		             e.printStackTrace();
//		        } finally {
//		         DBUtil.close(ps, rs);
//		        }
//
//		     return u;
//		    }
//
//		    int deleteUser(User u) {
//		        int result = 0;
//		     String query = "DELETE FROM " + tableName
//		           + " WHERE USER_ID = ?"; // 사용자 정보를 가져온다. ''를 사용하지 않음에 주의
//		        try (PreparedStatement ps = conn.prepareStatement(query);) {
//		         conn.setAutoCommit(true);
//		   // 3.2 쿼리 셋팅 & 실행  
//		   ps.setString(1, u.getUser_id());
//		   result = ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의
//		        } catch(SQLException e) {
//		   e.printStackTrace();
//		        }
//
//		        return result;
//		    }
//		    int insertUser(User u) {
//		        int result = 0;
//		        String sql = "INSERT INTO " + tableName + " VALUES "
//		           + " (?,?,?,?,?,?)"; // ""안에 ;를 넣지 않아도 된다.
//		// String sql = "insert into USER_INFO values (?,?,?,?, sysdate, sysdate)"; // ""안에 ;를 넣지 않아도 된다.
//		        try (PreparedStatement ps = conn.prepareStatement(sql);) {
//		         conn.setAutoCommit(true);
//		   // 3.2 쿼리 셋팅 & 실행  
//		   ps.setString(1, u.getUser_id());
//		   ps.setString(2, u.getName());
//		   ps.setString(3, u.getPassword());
//		   ps.setString(4, u.getEmail());
//		// ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
//		   ps.setDate(5, u.getIn_date());
//		   ps.setDate(6, u.getUp_date());
//
//		   result = ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의
//		        } catch ( Exception e ) {
//		         e.printStackTrace();
//		        }
//
//		        return result;
//		    }
//
//		    int updateUser(User u) {
//		        int result = 0;
//		        String sql = "UPDATE "+ tableName
//		          + " SET name=?, password=?, email=?, in_date=?, up_date=? "
//		          + " WHERE user_id = ?"; // ""안에 ;를 넣지 않아도 된다.
//		        try (PreparedStatement ps = conn.prepareStatement(sql);){
//		         conn.setAutoCommit(true);
//		   // 3.2 쿼리 셋팅 & 실행  
//		   ps.setString(1, u.getName());
//		   ps.setString(2, u.getPassword());
//		   ps.setString(3, u.getEmail());
//		// ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
//		   ps.setDate(4, u.getIn_date());
//		   ps.setDate(5, u.getUp_date());
//		   ps.setString(6, u.getUser_id());
//
//		   result = ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의
//		        } catch ( Exception e ) {
//		         // 5. 실패하면, 에러를 보여줘?
//		         e.printStackTrace();
//		        }
//
//		        return result;
//		    }  
}
