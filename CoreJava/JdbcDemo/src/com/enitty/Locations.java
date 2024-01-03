package com.enitty;

public class Locations {

	private int location_id;
	private String street_address;
	private String postal;
	private String city;
	private String province;
	private String countryid;
	
	public Locations() {
		// TODO Auto-generated constructor stub
	}

	public Locations(String street_address, String postal, String city, String province, String countryid) {
		super();
		this.street_address = street_address;
		this.postal = postal;
		this.city = city;
		this.province = province;
		this.countryid = countryid;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	@Override
	public String toString() {
		return "Locations [location_id=" + location_id + ", street_address=" + street_address + ", postal=" + postal
				+ ", city=" + city + ", province=" + province + ", countryid=" + countryid + "]";
	}
	
	
}
