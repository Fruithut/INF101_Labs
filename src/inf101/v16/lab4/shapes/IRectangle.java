package inf101.v16.lab4.shapes;

/**
 * Interface for rectangle shapes.
 *
 * Rectangles are defined by their width and height, which correspond exactly to
 * the width/height of the shape.
 *
 * A rectangle is its of size box (see {@link #getSizeBox()}).
 *
 * @author anya
 *
 */
public interface IRectangle extends IShape {
	@Override
	double getHeight();

	@Override
	double getWidth();

	/**
	 * Set the height of the rectangle.
	 *
	 * @param newHeight
	 */
	void setHeight(double newHeight);

	/**
	 * Set the width of the rectangle.
	 *
	 * @param newWidth
	 */
	void setWidth(double newWidth);
}
