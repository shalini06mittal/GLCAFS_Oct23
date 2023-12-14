package iterator;

public interface ShapeCollection {

	public void add(Shape shape);
	public void remove(Shape shape);
	public ShapeIterator iterator();
}
