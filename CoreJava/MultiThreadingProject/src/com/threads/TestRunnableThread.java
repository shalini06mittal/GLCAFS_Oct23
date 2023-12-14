package com.threads;

public class TestRunnableThread {

	public static void main(String[] args) {
		
		MyThread1 r1 = new MyThread1();
		Thread t1 = new Thread(r1);
		t1.start();
	}

}
