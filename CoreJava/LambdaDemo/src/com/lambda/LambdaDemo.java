package com.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		Printable p1 = new Printable() {
			@Override
			public void print() {
				System.out.println("anonymous inner type");
			}

//			@Override
//			public void print1() {
//				// TODO Auto-generated method stub
//				
//			}
		};
		p1.print();
		/**
		 * output : return
		 * input : parameters
		 * implementation : method body
		 * 
		 * lambda syntax
		 * (input variables) -> {// BL 
		 * 	return <value>;
		 * }
		 * void <funcname>(input variables){
		 * 	// BL 
		 * 	return <value>;
		 * }
		 * private method
		 */
		p1 = () -> {
			System.out.println("method called from lambda syntax");
		};
		p1.print();
		List<Integer> nos = Arrays.asList(1,5,9,12,56,78,4,5);
		nos.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		Comparator<Integer> c = (Integer o1,Integer o2)-> {
			return 02-01;
		     };
		nos.sort(c);
		System.out.println(nos);
		nos.sort((o1, o2)-> o2-o1);
		
//		Notification n1 = (String msg) -> {
//			return "Welcome " + msg;
//		};
		Notification n1 = msg ->  "Welcome " + msg;
		System.out.println(n1.sendMessage("Shalini"));
		
		Notification n2 = msg ->  msg.substring(5);
		System.out.println(n2.sendMessage("Shalini"));
	}

}
