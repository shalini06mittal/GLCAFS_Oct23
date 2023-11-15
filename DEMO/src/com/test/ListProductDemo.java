package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
//1. 
class MyComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);// descending
	}
}

public class ListProductDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList();

		list.add(10);
		list.add(20);
		list.add(10);
		list.add(50);
		list.add(210);
		list.add(40);
		list.add(35);
		list.sort(null); // default asc
		Collections.reverse(list);
		//MyComparator ob = new MyComparator();
		// anonymous inner class
		//2. 
		Comparator<Integer> ob = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);// descending
			}
		};
		list.sort(ob);
		
		// Comparator => compare
		//3.
//		list.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2.compareTo(o1);// descending
//			}
//			
//		});
		//Collections.sort(list);
		
		System.out.println(list);

		List<Product> products = new LinkedList<Product>();

		products.add(new Product(1, "Laptop", "Windows OS", 23909));

		Product p1 = new Product(2, "Mouse", "Sony wireless", 2389);

		products.add(p1);
		products.add(new Product(5, "Screen Guard", "OnePlus 8", 1909));
		products.add(new Product(4, "Laptop Bag", "fit for office use", 5674));
		products.add(new Product(3, "Keyboard", "Logitech wireless", 10000));
		
		for(Product p :products) {
			System.out.println(p);
		}

		products.sort(null);
		
		for(Product p :products) {
			System.out.println(p);
		}
	}

}
