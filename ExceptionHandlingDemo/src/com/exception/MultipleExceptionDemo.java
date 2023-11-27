package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleExceptionDemo {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter position 0 -4");
		
		/**
		 * a block throws more than 1 type of exception
		 * multiple catch blocks
		 * 1. try has to follow either a catch or a finally block
		 * 2. If try block is followed by a catch then finally should be in the last
		 * 3.There can be more than 1 catch blocks but only 1 finally block for a try
		 * 4. If your code has multiple try there can be finally block for each try
		 * 5. Always handle the specific exceptions before the generalized or super class exception
		 */
		try {
			int pos = sc.nextInt();//0, 5
			int no = a[pos]; // 1 , ArrayIndexOutofBounds?
			System.out.println(no / 0); // 1/0=> ArithmeticException
		}
//		catch(ArithmeticException e) {
//			System.out.println("Cannot divide by 0");
//		}
//		catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("TRrying to access a value out of range");
//		}
		catch(RuntimeException e) { // parent class
			System.out.println("Value should be integer between 0-4");
		}
		
		System.out.println(4+5);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] * a[i]);
		}
		
		
		
		

	}
}
