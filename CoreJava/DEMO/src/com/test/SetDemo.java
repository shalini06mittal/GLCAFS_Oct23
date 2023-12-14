package com.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		Set<Integer> nos = new HashSet<Integer>();
		nos.add(1);
		nos.add(30);
		nos.add(7);
		nos.add(2);
		nos.add(20);
		nos.add(12);
		nos.add(200);
		nos.add(87);
		nos.add(2);
		nos.add(101);
		System.out.println(nos);
		System.out.println();
		Set<Integer> nos1 = new LinkedHashSet<Integer>();
		nos1.add(1);
		nos1.add(3);
		nos1.add(7);
		nos1.add(2);
		nos1.add(1);
		System.out.println(nos1);
		System.out.println();
		Set<Integer> nos2 = new TreeSet<Integer>();
		nos2.add(1);
		nos2.add(3);
		nos2.add(7);
		nos2.add(2);
		nos2.add(1);
		System.out.println(nos2);
		
	}

}
