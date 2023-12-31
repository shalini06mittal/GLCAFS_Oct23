package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListSample {

	public static void main(String[] args) {
		ArrayList<Integer> nos = new ArrayList<Integer>();
		nos.add(10);
		nos.add(5);
		nos.add(3);
		nos.add(2);
		nos.add(10);
		nos.add(78);
		nos.add(5);
		nos.add(10);
		nos.add(10);
		nos.add(33);

		System.out.println(nos.size());// no of elements in hte list
		System.out.println(nos.addAll(Arrays.asList(100,200)));
		System.out.println(nos);
		System.out.println(nos.addAll(3, Arrays.asList(999,777)));
		System.out.println(nos);
//		nos.clear();
//		System.out.println(nos);
		//[10, 5, 3, 999, 777, 2, 10, 78, 5, 10, 1, 100, 200]
		nos.remove(new Integer(10));
		System.out.println(nos);
		ArrayList<Integer> data =  (ArrayList<Integer>) nos.clone();
		ArrayList<Integer> data1 = nos;
		data.add(25);
		data1.add(35);
		System.out.println(data);
		System.out.println(data1);
		System.out.println(nos);
		System.out.println(nos.contains(10));
		System.out.println(nos.containsAll(Arrays.asList(888,777)));
		System.out.println(nos.get(4));
		System.out.println(nos.indexOf(10));
		System.out.println(nos.lastIndexOf(10));
		System.out.println(nos.set(2, 1000));
		System.out.println(nos);
		
		nos.sort(Collections.reverseOrder());
		System.out.println(nos);
	}
	

}
