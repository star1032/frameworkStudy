package com.oh.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:XE",  "yun", "1111");
	}

}
