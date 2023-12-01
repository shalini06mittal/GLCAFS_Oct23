package com.threads;

public class Test {

	public static void main(String[] args) {
		
		/*
		 * Thread 1 responsible to send squares in a file sq.txt
		 */
		for (int i = 1; i <=5; i++) {
			System.out.println(i*i);
		}
		/*
		 * Thread 1 responsible to send cubes in a file cube.txt
		 */
		for (int i = 1; i <=5; i++) {
			System.out.println(i*i*i);
		}

		
	}

}
