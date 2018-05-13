package com.shopping;

import java.sql.Connection;

// DAO�� ����ϴ� �ֻ��� Ŭ����

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
