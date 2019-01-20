package inf101.v17.pond;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class DuckDemo extends Application {
	private AnimationTimer timer;
	private Canvas canvas;
	private long nanosPerStep = 1000_000_000L / 100L;
	private long timeBudget = nanosPerStep;
	private long lastUpdateTime = 0L;
	private Random random = new Random();
	private Pond pond;
	public static final double NOMINAL_WIDTH = 1900;
	public static final double NOMINAL_HEIGHT = 1000;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		double width = NOMINAL_WIDTH;
		double height = NOMINAL_HEIGHT;

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		Group root = new Group();
		Scene scene = new Scene(root, primaryScreenBounds.getWidth() - 40, primaryScreenBounds.getHeight() - 100,
				Color.BLACK);
		stage.setScene(scene);

		canvas = new Canvas(width, height);
		canvas.widthProperty().bind(scene.widthProperty());
		canvas.heightProperty().bind(scene.heightProperty());
		canvas.setScaleY(-1.0);

		setup();

		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// System.out.println("Elapsed: " + (now -
				// lastUpdateTime)/(double)millisPerStep);
				if (lastUpdateTime > 0) {
					timeBudget = Math.min(timeBudget + (now - lastUpdateTime), 10 * nanosPerStep);
				}
				lastUpdateTime = now;

				while (timeBudget >= nanosPerStep) {
					// System.out.println("Budget: " + timeBudget);
					timeBudget = timeBudget - nanosPerStep;
					step();
				}
				draw();
			}

		};
		root.getChildren().add(canvas);

		// canvas.setEffect(new BoxBlur());
		timer.start();
		// stage.setFullScreen(true);
		stage.show();

	}

	private void setup() {
		pond = new Pond(NOMINAL_WIDTH, NOMINAL_HEIGHT);

		// female abstractDuck
		AbstractDuck abstractDuck = new FemaleDuck(randomPos(), new Direction(-1, 0), pond);
		abstractDuck.swim();
		pond.addObject(abstractDuck);
		
		// male abstractDuck
		abstractDuck = new MaleDuck(randomPos(), new Direction(1, 0), pond);
		abstractDuck.swim();
		pond.addObject(abstractDuck);
		
		// duckling
		abstractDuck = new Duckling(randomPos(), new Direction(1, 0), pond);
		abstractDuck.swim();
		pond.addObject(abstractDuck);

		//Fish
		AbstractPondObject testFish = new Fish(randomPos(), new Direction(1, 0), pond);
		pond.addObject(testFish);

	}

	private Position randomPos() {
		return new Position(random.nextGaussian() * NOMINAL_WIDTH / 4 + NOMINAL_WIDTH / 2, //
				random.nextGaussian() * NOMINAL_HEIGHT / 4 + NOMINAL_HEIGHT / 2);
	}

	protected void step() {
		pond.step();
	}

	protected void draw() {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		double xScale = canvas.getWidth() / NOMINAL_WIDTH;
		double yScale = canvas.getHeight() / NOMINAL_HEIGHT;
		double scale = Math.min(xScale, yScale);

		context.save();
		context.scale(scale, scale);
		pond.draw(context);
		context.restore();
	}

}
