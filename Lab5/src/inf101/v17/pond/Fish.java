package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

public class Fish extends AbstractPondObject {
	public static final Random random = new Random();

	public Fish(Position pos, Direction dir, Pond pond) {
		super(pos, dir, pond);
		this.size = 0.5;
		this.speed = 2;
	}

	@Override
	public void step() {
		pos.move(direction, speed);
		// size = size * 0.99999;

		// move towards center if we are far away
		if (pos.distanceTo(pond.getCenter()) > pond.getHeight() / 2) {
			direction.turnTowards(pos.directionTo(pond.getCenter()), 1);
		}

		// random adjustment
		if (random.nextInt(10) == 0) {
			direction.turn(random.nextDouble() * 2 - 1.0);
		}
	}

	@Override
	public void draw(GraphicsContext context) {
		Paint bodyColor = Color.SILVER;

		double x = getX(), y = getY();
		double w = getWidth(), h = getHeight();

		context.save();
		context.translate(x, y);
		double a = direction.toAngle();

		context.rotate(180 + a);

		x = -getWidth() / 2;
		y = -getHeight() / 2;
		if (direction.getMovement(1.0).getX() > 0) {
			context.scale(1.0, -1.0);
		}
		// body
		context.setFill(bodyColor);
		context.fillOval(x, y, w, h);

		context.restore();
	}

	@Override
	public double getX() {
		return pos.getX();
	}

	@Override
	public double getY() {
		return pos.getY();
	}

	@Override
	public Direction getDirection() {
		return new Direction(1, 0);
	}
}
