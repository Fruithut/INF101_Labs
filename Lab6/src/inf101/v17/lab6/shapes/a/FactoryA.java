package inf101.v17.lab6.shapes.a;

import inf101.v17.lab6.shapes.ICircle;
import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IRectangle;
import inf101.v17.lab6.shapes.IShapeFactory;

public class FactoryA implements IShapeFactory {
	@Override
	public ICircle circle(double radius) {
		return new CircleA(radius);
	}

	@Override
	public ILine line(double length) {
		return new LineA(length);
	}


	@Override
	public IRectangle rectangle(double width, double height) {
		return new RectangleA(width, height);
	}

}
