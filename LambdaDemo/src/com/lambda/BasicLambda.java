package com.lambda;

interface Printable{
	public void print();
}
public class BasicLambda {
	// ob reference of type Printable which cann refer to object of any class that implements Printable
	public static void printing(Printable ob) {
		ob.print();
	}
	public static void main(String[] args) {
		System.out.println("main method starts");
		
		Class1 ob1 = new Class1();
		printing(ob1);
		
		Printable ob2 = new Class2();
		printing(ob2);
		
		// anonymous inner class
		
		ob2 = new Printable(){
			@Override
			public void print() {
				System.out.println("printing in a file "+this.getClass().getName());
			}
		};
		printing(ob2);
		ob2 = new Printable() {
			
			@Override
			public void print() {
				System.out.println("another naonymous inner class");
				
			}
		};
		printing(ob2);
	}
}

class Class1 implements Printable{
	@Override
	public void print() {
		System.out.println("printing by class "+this.getClass().getName());
	}
}
class Class2 implements Printable{
	@Override
	public void print() {
		System.out.println("sending to the printer "+this.getClass().getName());
	}
}
