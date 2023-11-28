package com.exception;

import java.util.Scanner;
/**
 * throw - used to manually throw an exception by the creator of the method
 * @author Shalini
 *
 */
public class ThrowThrowsDemo {

	// if code throws unchecked exception it is not mandatory to handle
	public static void calculate(int no) throws RuntimeException
	{
		if(no <= 0)
			throw new RuntimeException("input cannot be 0 or -ve");
		System.out.println(Math.sqrt(no));
	}
	// if code throws checked exception it is mandatory to handle either 
	// by the method that throws the excpetion
	// or by the caller of the method
	/**
	 * if a method throws a checked exception , then it has to inform the callers be rethrowing it
	 * using throws clause
	 * throw -> used to manually throw an exception by the method
	 * throws -> is applied at method declaration and used to inform the users about the exception 
	 * the method throws
	 * @param no
	 * @throws Exception
	 */
	public static void calculate1(int no) throws Exception
	{
		if(no <= 0)
			throw new Exception("input should be positive");
		System.out.println(Math.sqrt(no));
	}
	public static void display(int n) throws Exception
	{
		calculate1(n);
	}
	// starting point of the application or user interface
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a no");
		int no = sc.nextInt();//a
		try {
		calculate(no);
		}
		catch(RuntimeException e)
		{
			System.out.println(e.getMessage());
		}
		calculate(10);
		/**
		 * user of the method should either handle the exception using try-catch
		 * or rethrow using throws
		 */
		//calculate1(no);
		

			try {
				display(no);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
