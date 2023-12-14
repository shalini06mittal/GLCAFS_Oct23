
// loosely coupled
// highly cohesiveness => one class is responsible for only similar type of functionalities
/*
 * File => operations related only to file
 * FileReader -> reading
 */
class A{
	
	public void m1()
	{
		
	}
}
class B{
	A a1;
	
	public void m2()
	{
		a1.m1();
	}
}
public class Test {

	public static void main(String[] args) {
		// loosely coupled
		
	}

}
