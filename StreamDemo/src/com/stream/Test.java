package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface I1{
	I1 m1(Predicate<?> p);
	void process(Consumer<?> c);
}

class MyList{
	private List<Integer> nos = new ArrayList<Integer>();
	public void add(int no)
	{
		nos.add(no);
	}
	public int get(int index)
	{
		return nos.get(index);
	}
	public I1 stream()
	{
		return null;
	}
	
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList l1 = new  MyList();
		l1.add(10);
		l1.add(20);
		
		//l1.stream().m1(n -> n%2 ==0);
		
		
	}

}
