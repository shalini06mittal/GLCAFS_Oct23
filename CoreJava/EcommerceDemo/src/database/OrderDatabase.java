package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Item;
import model.LineItem;
import model.Order;

public class OrderDatabase {

	private static Connection conn =  DBConnection.getConnection();
	LineItemDataBase lineItemDataBase = new LineItemDataBase();

	// get the list of all the orders placed by the customer from the order_table
	public List<Order> getOrdersForCustomer(int cid) throws SQLException
	{
		List<Order> orders = new ArrayList<Order>();

		String sql = "select o.order_id, o.customer_id, o.delivery_address, o.order_date"
				+ ",o.delivery_date, o.order_total, o.status "
				+ "from order_table o "
				+ "where o.customer_id = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, cid);
		ResultSet rs = statement.executeQuery();
		while(rs.next())
		{
			Order order = new Order();
			order.setOrderid(rs.getString(1));
			Customer customer = new Customer();
			customer.setCustomerid(rs.getInt(2));
			order.setCustomer(customer);
			order.setDeliveryaddrr(rs.getString(3));
			order.setOrderdate(rs.getTimestamp(4).toLocalDateTime());
			order.setDeliverydate(rs.getTimestamp(5).toLocalDateTime());
			order.setOrdertotal(rs.getDouble(6));
			order.setStatus(rs.getBoolean(7));
			orders.add(order);	
		}

		return orders;

	}

	public List<Order> getOrderDetailsForCustomer(int cid) throws SQLException
	{
		List<Order> orders = new ArrayList<Order>();

		String sql = "select o.order_id, o.customer_id, o.delivery_address, o.order_date"
				+ ",o.delivery_date, o.order_total, l.item_id, l.qty, l.price "
				+ "from order_table o, lineitem l "
				+ "where o.customer_id = ? and o.order_id = l.order_id";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, cid);
		ResultSet rs = statement.executeQuery();
		Order order = null;
		while(rs.next())
		{
			//System.out.println(rs.getString(1));
			if(order == null)
				order = newOrder(rs);
			else if(order.getOrderid().equals(rs.getString(1)))
			{
				LineItem lineItem = new LineItem();
				Item item = new Item();
				item.setItemid(rs.getString(7));
				lineItem.setItem(item);
				lineItem.setQty(rs.getInt(8));
				lineItem.setPrice(rs.getDouble(9));
				order.getLineitems().add(lineItem);
			}
			else {
				orders.add(order);
				order = newOrder(rs);
			}
		}

		if(order!=null)
			orders.add(order);
		System.out.println(orders.size());
		return orders;

	}
	
	public List<Order> getOrderDetailsForCustomer1(int cid) throws SQLException
	{
		List<Order> orders = getOrdersForCustomer(cid);
		for(Order order: orders) {
			List<LineItem> lineItems = lineItemDataBase.getAllItemsByOrderId(order.getOrderid());
			order.setLineitems(lineItems);
		}
		return orders;

	}

	public Order newOrder(ResultSet rs) throws SQLException
	{
		Order order = new Order();
		order.setOrderid(rs.getString(1));
		Customer customer = new Customer();
		customer.setCustomerid(rs.getInt(2));
		order.setCustomer(customer);
		order.setDeliveryaddrr(rs.getString(3));
		order.setOrderdate(rs.getTimestamp(4).toLocalDateTime());
		order.setDeliverydate(rs.getTimestamp(5).toLocalDateTime());
		order.setOrdertotal(rs.getDouble(6));
		LineItem lineItem = new LineItem();
		Item item = new Item();
		item.setItemid(rs.getString(7));
		lineItem.setItem(item);
		lineItem.setQty(rs.getInt(8));
		lineItem.setPrice(rs.getDouble(9));
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(lineItem);
		order.setLineitems(lineItems);
		return order;
	}

	public String getNextOrderid()
	{
		String sql = "SELECT max(cast(substring(order_id,2) as unsigned)) FROM `order_table` ";
		PreparedStatement statement = null;
		ResultSet rs = null;
		int maxorderid= 0;
		String orderid="";
		try {
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			if(rs.next()) {
				maxorderid = rs.getInt(1);
				maxorderid++;
				if(maxorderid <10)
					orderid = "O00" + maxorderid;
				else
					orderid = "O0" + maxorderid;
			}
			else
				orderid="O001";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return orderid;
		
	}
	public Order insertNewOrder(Order neworder )  {

		neworder.setOrderid(getNextOrderid());
		String sql = "insert into order_table values(?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, neworder.getOrderid());
			statement.setInt(2, neworder.getCustomer().getCustomerid());
			statement.setString(3, neworder.getDeliveryaddrr());
			statement.setDate(4, Date.valueOf(neworder.getOrderdate().toLocalDate()));
			statement.setDate(5, Date.valueOf(neworder.getDeliverydate().toLocalDate()));
			statement.setDouble(6, neworder.getOrdertotal());
			statement.setDouble(7, neworder.getOrdertax());
			statement.setBoolean(8, neworder.isStatus());
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return neworder;
	}

}
