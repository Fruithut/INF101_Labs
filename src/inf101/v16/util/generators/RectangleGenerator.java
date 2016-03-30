package inf101.v16.util.generators;

import inf101.v16.lab4.shapes.IRectangle;
import inf101.v16.lab4.shapes.IShapeFactory;
import inf101.v16.lab4.shapes.a.FactoryA;
import inf101.v16.util.IGenerator;

import java.util.Random;

public class RectangleGenerator extends AbstractGenerator<IRectangle> {
	/**
	 * Generator for the x-coordinate
	 */
	private final IGenerator<Double> xGenerator;
	/**
	 * Generator for the y-coordinate
	 */
	private final IGenerator<Double> yGenerator;

	private final IShapeFactory factory;

	/**
	 * Generate random rectangles between 0x0 and 100x100
	 */
	public RectangleGenerator() {
		this(100.0, 100.0, new FactoryA());
	}

	/**
	 * Generate random positions between (0,0) and (maxX,maxY)
	 *
	 * @param maxX
	 * @param maxY
	 */
	public RectangleGenerator(double maxX, double maxY) {
		this(maxX, maxY, new FactoryA());
	}

	/**
	 * Generate random positions between (0,0) and (maxX,maxY)
	 *
	 * @param maxX
	 * @param maxY
	 * @param factory
	 */
	public RectangleGenerator(double maxX, double maxY, IShapeFactory factory) {
		if (maxX < 0.0 || maxY < 0.0) {
			throw new IllegalArgumentException(
					"Width and height must be 0 or greater");
		}

		this.xGenerator = new DoubleGenerator(0.0, maxX);
		this.yGenerator = new DoubleGenerator(0.0, maxY);
		this.factory = factory;
	}



	/**
	 * Generate random rectangles between 0x0 and 100x100
	 *
	 * @param factory
	 */
	public RectangleGenerator(IShapeFactory factory) {
		this(100.0, 100.0, factory);
	}

	@Override
	public IRectangle generate(Random r) {
		return factory
				.rectangle(xGenerator.generate(r), yGenerator.generate(r));
	}
}
