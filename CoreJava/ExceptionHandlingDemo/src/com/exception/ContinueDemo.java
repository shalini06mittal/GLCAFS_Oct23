package com.exception;

public class ContinueDemo {

	public static void main(String[] args) {
		/*
		 * break => will stop the iteration/ loop if the condition is true
		 * continue=> skip for the iteration when the condition is true
		 */
		for(int i=1;i<=10;i++) {
			if(i%2 == 0)
				 continue;
			System.out.println(i*i);
		}
		
		System.out.println("main ends");
	}

}
