package com.objetcs;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Create a class Student to store rollno, name and marks of 5 subjects.
Take input for 5 students from the user and save every student record as 1 line in the file.
Store the information with space separated . For ex for student 1
1 Shalini 89 90 88 76 67

Ask the user rollno of the student whose data it needs. Read the contents from the file and display the details of that student . Also diplay the total and average marks of this student

 * @author Shalini
 *
 */
public class Student implements Serializable{
	
	private int rollno;
	private String name;
	private int marks[];
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int rollno, String name, int marks[]) {
		super();
		this.rollno = rollno;
		this.name = name;
		
		this.marks = marks;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + Arrays.toString(marks) + "]";
	}
	
	

}
