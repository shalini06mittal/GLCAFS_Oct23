package com.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestGenerics {

	public static <T> void printData(T data[]) {
		for(Object ob:data)
			System.out.println(ob);
	}
	public static void main(String[] args) {
		MyGenerics<Integer> ob1 = new MyGenerics<Integer>();
		ob1.setObject(10);
		System.out.println(ob1);
		
		MyGenerics<String> ob2 = new MyGenerics<>();
		ob2.setObject("Hello");
		System.out.println(ob2);
		
		MyGenerics<Student> ob3 = new MyGenerics<>();
		Student s1 = new Student();
		s1.setSid(1);
		s1.setName("Ajay");
		ob3.setObject(s1);
		System.out.println(ob3);

		MyGenerics2<Integer, String, Integer> ob5 = new MyGenerics2<Integer, String, Integer>();
		ob5.setA(10);
		ob5.setObject(100);
		ob5.setV("soem adat");
		
		BoundedGenerics<Integer> ob4 = new BoundedGenerics<Integer>();
		ob4.setData(100);
		System.out.println(ob4.getData());
		
		Byte b1 = Byte.valueOf("10");
		//BoundedGenerics<String> ob5 = new BoundedGenerics<>();
//		ob5.setData(b1);
//		System.out.println(ob5.getData());
		
		printData(new Integer[] {1,2,3,4,5});
		printData(new String[] {"Apples","Oranges","Banana"});
		
		List<Student> list = new ArrayList<>();
		Collections.sort(list);
	}

}
