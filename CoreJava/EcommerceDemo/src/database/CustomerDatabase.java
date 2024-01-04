package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDatabase {

	private static Connection con = DBConnection.getConnection();

	public List<Customer> getAllCustomers() throws SQLException
	{
		List<Customer> customers = new ArrayList<Customer>();
		String sql = "select  cust_name,customer_id,city, country,"
				+ "email, phone, gst from customer";
		// 3) statement
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next())
		{
			// i know m on mute 2mins
			// PLEASE COMPLETE THIS
			Customer customer = new Customer();
			customer.setCname(rs.getString(1));
			customer.setCustomerid(rs.getInt(2));

			customer.setCity(rs.getString(3));
			customer.setCountry(rs.getString(4));
			customer.setEmail(rs.getString(5));
			customer.setPhone(rs.getString(6));
			//customer.setPassword(rs.getString(7));
			customer.setGst(rs.getString(7));
			customers.add(customer);
		}
		return customers;
	}
	public Customer getCustomersBbyId(int id) throws SQLException
	{
		Customer customer = new Customer();
//		String sql = "select  cust_name,customer_id,city, country,"
//				+ "email, phone, gst from customer"
//				+ " where customer_id="+id;
		String sql = "select  cust_name,customer_id,city, country,"
				+ "email, phone, gst from customer"
				+ " where customer_id=?";
		//Statement statement = con.createStatement();
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next())
		{
			customer.setCname(rs.getString(1));
			customer.setCustomerid(rs.getInt(2));
			customer.setCity(rs.getString(3));
			customer.setCountry(rs.getString(4));
			customer.setEmail(rs.getString(5));
			customer.setPhone(rs.getString(6));
			//customer.setPassword(rs.getString(7));
			customer.setGst(rs.getString(7));
		}
		return customer;
	}
	/**
	 * customer_id
	 */
	public boolean insertCustomer(Customer customer) throws SQLException {
//		String statsql = "insert into customer values("+customer.getCustomerid()+",'"+customer.getCname()+"','";
//		Statement statement = con.createStatement();
		String prepstsql = "insert into customer(cust_name,city, country,email,phone,password,gst) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(prepstsql);
		//ps.setInt(1, customer.getCustomerid());
		ps.setString(1, customer.getCname());
		ps.setString(2, customer.getCity());
		ps.setString(3, customer.getCountry());
		ps.setString(4, customer.getEmail());
		ps.setString(5, customer.getPhone());
		ps.setString(6, customer.getPassword());
		ps.setString(7, customer.getGst());
		ps.executeUpdate();// commit
		return true;
	}
	// update customer set cname=?, city=? from customer where customer_id=?
	// 1, cname
	// 2, city
	// 3, id
	// update customer city

}












