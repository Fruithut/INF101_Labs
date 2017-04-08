package inf101.v17.lab6.shapes.c;

import inf101.v17.lab6.shapes.IRectangle;

public class RectangleC implements IRectangle {
	private double height;
    private double width;

	private static void checkState(RectangleC rect) {
		if (rect.width < 0 || rect.height < 0)
			throw new IllegalStateException("Width and height must not be negative: " + rect.toString());
		if (Double.isNaN(rect.width) || Double.isNaN(rect.height))
			throw new IllegalStateException("Width and height must not be NaN: " + rect.toString());
	}

	public RectangleC(double height, double width) {
		setHeight(height);
		setWidth(width);
		//May just be a doublecheck?
		checkState(this);
	}

	@Override
	public double getArea() {
		return height*width;
	}

	@Override
	public double getCircumference() {
		return (height*2) + (width*2);
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
	public void setHeight(double newHeight) {
		if (newHeight < 0.0)
			throw new IllegalArgumentException("" + newHeight);
		height = newHeight;
		checkState(this);
	}

	@Override
	public void setWidth(double newWidth) {
		if (newWidth < 0.0)
			throw new IllegalArgumentException("" + newWidth);
		width = newWidth;
		checkState(this);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RectangleC that = (RectangleC) o;

        if (Double.compare(that.height, height) != 0) return false;
        return Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RectangleC{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
