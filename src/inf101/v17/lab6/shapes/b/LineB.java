package inf101.v17.lab6.shapes.b;

import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IRectangle;

public class LineB implements ILine {
	private double length;

	private static void checkState(LineB line) {
		if (line.length < 0)
			throw new IllegalStateException("Length not be negative: " + line.toString());
		if (Double.isNaN(line.length))
			throw new IllegalStateException("Length must not be NaN: " + line.toString());
	}

	public LineB(double length) {
		setLength(length);
		checkState(this);
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getCircumference() {
		return 2*getWidth() + 2*getHeight();
	}

	@Override
	public double getHeight() {
		return 0;
	}

	@Override
	public double getLength() {
		return length;
	}

	@Override
	public IRectangle getSizeBox() {
		return new RectangleB(length, 0);
	}

	@Override
	public double getWidth() {
		return length;
	}

	@Override
	public void setLength(double newLength) throws IllegalArgumentException {
		if (newLength < 0) throw new IllegalArgumentException("Negative value");
		else if (newLength > Double.MAX_VALUE) throw new IllegalArgumentException("Over max double value");
		this.length = newLength;
		checkState(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LineB other = (LineB) obj;
		if (Double.doubleToLongBits(length) != Double
				.doubleToLongBits(other.length)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		long temp = Double.doubleToLongBits(length);
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return "LineB{" +
				"length=" + length +
				'}';
	}
}
