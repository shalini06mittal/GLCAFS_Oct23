package factory;
// factory of objects of type Person
public abstract class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	// Mrs/Ms 
	// Mr 
	public abstract String getSalutation();

	public String getNameAndSalutaiton()
	{
		return getSalutation()+". "+name;
	}
}
class Male extends Person
{
	public Male(String name)
	{
		super(name);
	}
	public Male(String name, String param)
	{
		super(name);
	}
	@Override
	public String getSalutation() {
		// TODO Auto-generated method stub
		return "Mr";
	}
}
class FeMale extends Person
{
	public FeMale(String name)
	{
		super(name);
	}
	@Override
	public String getSalutation() {
		// TODO Auto-generated method stub
		return "Ms";
	}
}