package com.exception;

public class Asciidemo {

	public static void main(String[] args) {
		
		System.out.println("hello"+2+3);
		System.out.println(2+3+"hello");
		System.out.println("hello"+(2+3));
		
		System.out.println("a"+'b');
		System.out.println('a'+'b');//97+98
		System.out.println((int)'0');
		// A-Z 65-90
		// a-z 97-122
		// 0-9 48-57
		String str = 'a'+4+" is the number with "+ 'a'+ " single digit";
		System.out.println(str);
		
	}

}
