package singleton;



public class TestSingleton {

	public static void main(String[] args) {
//		LazySingletonInstance d1 = new LazySingletonInstance();
//		System.out.println(d1.hashCode());
//		LazySingletonInstance d2 = new LazySingletonInstance();
//		System.out.println(d2.hashCode());

		LazySingletonInstance ob1 = LazySingletonInstance.getInstance();
		System.out.println(ob1.hashCode());
		
		LazySingletonInstance ob2 = LazySingletonInstance.getInstance();
		System.out.println(ob2.hashCode());
		ob1.m1();
	
	}

}
