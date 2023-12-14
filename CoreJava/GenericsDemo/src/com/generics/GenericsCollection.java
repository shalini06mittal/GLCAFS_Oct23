package com.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsCollection {

	// generics information is not preserved at runtime
	
	// type erasure
	public static void display(List list) {
		
		list.add(true);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		
		// type inference
		
		List<Integer> nos = new ArrayList<>();
		
		List<Integer> d1 = new ArrayList<Integer>();
		d1.add(10);
		d1.add(20);
		d1.add(30);
		d1.add(40);
		
		List<String> d2 = new ArrayList<String>();
		d2.add("Apples");
		d2.add("Banana");
		d2.add("Oranges");
		
		// compile time
		d1.add(12);
		display(d1);
		display(d2);
		System.out.println();
		System.out.println(d1);
		System.out.println(d2);
		
//		List<Integer> l1 = Arrays.asList(1,2,3,4);
//		
//		List<Number> l2 = Arrays.asList(5,6,7);
//		
//		List<Double> l3 = Arrays.asList(1.2, 3.4);
//		
//		printNumberOrSubType(l1);
//		printNumberOrSubType(l2);
//		printNumberOrSubType(l3);
//		
//		printInetgerOrSuperType(l1);
//		printInetgerOrSuperType(l2);
		//printInetgerOrSuperType(l3);

	}
	// ? wildcard upperbound
	public static void printNumberOrSubType(List<? extends Number> list)
	{
		System.out.println(list);
	}
	// ? lower bound
	public static void printInetgerOrSuperType(List<? super Integer> list)
	{
		System.out.println(list);
	}

}
