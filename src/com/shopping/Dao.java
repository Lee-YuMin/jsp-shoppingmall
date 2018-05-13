package com.shopping;

import java.sql.Connection;

// DAO를 상속하는 최상위 클래스

public class Dao {
	Connection conn;
	String tableName ="";
	
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
