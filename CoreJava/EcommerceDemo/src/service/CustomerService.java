package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.CustomerDatabase;
import database.LineItemDataBase;
import database.OrderDatabase;
import model.LineItem;
import model.Order;

public class CustomerService {

	CustomerDatabase customerDatabase = new CustomerDatabase();
	LineItemDataBase lineItemDataBase = new LineItemDataBase();
	OrderDatabase orderDatabase = new OrderDatabase();
	
	public List<Order> getAllOrderForCustomer(int cid) throws SQLException
	{
		List<Order> orders = new ArrayList<Order>();
		
		orders = orderDatabase.getOrdersForCustomer(cid);
		for(Order order: orders)
		{
			List<LineItem> items = new ArrayList<LineItem>();
			items = lineItemDataBase.getAllItemsByOrderId(order.getOrderid());
			order.setLineitems(items);
		}
		return orders;
	}
}
