package factory;

/**
 * 1. static method that returns the reference of the object it produces
 * @author Shalini
 *
 */
public class PersonFactory {

	public static Person getPerson(String name, String gender)
	{
		if(gender.equals("male"))
		{
			return new Male(name);
		}
		else {
			return new FeMale(name);
		}
	}
}
