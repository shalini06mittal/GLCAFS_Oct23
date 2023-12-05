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
	public void withdraw(double amount) {
		System.out.println(Thread.currentThread().getName()+" in withdraw");
		double bal = getBalance();
		if(amount > bal) {
			System.out.println("cannot withdraw");
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
		System.out.println(Thread.currentThread().getName()+" after withdraw "+balance);
	}
}
