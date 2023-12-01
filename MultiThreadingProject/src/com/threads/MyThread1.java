package com.threads;

/**
 * 1. Create a class that implements Runnable interface
 * 2. override the run() - specify the task thread will do
 * 3. Create an object of your class
 * 4. Pass this object to the Thread class
 * 5. start the thread
 */
public class MyThread1 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(char ch='A';ch<='F';ch++)
		{
			System.out.println(ch);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
