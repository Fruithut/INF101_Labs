package inf101.v17.pond;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

public abstract class AbstractDuck extends AbstractPondObject {
	public static final Random random = new Random();


	protected Paint bodyColor, headColor, billColor;
	protected boolean swimming = false;


	public AbstractDuck(Position pos, Direction dir, Pond pond) {
		super(pos, dir, pond);
	}

	public double getX() {
		return pos.getX();
	}

	public double getY() {
		return pos.getY();
	}

	public abstract boolean isAdult();

	public abstract boolean isMale();

	public abstract boolean isFemale();


	public void swim() {
		swimming = true;
	}

	public void stop() {
		swimming = false;
	}

	@Override
	public void step() {
		// size = size * 0.99999;
		
		// move
		if (swimming) {
			pos.move(direction, speed);
			// size = size * 0.99999;
		}

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
		double x = pos.getX(), y = pos.getY();
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

		// front
		context.setFill(Color.SADDLEBROWN);
		context.fillArc(x, y, w, h, 135, 90, ArcType.ROUND);

		// head
		context.setFill(headColor);
		context.fillOval(x - w * .1, y + h * .7, w * .5, h * .5);

		// eye
		context.setFill(Color.BLACK);
		context.fillOval(x + w * .1, y + h * .95, w * .05, h * .05);

		// bill
		context.save();
		context.setFill(billColor);
		context.translate(x - w * .01, y + h * .90);
		context.rotate(200);
		context.fillArc(0, 0, w * .5, h * .1, 135, 90, ArcType.ROUND);
		context.restore();

		//Speculum adult-only
		context.save();
		context.translate(x + w * .7, y + h * .3);
		context.rotate(45);
		context.setFill(Color.WHITE);
		context.fillRect(0, -h * .025, w * .2, h * .25);
		context.setFill(Color.DARKBLUE);
		context.fillRect(0, 0, w * .2, h * .2);
		context.restore();

		context.restore();
	}
}
