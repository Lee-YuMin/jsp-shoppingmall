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
//		     String query = "SELECT * FROM " + tableName; // ��� ������� ������ �����´�.
//		  ResultSet rs = null;
//		  Statement stmt = null;
//
//		        try {
//		       stmt = conn.createStatement();             // Statement�� �����´�.
//		       rs = stmt.executeQuery(query); // SQL���� �����Ѵ�.
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
//		            +" WHERE USER_ID = ?"; // ����� ������ �����´�. ''�� ������� ������ ����
//		     PreparedStatement ps = null;
//		  ResultSet rs = null;
//
//		        try {
//		             ps = conn.prepareStatement(query);
//		       ps.setString(1, u.getUser_id());
//		       rs = ps.executeQuery(); // rs = ps.executeQuery(query);�� ���� ���� ������ ����
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
//		           + " WHERE USER_ID = ?"; // ����� ������ �����´�. ''�� ������� ������ ����
//		        try (PreparedStatement ps = conn.prepareStatement(query);) {
//		         conn.setAutoCommit(true);
//		   // 3.2 ���� ���� & ����  
//		   ps.setString(1, u.getUser_id());
//		   result = ps.executeUpdate(); // ps.executeUpdate(sql);�� ���� ���� ������ ����
//		        } catch(SQLException e) {
//		   e.printStackTrace();
//		        }
//
//		        return result;
//		    }
//		    int insertUser(User u) {
//		        int result = 0;
//		        String sql = "INSERT INTO " + tableName + " VALUES "
//		           + " (?,?,?,?,?,?)"; // ""�ȿ� ;�� ���� �ʾƵ� �ȴ�.
//		// String sql = "insert into USER_INFO values (?,?,?,?, sysdate, sysdate)"; // ""�ȿ� ;�� ���� �ʾƵ� �ȴ�.
//		        try (PreparedStatement ps = conn.prepareStatement(sql);) {
//		         conn.setAutoCommit(true);
//		   // 3.2 ���� ���� & ����  
//		   ps.setString(1, u.getUser_id());
//		   ps.setString(2, u.getName());
//		   ps.setString(3, u.getPassword());
//		   ps.setString(4, u.getEmail());
//		// ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
//		   ps.setDate(5, u.getIn_date());
//		   ps.setDate(6, u.getUp_date());
//
//		   result = ps.executeUpdate(); // ps.executeUpdate(sql);�� ���� ���� ������ ����
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
//		          + " WHERE user_id = ?"; // ""�ȿ� ;�� ���� �ʾƵ� �ȴ�.
//		        try (PreparedStatement ps = conn.prepareStatement(sql);){
//		         conn.setAutoCommit(true);
//		   // 3.2 ���� ���� & ����  
//		   ps.setString(1, u.getName());
//		   ps.setString(2, u.getPassword());
//		   ps.setString(3, u.getEmail());
//		// ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
//		   ps.setDate(4, u.getIn_date());
//		   ps.setDate(5, u.getUp_date());
//		   ps.setString(6, u.getUser_id());
//
//		   result = ps.executeUpdate(); // ps.executeUpdate(sql);�� ���� ���� ������ ����
//		        } catch ( Exception e ) {
//		         // 5. �����ϸ�, ������ ������?
//		         e.printStackTrace();
//		        }
//
//		        return result;
//		    }  
}
