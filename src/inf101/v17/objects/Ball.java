package inf101.v17.objects;

import javafx.scene.paint.Paint;

/**
 * A class to represent bouncing balls
 */
public class Ball {
	/** Color of the ball's surface */
	private Paint color;

	/** The ball's radius. */
	private double radius;

	/**
	 * Link back to demo
	 */
	private BallDemo demo;

	private double xPos = 0.0, yPos = 0.0, deltaX = 0.0, deltaY = 0.0;

    /**
     * Number of steps taken
     */
	private int steps = 0;


	/**
	 * Create a new ball with position and velocity (0,0)
	 * 
	 * @param color
	 *            The color
	 * @param radius
	 *            The radius
	 */
	public Ball(Paint color, double radius, BallDemo demo) {
		if (radius < 0) throw new IllegalArgumentException("Radius should not be negative");
		this.color = color;
		this.radius = radius;
		this.demo = demo;
	}

	/**
	 * Move ball to a new position.
	 * 
	 * After calling {@link #moveTo(double, double)}, {@link #getX()} will return
	 * {@code newX} and {@link #getY()} will return {@code newY}.
	 * 
	 * @param newX
	 *            New X position
	 * @param newY
	 *            New Y position
	 */
	public void moveTo(double newX, double newY) {
		this.xPos = newX;
		this.yPos = newY;
	}

	/**
	 * @return Current X position
	 */
	public double getX() {
		return this.xPos;
	}

	/**
	 * @return Current Y position
	 */
	public double getY() {
		return this.yPos;
	}

	/**
	 * @return Current X movement
	 */
	public double getDeltaX() {
		return this.deltaX;
	}

	/**
	 * @return Current Y movement
	 */
	public double getDeltaY() {
		return this.deltaY;
	}

	/**
	 * @return The ball's radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @return The ball's width (normally 2x {@link #getRadius()})
	 */
	public double getWidth() {
		return radius * 2;
	}

	/**
	 * @return The ball's height (normally 2x {@link #getRadius()})
	 */
	public double getHeight() {
		return radius * 2;
	}

	/**
	 * @return Paint/color for the ball
	 */
	public Paint getColor() {
		return color;
	}

	/**
	 * Perform one time step.
	 * 
	 * For each time step, the ball's (xPos,yPos) position should change by
	 * (deltaX,deltaY).
	 */
	public void step() {
        steps++;
        this.xPos += deltaX;
        this.yPos += deltaY;

		if(steps == 60)
			demo.addExplosion(this);

	}

	/**
	 * Change current velocity (deltaX, deltaY)
	 * 
	 * The arguments are added to thet current values of deltaX,deltaY
	 * 
	 * @param ddx
	 *            Change to deltaX
	 * @param ddy
	 *            Change to deltaY
	 */
	public void accelerate(double ddx, double ddy) {
		this.deltaX += ddx;
		this.deltaY += ddy;
	}

	/**
	 * Indicate that the ball has hit something, and should move back and
	 * bounce.
	 * 
	 * If bounceX != 0 or bounceY != 0, then the ball has hit something in the X
	 * and/or Y direction and should reverse its movement.

	 * The (bounceX,bounceY) arguments can be added to the balls position in
	 * order to stop it from overlapping with whatever it hit.
	 * 
	 * @param bounceX X-distance the ball needs to move in order to not overlap with the object it hit
	 * @param bounceY Y-distance the ball needs to move in order to not overlap with the object it hit
	 */
	public void hit(double bounceX, double bounceY) {
		this.xPos += bounceX;
		this.yPos += bounceY;

		if (bounceX != 0 && bounceY != 0) {
			deltaX -= deltaX*2;
			deltaY -= deltaY*2;
		}
		else if (bounceX != 0) {
			deltaX -= deltaX*2;
		}
		else if (bounceY != 0) {
			deltaY -= deltaY*2;
		}
	}

	/**
	 * Stop the ball. (Sets deltaX/deltaY to 0) 
	 */
	public void halt() {
		this.deltaX = 0.0;
		this.deltaY = 0.0;
	}
}
