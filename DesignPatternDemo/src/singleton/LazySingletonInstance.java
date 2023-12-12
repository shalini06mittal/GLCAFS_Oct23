package singleton;
/**
 * singleton is a design pattern 
 * which will allow only a single instance of class creation
 * 
 * getIPAddress()
 * 1. create private constructor
 * 2. create a static method that returns the instance of the class if it does not exist
 *
 */

//class IPAddress{
//	public String ipaddress() {
//		return "";
//	}
//}
public class LazySingletonInstance {

	private LazySingletonInstance() {
		System.out.println("lazy construtcot");
	}
	public void m1() {
		System.out.println("m1 called");
	}
	private static LazySingletonInstance instance ;
	public static LazySingletonInstance getInstance()
	{
		
		if(instance==null) {
			instance = new LazySingletonInstance();
		}
		return instance;
	}
	
}
