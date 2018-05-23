package com.shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserDAO extends Dao {
	public UserDAO() {
		// TODO table name insert
		super(null, "users");

		System.out.println("11111");
	}

	public UserDAO(Connection conn) {
		super(conn, "users");
	}
	
	List<UserDTO> selectAllUsers() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		String query = "SELECT * FROM " + tableName; // ��� ������� ������ �����´�.
		ResultSet rs = null;
		Statement stmt = null;

		try {
			stmt = conn.createStatement(); // Statement�� �����´�.
			rs = stmt.executeQuery(query); // SQL���� �����Ѵ�.

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
		String query = "SELECT * FROM " + tableName + " WHERE ID = ?"; // ����� ������ �����´�. ''�� ������� ������ ����
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, u.getId());
			rs = ps.executeQuery(); // rs = ps.executeQuery(query); �� ���� ���� ������ ����

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
		String query = "DELETE FROM " + tableName + " WHERE ID = ?"; // ����� ������ �����´�. ''�� ������� ������ ����
		try (PreparedStatement ps = conn.prepareStatement(query);) {
			conn.setAutoCommit(true);
			// 3.2 ���� ���� & ����
			ps.setString(1, u.getId());
			result = ps.executeUpdate(); // ps.executeUpdate(sql);�� ���� ���� ������ ����
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	int insertUser(UserDTO u) {
		int result = 0;
		String sql = "INSERT INTO " + tableName + " VALUES " + " (?,?,?,?,?,?,?)"; // ""�ȿ� ;�� ���� �ʾƵ� �ȴ�.
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

			result = ps.executeUpdate(); // ps.executeUpdate(sql);�� ���� ���� ������ ����
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	int updateUser(UserDTO u) {
		int result = 0;
		String sql = "UPDATE " + tableName + " SET password=?, name=?, age=?, gender=?, phone=?, introduction=? "
				+ " WHERE id = ?"; // ""�ȿ� ;�� ���� �ʾƵ� �ȴ�.
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			// 3.2 ���� ���� & ����
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getName());
			ps.setInt(3, u.getAge());
			// ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
			ps.setString(4, u.getGender());
			ps.setString(5, u.getPhone());
			ps.setString(6, u.getIntroduction());

			result = ps.executeUpdate(); // ps.executeUpdate(sql);�� ���� ���� ������ ����
		} catch (Exception e) {
			// 5. �����ϸ�, ������ ������?
			e.printStackTrace();
		}

		return result;
	}
}
