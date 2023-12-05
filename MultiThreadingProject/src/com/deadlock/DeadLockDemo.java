package com.deadlock;

public class DeadLockDemo {

	public static void main(String[] args) {
		Track track1 = new Track("Track 1");
		Track track2 = new Track("Track 2");

		Thread train1 = new Thread (new Runnable() {

			@Override
			public void run() {
				synchronized (track1) {
					track1.move();
					synchronized (track2) {
						track2.move();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread train2 = new Thread (new Runnable() {
			@Override
			public void run() {
//				synchronized (track2) {
//					track2.move();
//					try {
//						Thread.sleep(300);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					synchronized (track1) {
//						track1.move();
//					}
//				}
				synchronized (track1) {
					track1.move();
					synchronized (track2) {
						track2.move();
					}
				}
			}
		});
		train1.setName("Train 1");
		train2.setName("Train 2");
		train1.start();
		train2.start();
	}

}

class Track{
	private String name;

	public Track(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public void move() {
		System.out.println(Thread.currentThread().getName()+" moving on "+name);
	}
}