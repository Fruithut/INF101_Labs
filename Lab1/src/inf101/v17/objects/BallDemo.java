package inf101.v17.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class BallDemo extends Application {
	private Canvas canvas;
	private long nanosPerStep = 1000_000_000L / 60L;
	private long timeBudget = nanosPerStep;
	private long lastUpdateTime = 0L;
	private List<Ball> balls = new ArrayList<>();
	private Random random = new Random();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		double width = 640, height = 480;
		Group root = new Group();
		Scene scene = new Scene(root, width, height, Color.BLACK);
		stage.setScene(scene);

		canvas = new Canvas(width, height);
		canvas.widthProperty().bind(scene.widthProperty());
		canvas.heightProperty().bind(scene.heightProperty());

		setup();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (lastUpdateTime > 0) {
					timeBudget = Math.min(timeBudget + (now - lastUpdateTime), 10 * nanosPerStep);
				}
				lastUpdateTime = now;

				while (timeBudget >= nanosPerStep) {
					timeBudget = timeBudget - nanosPerStep;
					step();
				}
				draw();
			}
		};

		root.getChildren().add(canvas);
		timer.start();
		stage.show();
	}

	private void setup() {
		for (int i = 0; i < 10; i++) {
			newBall();
		}
	}
	
	void addExplosion(Ball ball) {
		balls.remove(ball);
		for(int i = 0; i < 10; i++) {
			Ball b = new Ball(ball.getColor(), ball.getRadius()/2, this);
			b.moveTo(ball.getX(), ball.getY());
			b.accelerate(ball.getDeltaX(), ball.getDeltaY());
			b.accelerate(random.nextDouble()*2 - 1.0, random.nextDouble()*2 - 1.0);
			balls.add(b);
			
		}
	}
	

	private void newBall() {
		newBall(canvas.getWidth() / 2, canvas.getHeight() - 32, 32);
	}

	private void newBall(double x, double y, double size) {
		Color color = Color.RED.deriveColor(64 * random.nextDouble() - 32.0, 1.0, 1.0, .7);
		Color white = color.deriveColor(0.0, .33, 3.0, 2.0);
		Paint paint = new RadialGradient(0.0, 0.0, 0.3, 0.3, .6, true, CycleMethod.NO_CYCLE, new Stop(0.0, white),
				new Stop(1.0, (Color) color));
		Ball b = new Ball(paint, size, this);
		b.moveTo(x, y);
		b.accelerate((128/size) * random.nextDouble() - 1.5, -(512/size) * random.nextDouble() + 1);
		balls.add(b);

	}

	private int stepCount = 0;

	private void step() {
		for (Ball b : new ArrayList<>(balls)) {
			if (b.getY() + b.getHeight() / 2 < canvas.getHeight()) {
				b.accelerate(0, 0.098f);
			}
			b.step();

			double bounceX = 0.0, bounceY = 0.0;
			if (b.getX() + b.getWidth() / 2 <= 0.0) {
				balls.remove(b);
			} else if (b.getX() - b.getWidth() / 2 >= canvas.getWidth()) {
				balls.remove(b);
			} else if (b.getX() - b.getWidth() / 2 <= 0.0) {
				 bounceX = 0 - (b.getX() - b.getWidth() / 2);
			} else if (b.getX() + b.getWidth() / 2 >= canvas.getWidth()) {
				 bounceX = canvas.getWidth() - (b.getX() + b.getWidth() / 2);
			}

			if (b.getY() - b.getHeight() / 2 >= canvas.getHeight()) {
				balls.remove(b);
			} else if (b.getY() + b.getHeight() / 2 >= canvas.getHeight()) {
				bounceY = canvas.getHeight() - (b.getY() + b.getHeight() / 2);
			}
			if (bounceY != 0.0 || bounceX != 0.0) {
				if (random.nextInt(1) == 0) {
					balls.remove(b);
					if (b.getRadius() > 8.0) {
						double dy = b.getDeltaY();
						for (int i = 0; i < 4; i++) {
							newBall(b.getX(), b.getY(), b.getRadius() / 1.414);
							b = balls.get(balls.size()-1);
							b.accelerate(-b.getDeltaX(), -b.getDeltaY());
							b.accelerate(10 * random.nextDouble() - 5, -0.5*dy);
						}
					}
				}
				b.hit(bounceX, bounceY);
			}
		}
		if (stepCount % 8 == 0)
			newBall();
		stepCount++;
	}

	private void draw() {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for (int i = balls.size() - 1; i >= 0; i--) {
			Ball b = balls.get(i);
			double w = b.getWidth();
			double h = b.getHeight();
			double xPos = b.getX() - w / 2.0;
			double yPos = b.getY() - h / 2.0;
			context.save();
			context.setFill(b.getColor());
			context.fillOval(xPos, yPos, w / 1, h / 1);
			context.restore();
		}
	}

}
