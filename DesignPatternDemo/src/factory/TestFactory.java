package factory;

public class TestFactory {

	public static void main(String[] args) {

		Person person = PersonFactory.getPerson("Vedant", "male");
		System.out.println(person.getNameAndSalutaiton());
		person = PersonFactory.getPerson("Shalini", "female");

		System.out.println(person.getNameAndSalutaiton());
		Person p1 = new Male("alskdj");

		Person p2 = new FeMale("alskdj");

	}

}
