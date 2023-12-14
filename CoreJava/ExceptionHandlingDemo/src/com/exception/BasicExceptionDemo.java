package com.exception;

import java.util.Scanner;

public class BasicExceptionDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 nos");
		int x = sc.nextInt();
		int y = sc.nextInt();
		Calculator ob = new Calculator();
		System.out.println("Add "+ob.add(x, y));
		System.out.println("Sub "+ob.sub(x, y));
		/*
		 * exception handling mechanisms
		 * try executing a block of code
		 * if block throws an exception then catch it
		 * try, catch, finally, throw, throws, user defined exceptions
		 */
		try {
			System.out.println("Div "+ob.div(x, y));
		}
		catch(ArithmeticException e) {
			System.out.println("Please provide deniminator other than 0");
		}
		System.out.println("Mul "+ob.mul(x, y));

	}

}
