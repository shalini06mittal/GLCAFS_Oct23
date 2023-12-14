package com.deadlock;

public class Thread1 extends Thread{

	private Class1 obj1;
	private Class2 obj2;
	public Thread1(Class1 obj1, Class2 obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	@Override
	public void run() {
		synchronized (obj1) {
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("Got Pen, now waiting for paper "+obj1.getI());
			synchronized (obj2) {
				System.out.println("Got paper also "+obj2.getI());
			}
		}
	}
}

