package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	 * 3. pre compiles the query and keepts it ready, hence it is faster than the Statement
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

	// select * from locations  => all records => List<Locations>
	public List<Locations> getAllLocations()
	{
		String  sql="select * from locations";
		PreparedStatement statement;
		List<Locations> locations = new ArrayList<Locations>();

		try {
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Locations location = new Locations();
				location.setLocation_id(rs.getInt(1));
				location.setStreet_address(rs.getString(2));
				location.setPostal(rs.getString(3));
				location.setCity(rs.getString(4));
				location.setProvince(rs.getString(5));
				location.setCountryid(rs.getString(6));
				//System.out.println(location);
				locations.add(location);
			}
			//System.out.println(rs.getInt("location_id"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locations;

	}

	// select * from locations  => all records => List<Locations>
	public List<Locations> getAllLocationsByCountryId(String countryid)
	{
		String  sql="select * from locations where country_id=?";
		PreparedStatement statement;
		List<Locations> locations = new ArrayList<Locations>();

		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, countryid);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Locations location = new Locations();
				location.setLocation_id(rs.getInt(1));
				location.setStreet_address(rs.getString(2));
				location.setPostal(rs.getString(3));
				location.setCity(rs.getString(4));
				location.setProvince(rs.getString(5));
				location.setCountryid(rs.getString(6));
				//System.out.println(location);
				locations.add(location);
			}
			//System.out.println(rs.getInt("location_id"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locations;

	}

	// select * from locations where location_id=? => all records => List<Locations>
	public Locations getLocationsById(String locationid)
	{
		String  sql="select * from locations where location_id=?";
		PreparedStatement statement;
		Locations location = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, locationid);
			ResultSet rs = statement.executeQuery();

			if(rs.next()) {
				location = new Locations();
				location.setLocation_id(rs.getInt(1));
				location.setStreet_address(rs.getString(2));
				location.setPostal(rs.getString(3));
				location.setCity(rs.getString(4));
				location.setProvince(rs.getString(5));
				location.setCountryid(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
	}
	public Long getLocationsCount()
	{
		String  sql="select count(*) from locations";
		long count = 0;
		PreparedStatement statement;
	
		try {
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				count = rs.getLong(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
