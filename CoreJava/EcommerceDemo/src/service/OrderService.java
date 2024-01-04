package service;

import database.OrderDatabase;

public class OrderService {
	
	OrderDatabase orderDatabase ;
	public  OrderService(OrderDatabase orderDatabase)
	{
		this.orderDatabase = orderDatabase;
	}
	

}
