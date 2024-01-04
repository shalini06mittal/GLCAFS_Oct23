package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			// 1) load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2) connection parameters
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:8889/ecommerce","root","root");
			System.out.println("driver loaded and connected");
			
		} catch (ClassNotFoundException e) {
			System.out.println("error driver not loaded");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("cannot connect to database");
			e.printStackTrace();
		}
		return conn;
	}
	
}
