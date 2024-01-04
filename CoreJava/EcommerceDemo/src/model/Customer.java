package model;

public class Customer {
	
	private int customerid;
	private String cname;
	private String country;
	private String email;
	private String phone;
	private String password;
	private String gst;
	private String city;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer( String cname, String country, String email, String phone, String password,
			String gst, String city) {
		this.cname = cname;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.gst = gst;
		this.city = city;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", cname=" + cname + ", country=" + country + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", gst=" + gst + ", city=" + city + "]";
	}
	
	

}
