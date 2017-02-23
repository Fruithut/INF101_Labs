package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Fish implements IPondObject {

	@Override
	public void step() {
	}

	@Override
	public void draw(GraphicsContext context) {
		Paint bodyColor = Color.SILVER;

		double x = getX(), y = getY();
		double w = getWidth(), h = getHeight();

		context.save();
		// body
		context.setFill(bodyColor);
		context.fillOval(x, y, w, h);
		
		context.restore();
	}

	@Override
	public double getX() {
		return 50;
	}

	@Override
	public double getY() {
		return 50;
	}

	@Override
	public double getWidth() {
		return 100;
	}

	@Override
	public double getHeight() {
		return 70;
	}

	@Override
	public Position getPosition() {
		return new Position(getX(), getY());
	}

	@Override
	public Direction getDirection() {
		return new Direction(1, 0);
	}

}
