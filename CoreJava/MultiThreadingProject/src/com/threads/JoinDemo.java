package com.threads;

import java.util.ArrayList;
import java.util.List;

public class JoinDemo extends Thread {

	List<Integer> list;
	
	public JoinDemo(String name) {
		super(name);
		this.list = new ArrayList<Integer>();
		list.add(Integer.parseInt(""+name.charAt(1)));
	}
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("T1"))
			for(int i=1;i<=10;i++) {
				System.out.println(Thread.currentThread().getName()+" "+ i*i);
				list.add(i*i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		if(Thread.currentThread().getName().equals("T2"))
			for(int i=1;i<=10;i++) {
				System.out.println(Thread.currentThread().getName()+" "+i*i*i);
				list.add(i*i*i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public static void main(String[] args) throws InterruptedException {
		JoinDemo d1 = new JoinDemo("T1");
		JoinDemo d2 = new JoinDemo("T2");
		
		System.out.println(d1.list);
		System.out.println(d2.list);
		d1.start();
		d2.start();
		//Thread.sleep(2000);
		d1.join();
		System.out.println("main ends");
		System.out.println(d1.list); // 10
		System.out.println(d2.list); // 10
	}
}
