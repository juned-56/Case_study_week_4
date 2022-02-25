package com.ac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDB {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverName = "org.postgresql.Driver";
		//driver class
		Class.forName(driverName);
		//create the connection
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/student", "postgres", "Juned@56");
		return conn;
	}
}
