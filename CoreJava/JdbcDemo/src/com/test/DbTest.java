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
		//db.insertLocationsUsingStatement(new Locations("23 St Drive", "897651", "Washington", "USA", "US"));
		//db.insertLocationsUsingPrepareStatement(new Locations("101 Dahram street", "41231", "Pune", "Mah", "IN"));
		//db.deleteLocationsById(427);
//		Locations ob = new Locations();
//		ob.setLocation_id(427);
//		ob.setStreet_address("423 Normandie Blvd");
//		ob.setPostal("12345");
//		db.updateLocationsUsingPrepareStatement(ob);
//		for(Locations ob: db.getAllLocations())
//			System.out.println(ob);
//		System.out.println();
//		for(Locations ob: db.getAllLocationsByCountryId("NP"))
//			System.out.println(ob);
		
		db.metadata();
		
	}

}
