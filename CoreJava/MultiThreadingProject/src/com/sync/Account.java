package com.sync;

public class Account {

	private int aid;
	private double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void display() {
		System.out.println(Thread.currentThread().getName()+" in display");
	}
//	public synchronized void withdraw(double amount) {
//		System.out.println(1+" "+Thread.currentThread().getName()
//				+" in withdraw");
//		
//			double bal = getBalance();
//			if(amount > bal) {
//				System.out.println(2+" cannot withdraw");
//			}
//			else {
//				double rembalance = bal - amount;
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				setBalance(rembalance);
//			}
//			System.out.println(3+" "+Thread.currentThread().getName()
//					+" after withdraw "+balance);
//		
//	}
	
	public void withdraw(double amount) {
		System.out.println(1+" "+Thread.currentThread().getName()
				+" in withdraw");
		//synchronized (this) {
			System.out.println(Thread.currentThread().getName()
					+" sync block");
			double bal = getBalance();
			if(amount > bal) {
				System.out.println(2+" cannot withdraw");
			}
			else {
				double rembalance = bal - amount;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setBalance(rembalance);
			}
			System.out.println(3+" "+Thread.currentThread().getName()
					+" after withdraw "+balance);
			
		//}
			
		
	}
}
