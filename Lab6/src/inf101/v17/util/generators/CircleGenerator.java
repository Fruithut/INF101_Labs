package inf101.v17.util.generators;

import inf101.v17.lab6.shapes.ICircle;
import inf101.v17.lab6.shapes.IShapeFactory;
import inf101.v17.lab6.shapes.a.FactoryA;
import inf101.v17.util.IGenerator;

import java.util.Random;

public class CircleGenerator extends AbstractGenerator<ICircle> {
	/**
	 * Generator for the x-coordinate
	 */
	private final IGenerator<Double> xGenerator;

	private final IShapeFactory factory;

	/**
	 * Generate random circles between 0 100
	 */
	public CircleGenerator() {
		this(100.0, new FactoryA());
	}

	/**
	 * Generate random positions between 0 and maxRadius
	 *
	 * @param maxRadius
	 */
	public CircleGenerator(double maxRadius) {
		this(maxRadius, new FactoryA());
	}

	/**
	 * Generate random positions between 0 and maxRadius
	 *
	 * @param maxRadius
	 * @param factory
	 */
	public CircleGenerator(double maxRadius, IShapeFactory factory) {
		if (maxRadius < 0.0) {
			throw new IllegalArgumentException("Radius must be 0 or greater");
		}

		this.xGenerator = new DoubleGenerator(0.0, maxRadius);
		this.factory = factory;
	}

	/**
	 * Generate random circles between 0 100
	 *
	 * @param factory
	 */
	public CircleGenerator(IShapeFactory factory) {
		this(100.0, factory);
	}

	@Override
	public ICircle generate(Random r) {
		return factory.circle(xGenerator.generate(r));
	}
}
