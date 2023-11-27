package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NextedExceptionDemo {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter position 0 -4");
		// nested try-catch
//		try {
//			int pos = sc.nextInt();//5
//			try {
//				int no = a[pos]; // 1 , ArrayIndexOutofBounds?
//				System.out.println(no / 0); // 1/0=> ArithmeticException
//			}
//			catch(ArithmeticException e) {
//				System.out.println("Cannot divide by 0");
//			}
//
//			catch(ArrayIndexOutOfBoundsException e) {
//				System.out.println("TRrying to access a value out of range");
//			}
//			System.out.println("Enter a string");
//			String str = sc.next();
//			System.out.println(str.charAt(pos));
//		}
//		catch(InputMismatchException e) {
//			System.out.println("Input should be integer between 0-4");
//		}
//		catch(Exception e) { // parent class
//			System.out.println(e.getMessage());
//		}


		try {
			int pos = sc.nextInt();//5
			int no=0;
			try {
				no = a[pos]; // 1 , ArrayIndexOutofBounds?
				try {
					System.out.println(no / 0); // 1/0=> ArithmeticException
				}
				catch(ArithmeticException e) {
					System.out.println("Cannot divide by 0");
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("TRrying to access a value out of range");
			}
			System.out.println("Enter a string");
			String str = sc.next();
			System.out.println(str.charAt(pos));
		}
		catch(InputMismatchException e) {
			System.out.println("Input should be integer between 0-4");
		}
		catch(Exception e) { // parent class
			System.out.println("Parent class handles all unhandled exception");
			System.out.println(e.getMessage());
		}

		System.out.println(4+5);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] * a[i]);
		}





	}
}
