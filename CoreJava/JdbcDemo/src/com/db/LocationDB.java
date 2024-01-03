package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	/**
	 * Prepared Statement interface is preferred over Statement interface
	 * 1. Safe from SQL injection 
	 * 2. Developers do not have to create the entire query
	 * @param obj
	 * @return
	 */
	public boolean insertLocationsUsingPrepareStatement(Locations obj) {
		
		String sql = "insert into locations"
				+ "(street_address, postal_code, city, state_province, country_id) "
				+ "values(?,?,?,?,?)";
		System.out.println(sql);
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, obj.getStreet_address());
			statement.setString(2, obj.getPostal());
			statement.setString(3, obj.getCity());
			statement.setString(4, obj.getProvince());
			statement.setString(5, obj.getCountryid());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("Could not insert");
		}
		return true;
	}
	public boolean updateLocationsUsingPrepareStatement(Locations obj) {
		
		String sql = "update locations"
				+ " set street_address=?, postal_code=? "
				+ "where location_id=?";
		System.out.println(sql);
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, obj.getStreet_address());
			statement.setString(2, obj.getPostal());
			statement.setInt(3, obj.getLocation_id());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Could not update");
		}
		return true;
	}
	public boolean deleteLocationsById(int locationid) {
		
		String sql = "delete from locations where location_id=?";
		System.out.println(sql);
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, locationid);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Could not delete");
		}
		return true;
	}
	
	// select
}
