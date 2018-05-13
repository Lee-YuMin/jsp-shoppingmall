package com.shopping;

import java.sql.*;

public class DBUtil {
	public static Connection getConnetcion() {
		Connection conn = null;

		String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
		String DB_URL = "jdbc:.....?";
		String DB_USER = "";
		String DB_PASSWORD = "";

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
