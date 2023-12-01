package com.threads;

public class DaemonThread implements Runnable {

	@Override
	public void run() {
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+ (i*i));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
