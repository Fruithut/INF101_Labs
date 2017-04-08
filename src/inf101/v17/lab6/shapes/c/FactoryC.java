package inf101.v17.lab6.shapes.c;

import inf101.v17.lab6.shapes.ICircle;
import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IRectangle;
import inf101.v17.lab6.shapes.IShapeFactory;

public class FactoryC implements IShapeFactory {

	@Override
	public ICircle circle(double radius) {
		return new CircleC(radius);
	}

	@Override
	public ILine line(double length) {
		return new LineC(0.0,length);
	}


	@Override
	public IRectangle rectangle(double width, double height) {
		return new RectangleC(height,width);
	}

}
