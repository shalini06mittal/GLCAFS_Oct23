package com.test;

import com.db.LocationDB;
import com.db.MyConnection;
import com.enitty.Locations;

//class A{
//	static {
//		System.out.println("static block 1");
//		connect();
//	}
//	private static void connect()
//	{
//		System.out.println("registration process");
//	}
//}
public class DbTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		MyConnection.getConnection();
		//Class.forName("com.test.A");
		LocationDB db = new LocationDB();
		db.insertLocationsUsingStatement(new Locations("23 St Drive", "897651", "Washington", "USA", "US"));
	}

}
