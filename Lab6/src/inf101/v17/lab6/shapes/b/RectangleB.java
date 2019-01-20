package inf101.v17.lab6.shapes.b;

import inf101.v17.lab6.shapes.IRectangle;

public class RectangleB extends LineB implements IRectangle {
	private double height;

	private static void checkState(RectangleB rect) {
		if (rect.getHeight() < 0)
			throw new IllegalStateException("Width and height must not be negative: " + rect.toString());
		if (Double.isNaN(rect.getHeight()))
			throw new IllegalStateException("Width and height must not be NaN: " + rect.toString());
	}

	public RectangleB(double length, double height) {
		super(length);
		setHeight(height);
		checkState(this);
	}

	@Override
	public double getArea() {
		return super.getWidth() * getHeight();
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
	public void setWidth(double newWidth) {
		super.setLength(newWidth);
	}

	@Override
	public void setHeight(double newHeight) {
		if (newHeight < 0.0) throw new IllegalArgumentException("Bad height " + height);
		this.height = newHeight;
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
        RectangleB other = (RectangleB) obj;
        if (Double.doubleToLongBits(height) != Double
                .doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(getWidth()) != Double
                .doubleToLongBits(other.getWidth())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getWidth());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RectangleB{" +
                "height=" + height +
                '}';
    }
}
