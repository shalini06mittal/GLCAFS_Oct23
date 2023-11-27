package com.generics;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueCompartor {

	public static void main(String[] args) {
		//1. create a comparator of type string
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				//use compare method to find the string length
				return o1.length() - o2.length();
			}
		};
		
		//2. create a priorityQueue object of type String
		PriorityQueue<String> queue = new PriorityQueue<String>(comparator);
		//3. add string elements to the priorityQueue
		queue.add("India");
		queue.add("USA");
		queue.add("China");
		queue.add("UK");
		
		// 4. print the priorityQueue
		Iterator<String> iter = queue.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		}
}
