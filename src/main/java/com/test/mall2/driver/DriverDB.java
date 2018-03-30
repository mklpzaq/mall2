package com.test.mall2.driver;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class DriverDB {
	
	public static Connection driverConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pw = "java0000";
		Connection connection = DriverManager.getConnection(url, id, pw);
		return connection;
	}
}
