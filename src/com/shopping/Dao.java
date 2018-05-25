package com.shopping;

import java.sql.Connection;

import javax.servlet.http.HttpServlet;

// DAO를 상속하는 최상위 클래스

public class Dao extends HttpServlet{
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
