package inf101.v17.lab6.shapes.c;

import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IRectangle;

public class LineC extends RectangleC implements ILine {

	private static void checkState(LineC line) {
		if (line.getHeight() != 0.0)
			throw new IllegalStateException("Height must be zero " + line.toString());
	}

	public LineC(double height, double width) {
		super(0.0, width);
	}

	@Override
	public double getLength() {
		return super.getWidth();
	}

	@Override
	public void setLength(double newLength) {
		super.setWidth(newLength);
	}

	@Override
	public String toString() {
		return "LineB{" +
				"length=" + getLength() +
				'}';
	}
}
