package com.objetcs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ReadWriteStudentObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter roll no");
		int rno = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		int marks[] = new int[5];
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Enter marks "+ (i+1));
			marks[i] = sc.nextInt();
		}
		
		Student student = new Student(rno, name, marks);
		Student st[] = new Student[3];
		st[0] = student;
		st[1] = student;
		st[2] = student;
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("studentobj.txt"));
		
		// serialization is a process of converting the java objects to stream understandable format[bytes]
		objectOutputStream.writeObject(st);
		objectOutputStream.close();
//		
		
		// deserialization
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("studentobj.txt"));
		Student[] s1 = (Student[]) objectInputStream.readObject();
		System.out.println(s1);
		objectInputStream.close();
	}

}
