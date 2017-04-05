package inf101.v17.lab6.shapes;

/**
 * A circle shape.
 *
 * A circle is defined by its radius. The width and height of a circle are
 * always the same, and equal to double the radius.
 *
 * @author anya
 *
 */
public interface ICircle extends IShape {
	/**
	 * @return Radius of the circle (will be half its width and height)
	 */
	double getRadius();

	/**
	 * Set the radius of a circle.
	 *
	 * @param newRadius
	 */
	void setRadius(double newRadius);
}
