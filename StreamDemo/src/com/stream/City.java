package com.stream;

import java.time.LocalDate;

public class City {

	private String name;
	private double temp;
	private LocalDate date;
	public City() {
		// TODO Auto-generated constructor stub
	}
	public City(String name, double temp, LocalDate date) {
		super();
		this.name = name;
		this.temp = temp;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
