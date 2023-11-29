package com.objetcs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteStudentData {

	public static void main(String[] args) throws IOException {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter roll no");
//		int rno = sc.nextInt();
//		System.out.println("Enter name");
//		String name = sc.next();
//		int marks[] = new int[5];
//		for (int i = 0; i < marks.length; i++) {
//			System.out.println("Enter marks "+ (i+1));
//			marks[i] = sc.nextInt();
//		}
//		
//		Student student = new Student(rno, name, marks);
//		
//		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("student.txt"));
//		dataOutputStream.writeInt(student.getRollno());
//		dataOutputStream.writeUTF(name);
//		for (int i = 0; i < marks.length; i++) {
//			dataOutputStream.writeInt(marks[i]);
//		}
//		dataOutputStream.close();
		
		DataInputStream inputStream = new DataInputStream(new FileInputStream("student.txt"));
		System.out.println(inputStream.readInt());
		System.out.println(inputStream.readUTF());
		for (int i = 1; i <= 5; i++) 
			System.out.println(inputStream.readInt());
		inputStream.close();
	}

}
