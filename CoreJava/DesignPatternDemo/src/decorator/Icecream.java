package decorator;

public interface Icecream {

	public String makeIcecream();
}

class SimpleIceCream implements Icecream
{
	@Override
	public String makeIcecream() {
		// TODO Auto-generated method stub
		return "Simple Ice cream";
	}
}

// lets say i want to decorate this icecream
/**
 * 1. create an abstract class that implements the base class/ interface
 * 2. Should have a reference of base interface
 * @author Shalini
 *
 */
abstract class IceCreamDecorator implements Icecream
{
	protected Icecream specialIcecream;
	
	public IceCreamDecorator(Icecream specialIcecream) {
		// TODO Auto-generated constructor stub
		this.specialIcecream = specialIcecream;
	}
	
	@Override
	public String makeIcecream() {
		// TODO Auto-generated method stub
		return specialIcecream.makeIcecream();
	}
}
class NuttyDecorator extends IceCreamDecorator{

	public NuttyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String makeIcecream() {
		// TODO Auto-generated method stub
		return super.makeIcecream() + " with nuts added";
	}
}
class SprinklesDecorator extends IceCreamDecorator{

	public SprinklesDecorator(Icecream specialIcecream) {
		super(specialIcecream);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String makeIcecream() {
		// TODO Auto-generated method stub
		return super.makeIcecream() + " with sprinklers added";
	}
}

