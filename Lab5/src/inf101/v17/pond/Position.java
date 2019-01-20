package inf101.v17.pond;

public class Position {
	private double x = 0.0;
	private double y;

	public Position() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return The X coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return The Y coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * Change position
	 * 
	 * @param newX
	 *            the new X coordinate
	 * @param newY
	 *            the new Y coordinate
	 * 
	 *            Afterwards, {@link #getX()} and {@link #getY()} will match
	 *            newX and newY.
	 */
	public void moveTo(double newX, double newY) {
		x = newX;
		y = newY;
	}

	/**
	 * Change to newPos
	 * 
	 * @param newPos 
	 */
	public void moveTo(Position newPos) {
		// velg en av disse
		x = newPos.x;
		y = newPos.y;
		// x = newPos.getX();
		// y = newPos.getY();
	}

	/**
	 * Relative move
	 * 
	 * @param deltaX
	 * @param deltaY
	 */
	public void move(double deltaX, double deltaY) {
		x = x + deltaX;
		y = y + deltaY;
	}

	/**
	 * Relative move
	 * 
	 * @param deltaPos
	 */
	public void move(Position deltaPos) {
		x = x + deltaPos.x;
		y = y + deltaPos.y;
	}

	/**
	 * Relative move
	 * @param dir Direction
	 * @param distance Distance to move
	 */
	public void move(Direction dir, double distance) {
		move(dir.getMovement(distance));
	}

	public Position copy() {
		return new Position(x, y);
	}

	/**
	 * Calculate distance to other position
	 * 
	 * @param otherPos
	 * @return
	 */
	public double distanceTo(Position otherPos) {
		return Math.sqrt(Math.pow(x-otherPos.x, 2) + Math.pow(y-otherPos.y, 2));
	}

	/**
	 * Calculate direction towards other position
	 * 
	 * @param otherPos
	 * @return
	 */
	public Direction directionTo(Position otherPos) {
		return new Direction(otherPos.x-x, otherPos.y-y);
	}
}
