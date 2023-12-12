package iterator;
import java.util.ArrayList;
public class ShapeCollectionImpl implements ShapeCollection{
	private ArrayList<Shape> shapes;
	public ShapeCollectionImpl() {
		shapes = new ArrayList<>();
	}
	@Override
	public void add(Shape shape) {
		shapes.add(shape);
	}
	@Override
	public void remove(Shape shape) {
		shapes.remove(shape);	
	}
	@Override
	public ShapeIterator iterator() {
		// TODO Auto-generated method stub
		return new ShapeIteratorImpl();
	}
	class ShapeIteratorImpl implements ShapeIterator{
		int position;
		@Override
		public boolean hasNext() {
			while(position < shapes.size())
			{
				return true;
			}
			return false;
		}
		@Override
		public Shape next() {
			Shape shape = shapes.get(position);
			position++;
			return shape;
		}	
	}

}
