package inf101.v17.pond;

/**
 * @author anya
 *
 */
public class Direction {
	private double xDir = 1.0;
	private double yDir = 0.0;

	/**
	 * Create a new direction.
	 * 
	 * The direction vector will be normalised to a vector of length 1.
	 * 
	 * @param xDir X-component of direction vector
	 * @param yDir Y-component of direction vector
	 */
	public Direction(double xDir, double yDir) {
		this.xDir = xDir;
		this.yDir = yDir;
		normalize();
	}

	/**
	 * Multiply direction by distance
	 * 
	 * @param distance
	 * @return Position delta 
	 */
	public Position getMovement(double distance) {
		return new Position(xDir * distance, yDir * distance);
	}

	/**
	 * Turn left 90 degrees
	 */
	public void turnLeft() {
		turn(90.0);
	}

	/**
	 * Turn right 90 degrees
	 */
	public void turnRight() {
		turn(-90.0);
	}

	/**
	 * Turn around 180 degrees
	 */
	public void turnBack() {
		turn(180.0);
	}

	/**
	 * Turn angle degrees
	 * 
	 * @param angle
	 */
	public void turn(double angle) {
		turnTo(toAngle()+angle);
	}

	/**
	 * Turn (relative)
	 * 
	 * @param deltaDir
	 */
	public void turn(Direction deltaDir) {
		xDir += deltaDir.xDir;
		yDir += deltaDir.yDir;
		normalize();
	}

	/**
	 * Turn to a new direction (replaces current direction with newDir)
	 * 
	 * @param newDir
	 */
	public void turnTo(Direction newDir) {
		xDir = newDir.xDir;
		yDir = newDir.yDir;
	}

	/**
	 * Turn slightly towards a directions
	 * 
	 * @param dir A direction
	 * @param percent How much to turn (100.0 is the same as turnTo())
	 */
	public void turnTowards(Direction dir, double percent) {
		xDir = xDir*(1.00 - percent/100.0) + dir.xDir*(percent/100.0);
		yDir = yDir*(1.00 - percent/100.0) + dir.yDir*(percent/100.0);
		normalize();
//		double thisAngle = toAngle();
//		double otherAngle = dir.toAngle();
//		turnTo(thisAngle*(1.00 - percent/100.0) + otherAngle*(percent/100.0));
	}

	/**
	 * Translate to angle (in degrees)
	 * @return Angle in degrees, -180 .. 180
	 */
	public double toAngle() {
		return Math.toDegrees(Math.atan2(yDir, xDir));
	}

	/**
	 * Absolute turn
	 * 
	 * @param degrees Angle in degrees, where 0 is (1,0)
	 */
	public void turnTo(double degrees) {
		double radians = Math.toRadians(degrees);
		xDir = Math.cos(radians);
		yDir = Math.sin(radians);
	}
	private void normalize() {
		double l = Math.sqrt(xDir * xDir + yDir * yDir);
		if (l >= 0.00001) {
			xDir = xDir / l;
			yDir = yDir / l;
		} else if (xDir > 0) {
			xDir = 1;
			yDir = 0;
		} else if (xDir < 0) {
			xDir = -1;
			yDir = 0;
		} else if (yDir > 0) {
			xDir = 0;
			yDir = 1;
		} else if (yDir < 0) {
			xDir = 0;
			yDir = -1;
		} else {
			xDir = 1;
			yDir = 0;
		}

	}

	public Direction copy() {
		return new Direction(xDir, yDir);
	}
}
