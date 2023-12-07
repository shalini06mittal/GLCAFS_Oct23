package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class InBuiltFunctionalInterface {

	public static void main(String[] args) {
//		Predicate<String> p1 = new Predicate<String>() {
//			
//			@Override
//			public boolean test(String t) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};
		Predicate<String> p1 = (email) -> email.endsWith("gmail.com");
		
		System.out.println(p1.test("shalini@gmail.com"));
		System.out.println(p1.test("shalini@yahoo.com"));
		
		Predicate<Integer> evenP = (no) -> no%2==0;
		
		for(int no : Arrays.asList(34,55,78,89,32,21,34,56))
			System.out.println(evenP.test(no) ? no : "");
		
//		BiPredicate<String, Integer> b1 = new BiPredicate<String, Integer>() {
//			
//			@Override
//			public boolean test(String t, Integer u) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};
		
		BiPredicate<String, Integer> b1 = (desc, value) -> desc.length() < value;
		System.out.println(b1.test("Represents an operation that accepts two input arguments and returns no result.", 10));
		
		DoublePredicate dp = (p) -> p%3==0;
		
		System.out.println(dp.test(9));
	}
}
