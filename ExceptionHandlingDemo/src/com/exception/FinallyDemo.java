package com.exception;

import java.util.Scanner;

public class FinallyDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 nos");
		int x = sc.nextInt();
		int y = sc.nextInt();
		Calculator ob = new Calculator();
		// finally is a block that comes always at the end of try
		// try can be followed by catch or finally
		// But if try is followed by catch then finally should always be in the last
		// there can be only 1 finally for a try
		// try-fianlly ir try-catch-catch-finally
		/**
		 * finally is a block that is always executed 
		 * irrespective exception or not, as well as irrespective your code
		 * handled the exception
		 * 
		 * Input output operations
		 * finally is a block where you actually release or close resources
		 * 
		 */
		try {
			System.out.println("Div "+ob.div(x, y));
		}
		catch(ArithmeticException e) {
			System.out.println("Please provide deniminator other than 0");
		}
		finally {
			System.out.println("finally");
			sc.close();
		}

		System.out.println("Main ends");


	}

}
