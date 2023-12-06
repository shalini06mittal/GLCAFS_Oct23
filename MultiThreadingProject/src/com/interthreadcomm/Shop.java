package com.interthreadcomm;

public class Shop {

	int num;
	boolean flag = false;
	
	public synchronized void produce(int i) {
		while(flag) {
			
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.num = i;
		flag = true;
		notify();
		
	}

	public synchronized int get() {
		while(!flag) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = false;
		notify();
		return num;
	}
	
	public static void main(String[] args) {
		Shop s = new Shop();
		Consumer c1 = new Consumer(s, "C1");
//		Consumer c2 = new Consumer(s, "C2");
		Producer p1 = new Producer(s, "P1");
	}
	

}
