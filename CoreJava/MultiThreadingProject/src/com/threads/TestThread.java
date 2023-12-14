package com.threads;

public class TestThread {
	// every java application is a single threaded application
	// single thread => main
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" in main");
		MyThread t1 = new MyThread();
		t1.setName("T1");
		// never call the run() method manually. It is invoked internally by the JVM
		//t1.run(); 
		t1.start();
		MyThread t2 = new MyThread();
		t2.setName("T2");
		t2.start();
		// cannot start an already started thread
		//		try {
		//			//t1= new MyThread();
		//			t1.start();
		//		}catch(IllegalThreadStateException e)
		//		{
		//			System.out.println("error");
		//		}
		System.out.println("main ends");
		

	}

}
