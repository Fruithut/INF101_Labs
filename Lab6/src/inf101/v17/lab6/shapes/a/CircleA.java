package inf101.v17.lab6.shapes.a;

import inf101.v17.lab6.shapes.ICircle;
import inf101.v17.lab6.shapes.IRectangle;

public class CircleA implements ICircle {
	private double radius;

	public static void checkState(CircleA circle) {
		if (circle.radius < 0)
			throw new IllegalStateException("Radius must not be negative: " + circle.toString());
		if (Double.isNaN(circle.radius))
			throw new IllegalStateException("Radius must not be NaN: " + circle.toString());
	}

	public CircleA(double radius) {
		setRadius(radius);
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
		CircleA other = (CircleA) obj;
		if (Double.doubleToLongBits(radius) != Double
				.doubleToLongBits(other.radius)) {
			return false;
		}
		return true;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getCircumference() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double getHeight() {
		return radius * 2;
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public IRectangle getSizeBox() {
		return new RectangleA(radius * 2, radius * 2);
	}

	@Override
	public double getWidth() {
		return radius * 2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public void setRadius(double newRadius) throws IllegalArgumentException {
		if (newRadius < 0) throw new IllegalArgumentException("Negative radius");
		else if (newRadius > Double.MAX_VALUE) throw new IllegalArgumentException("Over max double value");
		radius = newRadius;
		checkState(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Circle(").append(radius).append(")");
		return builder.toString();
	}
}
