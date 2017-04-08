package inf101.v17.lab6.shapes.b;

import com.sun.org.apache.regexp.internal.RE;
import inf101.v17.lab6.shapes.ICircle;
import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IRectangle;
import inf101.v17.lab6.shapes.IShapeFactory;

public class FactoryB implements IShapeFactory {

	@Override
	public ICircle circle(double radius) {
		return new CircleB(radius);
	}

	@Override
	public ILine line(double length) {
		return new LineB(length);
	}


	@Override
	public IRectangle rectangle(double width, double height) {
		return new RectangleB(width,height);
	}

}
