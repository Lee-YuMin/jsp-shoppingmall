package com.shopping;

import java.sql.*;

public class DBUtil {
	public static Connection getConnetcion() {
		Connection conn = null;

		String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://127.0.0.1:3306/shopping?serverTimezone=UTC&autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8";
		String DB_USER = "root";
		String DB_PASSWORD = "0000";

		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {

			}
		}
	}

	static void close(AutoCloseable... acs) {
		try {
			for (AutoCloseable ac : acs) {
				if (ac != null)
					ac.close();
			}
		} catch (Exception e) {
			
		}
	}
}
