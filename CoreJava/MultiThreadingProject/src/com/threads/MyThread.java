package com.threads;

/**
 * 1. Create a class of type Thread: extends Thread
 * 2. Override the run() method : is the only  place where you specify the task to be performed by the thread
 * 3. Create object of your thread class
 * 4. Call the start() method: DO NOT CALL THE run() method 
 */
public class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" in run");
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" end run");
	}
	
}
