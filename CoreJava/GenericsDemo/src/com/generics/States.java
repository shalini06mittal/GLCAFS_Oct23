package com.generics;

public class States implements Comparable<States>{
	// 1.1 accommodate state name and statecode
	private String statename;
	private String statecode;
	
	// 1.2 use getters to access the value
	public String getStatename() {
		return statename;
	}
	public String getStatecode() {
		return statecode;
	}
	
	// 1.3 sort given object arraylist in ascending order based on state name
	
	@Override
	public int compareTo(States o) {
		// TODO Auto-generated method stub
		return this.getStatename().compareTo(o.getStatename());
	}
	public States(String statename, String statecode) {
		super();
		this.statename = statename;
		this.statecode = statecode;
	}
	
	// 1.4 constructor to get the values from user
	
	}
