package com.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.enitty.Locations;


public class LocationDB {

	// insert
	Connection conn = MyConnection.getConnection();
	
	public boolean insertLocationsUsingStatement(Locations obj) {
		
		String sql = "insert into locations"
				+ "(street_address, postal_code, city, state_province, country_id) "
				+ "values("
				+ "'"+obj.getStreet_address()+"',"
				+ "'"+obj.getPostal()+"',"
				+ "'"+obj.getCity()+"',"
				+ "'"+obj.getProvince()+"',"
				+ "'"+obj.getCountryid()+"'"
				+ ")";
		System.out.println(sql);
		
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("Could not insert");
		}
		return true;
	}
	
	// select
}
