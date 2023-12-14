package com.deadlock;

public class Thread2 implements Runnable{
	private Class1 obj1;
	private Class2 obj2;
	public Thread2(Class1 obj1, Class2 obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	@Override
	public void run() {
		synchronized (obj2) {
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("Got paper, now waiting for pen "+obj2.getI());
			synchronized (obj1) {
				System.out.println("Got pen also "+obj1.getI());
			}
		}
	}
}

