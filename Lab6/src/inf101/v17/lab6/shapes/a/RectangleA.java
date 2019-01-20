package inf101.v17.lab6.shapes.a;

import inf101.v17.lab6.shapes.IRectangle;

public class RectangleA implements IRectangle {
	private double width;
	private double height;

	/**
	 * Check that the internal state of a rectangle object is consistent.
	 *
	 * @param rect
	 *            A rectangle
	 */
	public static void checkState(RectangleA rect) {
		if (rect.width < 0 || rect.height < 0) {
			throw new IllegalStateException(
					"Width and height must not be negative: " + rect.toString());
		}

		// NaN (Not a Number) is the result of some undefined operations on
		// doubles (such as taking the square root of a negative number). NaN
		// indicates that an error has occurred somewhere.
		// (Note that n/0 does results in infinity, which is (usually) not an
		// error, and can be computed with usefully.)
		if (Double.isNaN(rect.width) || Double.isNaN(rect.height)) {
			throw new IllegalStateException(
					"Width and height must not be NaN: " + rect.toString());
		}

	}


	public RectangleA(double width, double height) {
		if (width < 0.0) {
			throw new IllegalArgumentException("Bad width " + width);
		}
		if (height < 0.0) {
			throw new IllegalArgumentException("Bad height " + height);
		}

		this.width = width;
		this.height = height;

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
		RectangleA other = (RectangleA) obj;
		if (Double.doubleToLongBits(height) != Double
				.doubleToLongBits(other.height)) {
			return false;
		}
		if (Double.doubleToLongBits(width) != Double
				.doubleToLongBits(other.width)) {
			return false;
		}
		return true;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getCircumference() {
		return 2 * width + 2 * height;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public IRectangle getSizeBox() {
		return this;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public void setHeight(double newHeight) {
		if (newHeight < 0.0) {
			throw new IllegalArgumentException("" + newHeight);
		}
		height = newHeight;
		checkState(this);
	}

	@Override
	public void setWidth(double newWidth) {
		if (newWidth < 0.0) {
			throw new IllegalArgumentException("" + newWidth);
		}

		width = newWidth;
		checkState(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rectangle(").append(width).append(", ").append(height)
		.append(")");
		return builder.toString();
	}
}
