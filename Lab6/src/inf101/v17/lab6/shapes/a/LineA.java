package inf101.v17.lab6.shapes.a;

import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IRectangle;

public class LineA implements ILine {
	private double length;

	public static void checkState(LineA line) {
		if (line.length < 0)
			throw new IllegalStateException("Length not be negative: " + line.toString());
		if (Double.isNaN(line.length))
			throw new IllegalStateException("Length must not be NaN: " + line.toString());
	}

	public LineA(double length) {
		setLength(length);
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
		LineA other = (LineA) obj;
		if (Double.doubleToLongBits(length) != Double
				.doubleToLongBits(other.length)) {
			return false;
		}
		return true;
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getCircumference() {
		return 2 * length;
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
		return new RectangleA(length, 0);
	}

	@Override
	public double getWidth() {
		return length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public void setLength(double newLength) throws IllegalArgumentException {
		if (newLength < 0) throw new IllegalArgumentException("Negative value");
		else if (newLength > Double.MAX_VALUE) throw new IllegalArgumentException("Over max double value");
		this.length = newLength;
		checkState(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Line(").append(length).append(")");
		return builder.toString();
	}

}
