package database;

import java.sql.Connection;
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
			order.setOrdertax(rs.getDouble(6));
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
	
	public Order insertOrder(int customerid, Order neworder, List<LineItem> items ) throws SQLException {
		Order order = new Order();
		String sql = "select order_id from order_table order by order_id limit 1";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		
		
		return order;
	}

}
