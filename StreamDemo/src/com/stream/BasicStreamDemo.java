package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class BasicStreamDemo {
	
	
	public static void f1()
	{
		for(int i=1;i<=100;i++)
		{
			int n = i*i;
		}
	}

	public static void main(String[] args) {
		List<Integer> nos = new ArrayList<Integer>();
		nos.add(10);
		nos.add(4);
		nos.add(2);
		nos.add(3);
		nos.add(6);
		nos.add(5);
		nos.add(3);
		nos.add(6);
		
//		for(int i=0;i<nos.size();i++)
//			System.out.println(nos.get(i));
//		
//		for(int no: nos)
//			System.out.println(no);
//		
		//nos.forEach(d -> System.out.println(d));
		
		// intermediate[just tell what you want] + terminal[final execution]
		/**
		 * create a list to store square of number from the list nos
		 */
		List<String> squares = new ArrayList<>();
		
		for(int no: nos)
		{
			/**
			 * get a value from the list and converting it to another format
			 * transformation
			 */
			int temp = no * no;
			squares.add(no+" : "+temp);
		}
//		System.out.println(squares);
		
		Stream<Integer> distinct = nos.stream().distinct();
		//distinct.forEach(n-> System.out.println(n));
		
		// transform the data to a different value or format => map
		// intermediate operation
		nos.stream().map(n->{
			System.out.println("mapping .. "+n);
			return n*n;
		}).forEach(sq-> System.out.println(sq));
		
		;
		List<String> names = Arrays.asList("Raju","Shalini","Vedant","Manas","Anuj","Shreelekha","Asha");
		
		Stream<Integer> strlen = names.stream().map(name -> {
			System.out.println(name);
			return name.length();	
		});
		
//		strlen.forEach(l -> System.out.println(l));
		
		//System.out.println(strlen.count());
		// stream is closed
		
		strlen.distinct().forEach(data -> System.out.println(data));
	}

}
