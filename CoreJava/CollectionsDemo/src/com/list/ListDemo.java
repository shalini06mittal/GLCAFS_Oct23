package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.Employee;

public class ListDemo {

	public static void main(String[] args) {
		
		/**
		 * Wrapper classes
		 */
		
		int x = 20;
		ArrayList nos = new ArrayList();
		nos.add(10); // Integer
		nos.add(x);
		nos.add("Shalini");
		nos.add('c');
		nos.add(true);
		System.out.println(nos.size());
		nos.remove("Shalini");
		System.out.println(nos.size());
		
		// operation => sort the elements in the list?
		
		for(Object o : nos) {
			System.out.println(o);
		}
		for (int i = 0; i < nos.size(); i++) {
			System.out.println(nos.get(i));
		}
		
		Iterator iter = nos.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		// E , T, K, V
		
		// <> [ Diamond brackets ] generics
		ArrayList<Double> temperaturesInCel = new ArrayList<Double>();
		temperaturesInCel.add(30.12);
		temperaturesInCel.add(32.12);
		temperaturesInCel.add(31.12);
		temperaturesInCel.add(40.12);
		temperaturesInCel.add(35.32);
		
		
		ArrayList<Double> temperaturesInFah = new ArrayList<Double>();
		for(Double temp : temperaturesInCel)
		{
			temperaturesInFah.add(temp * 9 /5 + 32);
		}
		System.out.println(temperaturesInFah);
		Collections.sort(temperaturesInFah);
		System.out.println(temperaturesInFah);
		
		LinkedList<String> fruits = new LinkedList<>();
		fruits.add("Apples");
		fruits.add("Oranges");
		fruits.add("Banana");
		fruits.add("Grapes");
		fruits.add("Watermelons");
		fruits.add("Apricot");
		
		
		fruits.sort(null);
		System.out.println(fruits);
		System.out.println();
		
		
		for(String fruit:fruits) {
			if(fruit.startsWith("A"))
				System.out.println(fruit);
		}
		fruits.add(3, "Berries");
		System.out.println(fruits);
		fruits.addFirst("Chickoo");
		System.out.println(fruits);
		System.out.println(fruits.contains("Mangoes"));
		System.out.println(fruits.contains("Apples"));
		System.out.println(fruits.peek());
		System.out.println(fruits.set(1, "Mangoes"));
		System.out.println(fruits);
		fruits.subList(2,4).clear();
		System.out.println(fruits);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "Shalini", "Mumbai", "India"));
		list.add(new Employee(2, "Anuj", "Pune", "India"));
		list.add(new Employee(3, "Raju", "Mumbai", "India"));
		list.add(new Employee(4, "Vedant", "Delhi", "India"));
		list.add(new Employee(5, "Manas", "Chennai", "India"));
		
		for(Employee emp: list)
			System.out.println(emp.getEname());
		
		List<Character> vowels = Arrays.asList('a','e','i','o','u');
	}

}
