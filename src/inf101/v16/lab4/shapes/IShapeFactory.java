package inf101.v16.lab4.shapes;

public interface IShapeFactory {

	/**
	 * @param radius
	 * @return A new circle
	 */
	ICircle circle(double radius);

	/**
	 * @param length
	 * @return A new line
	 */
	ILine line(double length);

	/**
	 * @param width
	 * @param height
	 * @return A new rectangle
	 */
	IRectangle rectangle(double width, double height);

	// /**
	// * @param x
	// * @param y
	// * @param shape
	// * @return A shape positioned at x, y
	// */
	// <S extends IShape> IPositioned<S> positioned(double x, double y, S
	// shape);

}