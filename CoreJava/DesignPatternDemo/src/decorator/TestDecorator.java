package decorator;

public class TestDecorator {

	public static void main(String[] args) {
		
		Icecream icecream = new SimpleIceCream();
		System.out.println("made "+icecream.makeIcecream());
		
		icecream = new SprinklesDecorator(icecream);
		System.out.println("made "+icecream.makeIcecream());
		
		Icecream myicecream = new NuttyDecorator(new SprinklesDecorator(new SimpleIceCream()));
		System.out.println(myicecream.makeIcecream());
	}

}
