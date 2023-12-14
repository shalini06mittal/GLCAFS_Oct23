package com.interthreadcomm;
/*
 C1 is waiting
P1 1
C2 is waiting
C1 1
C2 is waiting
C1 is waiting
P1 2
C1 is waiting
C2 2
P1 3
C1 3
C2 is waiting
C1 is waiting
P1 4
C2 4
C1 is waiting
C2 is waiting
P1 5
C1 5
C2 is waiting
C1 is waiting
 */
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
		notifyAll();
		
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
		notifyAll();
		return num;
	}
	
	public static void main(String[] args) {
		Shop s = new Shop();
		Consumer c1 = new Consumer(s, "C1");
		Consumer c2 = new Consumer(s, "C2");
		Producer p1 = new Producer(s, "P1");
	}
	

}
