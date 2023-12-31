package com.annotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class A
{
	
	private String name;
	/**
	 * m1 will be deprecated after java 18
	 */
	@Deprecated(forRemoval = true, since="14")
	public void m1() {
		
	}
	public void m2() {
		
	}
}

class B extends A{

	/**
	 * small piece of information to the compiler or the JVM
	 * that tells about the identifiers being used
	 */
	@Override()
	@Log(author = "Shalini", version = "1.1")
	@Log(author = "")
	public void m1() {
		// TODO Auto-generated method stub
		super.m1();
	}
}

// reflection API
public class AnnotationsDemo {
	
	@SuppressWarnings("rawtypes")
	
	public static void main(String[] args) {
		A a1 = new A();
		a1.m1();
		
		
		List nos = new ArrayList();
		Set set = new HashSet();
	}

}
