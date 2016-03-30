package inf101.v16.lab4.shapes;

/**
 * Interface for a geometric two-dimensional shape, such as a point, rectangle,
 * circle or triangle.
 *
 * This interface gives access to general properties of all shapes, particular
 * properties of a specific kind of shape are access through corresponding
 * interfaces.
 *
 * The shapes are independent of the coordinate system – they have no "position"
 * or "rotation" or other attributes that would place them in 2D space.
 *
 * Note that shapes such as a 2x4 rectangle and a 4x2 rectangle are distinct,
 * even though they may look the same if they are later placed in a coordinate
 * system and rotated.
 *
 * @author anya
 *
 */
public interface IShape {

	/**
	 * Two shapes are equal if they are the same shape with the same dimensions.
	 *
	 * @param other
	 *            The object to compare to
	 * @return True if the objects are equal
	 */
	@Override
	boolean equals(Object other);

	/**
	 * The area will always be smaller than or equal to the area of the size
	 * box.
	 *
	 * @return The size of the surface area of the shape (measured in units
	 *         squared). Larger than or equal to 0.
	 */
	double getArea();

	/**
	 * The circumference can be large than that of the shape's size box (e.g.,
	 * if the shape is concave).
	 *
	 * @return The circumference of the shape (i.e., the length of the outside
	 *         of the shape). Larger than or equal to 0.
	 */
	double getCircumference();

	/**
	 * Measuring the width and height of a shape may be somewhat tricky,
	 * depending on the shape. Here, we'll define the height as the height of
	 * the shape's "size box", which is the smallest rectangle large enough to
	 * contain the shape.
	 *
	 * @return The "height" of the shape at its tallest. Larger than or equal to
	 *         0.
	 */
	double getHeight();

	/**
	 * Measuring the width and height of a shape may be somewhat tricky,
	 * depending on the shape. Here, we define the size of a shape using a
	 * "size box", which is the smallest rectangle still large enough to contain
	 * the shape.
	 *
	 * E.g, for a circle, it will be a radius x radius rectangle, and for a
	 * triangle, it would be a base x height rectangle.
	 *
	 * @return A rectangle enclosing the shape.
	 */
	IRectangle getSizeBox();

	/**
	 * Measuring the width and height of a shape may be somewhat tricky,
	 * depending on the shape. Here, we'll define the width as the with of the
	 * shape's "size box", which is the smallest rectangle large enough to
	 * contain the shape.
	 *
	 * @return The "width" of the shape at its widest. Larger than or equal to
	 *         0.
	 */
	double getWidth();

	@Override
	int hashCode();

	/**
	 * The string representation is the name of the shape, followed by a
	 * comma-separated list of its defining attributes enclosed in parentheses.
	 *
	 * For example, Circle(2.0) for a circle of radius 2, Rectangle(1.2, 4.0)
	 * for a 1.2x4.0 rectangle.
	 *
	 * @return A string representation of the shape.
	 */
	@Override
	String toString();

}
