package com.lambda;

/**
 * to use lambdas with interface
 * it should have only ONE ABSTRACT METHOD
 * @author Shalini
 *
 */
@FunctionalInterface
public interface Printable {

	public void print();
	//public void print1();
	default public void m1() {
		
	}
	static public void m2() {
		
	}
}

