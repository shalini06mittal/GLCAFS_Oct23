package com.sync;

public class Bank extends Thread{

	private Account account;
	private double amount;
	
	public Bank(Account account, String name, double amount) {
		super(name);
		this.account = account;
		this.amount = amount;
		start();
	}

	@Override
	public void run() {
		System.out.println(4+" "+Thread.currentThread().getName()+" in run");
		account.withdraw(amount);
	}

	public static void main(String[] args) {
		Account a1 = new Account();
		a1.setAid(1);
		a1.setBalance(5000);
		
		Account a2 = new Account();
		a2.setAid(2);
		a2.setBalance(15000);
		
		Bank b1 = new Bank(a1, "T1", 2000);
		Bank b2 = new Bank(a2, "T2", 5000);
		
	}

}
