package inf101.v17.lab6.shapes.b;

import inf101.v17.lab6.shapes.ICircle;
import inf101.v17.lab6.shapes.IRectangle;

public class CircleB extends LineB implements ICircle {

	public CircleB(double radius) {
		super(radius);
	}

	@Override
	public double getArea() {
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public double getCircumference() {
		return 2 * Math.PI * getRadius();
	}

	@Override
	public double getHeight() {
		return getRadius()*2;
	}

	@Override
	public double getWidth() {
		return getRadius()*2;
	}

	@Override
	public double getRadius() {
		return super.getLength();
	}

	@Override
	public IRectangle getSizeBox() {
		return new RectangleB(getRadius() * 2, getRadius() * 2);
	}

	@Override
	public void setRadius(double newRadius) {
	    super.setLength(newRadius);
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Circle(").append(getRadius()).append(")");
        return builder.toString();
    }
}
