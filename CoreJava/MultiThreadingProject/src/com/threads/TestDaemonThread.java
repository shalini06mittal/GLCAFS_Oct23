package com.threads;

public class TestDaemonThread {

	public static void main(String[] args) {
		/*
		 * by default thread execute in background 
		 * even if the main thread stops execution
		 * 
		 * daemon threads run only till the main thread is running.
		 * it stops the moment main stops
		 */
		DaemonThread d1 = new DaemonThread();
		Thread t1 = new Thread(d1);
		t1.setDaemon(true);
		t1.setName("R1");
		
		
		MyThread t2 = new MyThread();
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		
		for(int i=1;i<=5;i++)
		{
			System.out.println(i+" "+ Math.sqrt(i));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main ends");
	}

}
