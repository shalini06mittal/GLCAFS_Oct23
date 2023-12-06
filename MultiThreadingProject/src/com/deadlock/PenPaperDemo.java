package com.deadlock;

public class PenPaperDemo {

	public static void main(String[] args) {
		
		Class1 ob1 = new Class1();
		Class2 ob2 = new Class2();
		
		Thread1 t1 = new Thread1(ob1,ob2);
		Thread t2 = new Thread( new Thread2(ob1,ob2));
		
		t1.start();
		t2.start();
	}
		
		
}