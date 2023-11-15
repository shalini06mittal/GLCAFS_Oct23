package com.test;

public class Product implements Comparable<Product>{

	private int pid;
	private String pname;
	private String description;
	private double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String pname, String description, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.description = description;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", description=" + description + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
//		return this.getPid() - o.getPid(); // asc
		return o.getPid() - this.getPid() ; // desc
	}
	
}
