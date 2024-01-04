package model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	
	private String orderid;
	private Customer customer;
	private String deliveryaddrr;
	private LocalDateTime orderdate;
	private LocalDateTime deliverydate;
	private double ordertotal;
	private double ordertax;
	private boolean status;
	private List<LineItem> lineitems;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	
	public Order(String orderid, Customer customer, String deliveryaddrr, LocalDateTime orderdate,
			LocalDateTime deliverydate, double ordertotal, double ordertax, boolean status) {
		super();
		this.orderid = orderid;
		this.customer = customer;
		this.deliveryaddrr = deliveryaddrr;
		this.orderdate = orderdate;
		this.deliverydate = deliverydate;
		this.ordertotal = ordertotal;
		this.ordertax = ordertax;
		this.status = status;
	}
	

	public List<LineItem> getLineitems() {
		return lineitems;
	}


	public void setLineitems(List<LineItem> lineitems) {
		this.lineitems = lineitems;
	}


	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliveryaddrr() {
		return deliveryaddrr;
	}

	public void setDeliveryaddrr(String deliveryaddrr) {
		this.deliveryaddrr = deliveryaddrr;
	}

	public LocalDateTime getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDateTime orderdate) {
		this.orderdate = orderdate;
	}

	public LocalDateTime getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(LocalDateTime deliverydate) {
		this.deliverydate = deliverydate;
	}

	public double getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}

	public double getOrdertax() {
		return ordertax;
	}

	public void setOrdertax(double ordertax) {
		this.ordertax = ordertax;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", customer=" + customer + ", deliveryaddrr=" + deliveryaddrr
				+ ", orderdate=" + orderdate + ", deliverydate=" + deliverydate + ", ordertotal=" + ordertotal
				+ ", ordertax=" + ordertax + ", status=" + status + "]";
	}
	

}
