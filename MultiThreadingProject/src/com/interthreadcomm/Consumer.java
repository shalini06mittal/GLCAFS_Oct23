package com.interthreadcomm;

public class Consumer extends Thread{
	
	Shop s;
	
	public Consumer(Shop s, String name) {
		super(name);
		this.s = s;
		start();
	}
	
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread().getName()+" "+s.get());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
