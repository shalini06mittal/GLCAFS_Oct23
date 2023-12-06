package com.deadlock;

public class DeadLockDemo {

	public static void main(String[] args) {
		final Friend alphonse =
				new Friend("Alphonse");
		final Friend gaston =
				new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() { alphonse.bow(gaston); }
		}).start();
		new Thread(new Runnable() {
			public void run() { gaston.bow(alphonse); }
		}).start();
	}

}

class Friend {
	private final String name;
	public Friend(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void bow(Friend bower) {
		System.out.println(Thread.currentThread().getName()+" "+getName());
		Friend first, second;
		if (getName().compareTo(bower.getName()) > 0) {
			System.out.println(Thread.currentThread().getName()+"if");
			first = this;
			second = bower;
			System.out.println("--------"+first.getName());
		} else {
			System.out.println(Thread.currentThread().getName()+"else");
			first = bower;
			second = this;
			System.out.println("--------"+first.getName());
		}
		System.out.println(first.getName());
		synchronized (first) {
			System.out.format("%s: %s"
					+ "  has bowed to me!%n", 
					this.name, bower.getName());
			synchronized (second) {
				bower.bowBack(this);
			}

		}

	}
	public void bowBack(Friend bower) {
		synchronized (this) {
			System.out.format("%s: %s"
					+ " has bowed back to me!%n",
					this.name, bower.getName());
		}

	}
}
//class Friend {
//	private final String name;
//	public Friend(String name) {
//		this.name = name;
//	}
//	public String getName() {
//		return this.name;
//	}
//	public synchronized void bow(Friend bower) {
//		System.out.format("%s: %s"
//				+ "  has bowed to me!%n", 
//				this.name, bower.getName());
//		bower.bowBack(this);
//	}
//	public synchronized void bowBack(Friend bower) {
//		System.out.format("%s: %s"
//				+ " has bowed back to me!%n",
//				this.name, bower.getName());
//	}
//}