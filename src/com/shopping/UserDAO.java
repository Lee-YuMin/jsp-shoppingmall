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
	public UserDAO() {
		// TODO table name insert
		super(null, "users");
	}

	public UserDAO(Connection conn) {
		super(conn, "users");
	}
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
		 	throws ServletException, IOException {
	
		String requestURI = request.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/") + 1;
		String command = requestURI.substring(cmdIdx);
		
		ActionForward forward = null;
		Action action = null;
		
		String form = "main.jsp?contentPage=page/";
		
		try {
			if(command.equals("main")) 
			{	
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath("list.jsp");
			}
			else if(command.equals("signup"))
			{
				forward=new ActionForward();
				forward.setNextPath(form+"signup.jsp");
			}			
			else if(command.equals("signup-sucess"))
			{
				forward=new ActionForward();
				forward.setNextPath(form+"signup-sucess.jsp");
			}
			else if(command.equals("do-signup"))
			{
				forward=new ActionForward();
				forward.setNextPath(form+"do-signup.jsp");
			}
			
			
			// 화면이동 - isRedirext() 값에 따라 sendRedirect 또는 forward를 사용
			// sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
			// forward : 현재 실행중인 페이지와 forwad에 의해 호출될 페이지는 request와 response 객체를 공유
			if(forward != null){
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				} else {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	int deleteUser(UserDTO u) {
		int result = 0;
		String query = "DELETE FROM " + tableName + " WHERE ID = ?";
		try (PreparedStatement ps = conn.prepareStatement(query);) {
			conn.setAutoCommit(true);
			// 3.2 ���� ���� & ����
			ps.setString(1, u.getId());
			result = ps.executeUpdate(); // ps.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	int insertUser(UserDTO u) {
		int result = 0;
		String sql = "INSERT INTO " + tableName + " VALUES " + " (?,?,?,?,?,?,?)";
		// String sql = "insert into USER_INFO values (?,?,?,?, sysdate, sysdate)"; //
		// ""�ȿ� ;�� ���� �ʾƵ� �ȴ�.
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			// 3.2 ���� ���� & ����
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
}
