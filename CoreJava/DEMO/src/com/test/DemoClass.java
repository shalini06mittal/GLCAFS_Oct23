package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DemoClass {

	public static void main(String[] args) {
		/**
		 * Collections -> Data structure that allows you to store data in a certain format
		 * and provide operations to perform on them
		 * Collection (I) extends Iterable (I)
		 * ordered, unordered,, sorted and unsorted
		 * 
		 * Object?
		 * List(I) extends Collection
		 * ArrayList(C), LinkedList(C), Vector(C) implements List
		 * ordered and unsorted , allows duplicates, supports indexing
		 * 
		 * Stack extends Vector
		 * 
		 * Queue(I) extends Collection
		 * LinkedList(C), PriorityQueue(C) implements Queue
		 * ordered, unsorted , allows duplicates, does not supports indexing
		 * PriorityQueue ->ordered and sorted arranged in natural order asc or desc
		 * 
		 * Set(I) extends Collection
		 * HashSet(C), LinkedHashSet(C) implements Set
		 * unordered, unsorted , does not allow duplicates, does not supports indexing
		 * 
		 * SortedSet(I) extends Set
		 * TreeSet(C) implements SortedSet 
		 * ordered and sorted
		 * 
		 * 10, 20, apples, oranges, 23.78, 'a', new Student(), true
		 */
		// <> - diamond bracket are used to specify teh type of data to be stored in the collection
		// Generics?
		List<Integer> list = new ArrayList();
		
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(50);
		list.add(210);
		list.add(40);
		list.add(35);
		
		System.out.println(list);
		System.out.println(list.get(4));
		//System.out.println(list.get(15));
		for(Integer no : list)
			System.out.println(no*no);
	
		System.out.println(list.remove(new Integer(10)));
		System.out.println(list.remove(3));
		
		List<Product> products = new LinkedList<Product>();
		
		products.add(new Product(1, "Laptop", "Windows OS", 23909));
		
		Product p1 = new Product(2, "Mouse", "Sony wireless", 2389);
		
		products.add(p1);
		products.add(new Product(5, "Screen Guard", "OnePlus 8", 1909));
		products.add(new Product(4, "Laptop Bag", "fit for office use", 5674));
		products.add(new Product(3, "Keyboard", "Logitech wireless", 10000));
		
		for(Product product : products)
			System.out.println(product);
		/**
		 * display the name and price of all the products
		 * apply 10% discount on the items whose price >= 10000
		 */
		for(Product product : products) {
			if(product.getPrice() >= 10000) {
				double discountedPrice = product.getPrice() - product.getPid() *10/100;
				System.out.println(product.getPname());
				System.out.println(discountedPrice);
			}
			else{
				System.out.println(product.getPname());
				System.out.println(product.getPrice());
			}
		}
	}

}
