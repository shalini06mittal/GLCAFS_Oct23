package model;

public class LineItem {
	
	private Item item;
	private Order order;
	private double price;
	private int qty;
	
	public LineItem() {
		// TODO Auto-generated constructor stub
	}

	public LineItem(Item item, Order order, double price, int qty) {
		super();
		this.item = item;
		this.order = order;
		this.price = price;
		this.qty = qty;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "LineItem [item=" + item + ", order=" + order + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}
