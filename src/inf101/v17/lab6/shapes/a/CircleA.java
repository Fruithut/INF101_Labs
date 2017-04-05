package inf101.v17.lab6.shapes.a;

import inf101.v17.lab6.shapes.ICircle;
import inf101.v17.lab6.shapes.IRectangle;

public class CircleA implements ICircle {
	private double radius;

	public CircleA(double radius) {
		this.radius = radius;
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
	public void setRadius(double newRadius) {
		radius = newRadius;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Circle(").append(radius).append(")");
		return builder.toString();
	}
}
