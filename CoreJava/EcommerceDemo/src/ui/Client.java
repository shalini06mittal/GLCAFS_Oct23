package ui;

import java.sql.SQLException;

import database.CustomerDatabase;
import database.DBConnection;
import database.OrderDatabase;
import model.Customer;
import model.LineItem;
import model.Order;
import service.CustomerService;

public class Client {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		CustomerDatabase database = new CustomerDatabase();


		Customer customer = new Customer();
		customer.setCname("Rohan");
		customer.setCity("Hyderabad");
		customer.setCountry("India");
		customer.setEmail("rohan@hcl.com");
		customer.setGst("GST97997RN");
		customer.setPassword("rohan");
		customer.setPhone("7676767676");
		//database.insertCustomer(customer);
		System.out.println();
		for(Customer customer1 : database.getAllCustomers())
			System.out.println(customer1);
		//System.out.println(database.getCustomersBbyId(1));

		System.out.println("######################");
		OrderDatabase orderDatabase = new OrderDatabase();
		for(Order order : orderDatabase.getOrderDetailsForCustomer1(1))
		{
			System.out.println("\n-----------------------------------------------------------------------------------------------\n");
			System.out.println("Order Id "+order.getOrderid());
			System.out.println("Customer Id "+order.getCustomer().getCustomerid());
			System.out.println("Delivery Address "+order.getDeliveryaddrr());
			System.out.println("Order date "+order.getOrderdate());
			System.out.println("Delivery date "+order.getDeliverydate());
			for(LineItem item : order.getLineitems())
			{
				System.out.println("Item "+ item.getItem().getItemid()+" Qty "+item.getQty()+" Price "+item.getPrice());
			}
			System.out.println();
			System.out.println("Total "+order.getOrdertotal());
			System.out.println("Status "+order.isStatus());
			System.out.println("\n-----------------------------------------------------------------------------------------------\n");

		}
		System.out.println();
		System.out.println("######################");
		CustomerService service = new CustomerService();
		for(Order order : service.getAllOrderForCustomer(4))
		{
			System.out.println("\n-----------------------------------------------------------------------------------------------\n");
			System.out.println("Order Id "+order.getOrderid());
			System.out.println("Customer Id "+order.getCustomer().getCustomerid());
			System.out.println("Delivery Address "+order.getDeliveryaddrr());
			System.out.println("Order date "+order.getOrderdate());
			System.out.println("Delivery date "+order.getDeliverydate());
			for(LineItem item : order.getLineitems())
			{
				System.out.println("Item "+ item.getItem().getItemid()+" Qty "+item.getQty()+" Price "+item.getPrice());
			}
			System.out.println();
			System.out.println("Total "+order.getOrdertotal());
			System.out.println("Status "+order.isStatus());
			System.out.println("\n-----------------------------------------------------------------------------------------------\n");

		}
		System.out.println("######################");
		System.out.println(orderDatabase.getNextOrderid());
	}

}
