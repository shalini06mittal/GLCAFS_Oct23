package com.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// file or DB handling provides with a persistence mechanism
// to be able to store data permanently
public class FileDemo {

	public static void main(String[] args)  {

		/*
		 * 1. open the file : r/w/a
		 * 2. read / write
		 * 3. save
		 * 4. close
		 */
		// relative path
		File file = new File("/Users/Shalini/Documents/Citius_backup/corejava/ppt/demo1.txt");
		System.out.println(file.exists());
		try {
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.isDirectory());
		System.out.println(file.length());
		System.out.println(file.lastModified());
		System.out.println(file.isFile());
		System.out.println("asdlkjas");
//		String name, email, pwd;
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Choose: \n1. Login\n2. Register");
//		int choice = sc.nextInt();
//		switch (choice) {
//		case 1:
//			System.out.println("Please Login");
//			System.out.println("enter email");
//			email = sc.next();
//			System.out.println("enter pwd");
//			pwd = sc.next();
//			if(email.equals("user@user.com") && pwd.equals("user"))
//				System.out.println("Login success");
//			else 
//				System.out.println("Login failure");
//			break;
//		case 2:
//			System.out.println("Please register");
//			System.out.println("enter name");
//			name = sc.next();
//			System.out.println("enter email");
//			email = sc.next();
//			System.out.println("enter pwd");
//			pwd = sc.next();
//			System.out.println("Welcome "+name+" is registered successfully..");
//			break;
//		default:
//			break;
//		}





	}

}
