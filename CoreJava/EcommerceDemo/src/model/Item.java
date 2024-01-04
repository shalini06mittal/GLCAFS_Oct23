package model;

public class Item {

	private String itemid;
	private String itemname;
	private String manufacturer;
	private double price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String itemid, String itemname, String manufacturer, double price) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", manufacturer=" + manufacturer + ", price="
				+ price + "]";
	}
	
}
