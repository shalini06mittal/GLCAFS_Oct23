package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	/**
	 * 1. Download the driver
	 * https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.28
	 * 2. Add the jar file in the build path of the project
	 * JdbcDemo -> rt click-> Build Path -> Configure Build Path ->
	 * Libraries(Tab) -> Click on Classpath-> Add External Jars->
	 * Select the downloaded jar file , Open, Apply and close
	 * 3. Load the driver
	 */
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			// Connect to the database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/hr_emp", "root", "root");
			// windows
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_emp", "root", "root");
			System.out.println("DB Connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
