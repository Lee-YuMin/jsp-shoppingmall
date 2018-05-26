package com.shopping;

import java.sql.Connection;

import javax.servlet.http.HttpServlet;

// DAO

public class Dao {
	Connection conn;
	String tableName ="users";
	
	Dao() {
		this(null, "");
	}
	
	Dao(String tableName) {
		this(null, tableName);
	}
	
	Dao(Connection conn, String tableName){
		this.tableName = tableName;
		this.conn = conn;
		
		if(conn==null) {
			this.conn = DBUtil.getConnetcion();
		}
	}
}
