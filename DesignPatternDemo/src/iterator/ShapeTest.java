package iterator;

public class ShapeTest {

	public static void main(String[] args) {
		Shape shape1 = new Shape(1, "Circle");
		Shape shape2 = new Shape(2, "Square");
		Shape shape3 = new Shape(3, "Triangle");
		Shape shape4 = new Shape(4, "Rectangle");
		Shape shape5 = new Shape(5, "Circle");
		ShapeCollectionImpl collection = new ShapeCollectionImpl();
		collection.add(shape1);
		collection.add(shape2);
		collection.add(shape3);
		collection.add(shape4);
		collection.add(shape5);
		ShapeIterator iterator = collection.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}

}
