package com.threads;

public class TestEmp {

	public static void main(String[] args) {
		
		Emp e1 = new Emp(1);
		Emp e2 = new Emp();
		e2.setEid(2);
		
		Dev d1 = new Dev();
		d1.setEid(1);
		Dev d2 = new Dev(2);
	}

}

class Dev extends Emp{
	
	public Dev() {
		// TODO Auto-generated constructor stub
	}
	public Dev(int eid) {
		// TODO Auto-generated constructor stub
		super(eid);
	}
}
