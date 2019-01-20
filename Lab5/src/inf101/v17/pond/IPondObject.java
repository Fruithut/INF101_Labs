package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author anya
 *
 */
/**
 * @author anya
 *
 */
public interface IPondObject {
	/**
	 * Execute one time step of the object's behaviour
	 */
	void step();

	/**
	 * Draw the object at its current position
	 * 
	 * Coordinates are absolute, not relative to current object.
	 * 
	 * @param context
	 *            A graphics context for drawing on
	 */
	void draw(GraphicsContext context);

	/**
	 * Same as getPosition().getY()

	 * @return X coordinate
	 */
	double getX();

	/**
	 * Same as getPosition().getY()
	 * 
	 * @return Y coordinate
	 */
	double getY();

	/**
	 * @return Width of the object
	 */
	double getWidth();

	/**
	 * @return Height of the object
	 */
	double getHeight();
	
	/**
	 * @return The position (same as new Position(getX(), getY()))
	 */
	Position getPosition();

	/**
	 * @return The direction the object is facing
	 */
	Direction getDirection();
}
