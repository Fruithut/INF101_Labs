package inf101.v17.util.generators;

import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IShapeFactory;
import inf101.v17.lab6.shapes.a.FactoryA;
import inf101.v17.util.IGenerator;

import java.util.Random;

public class LineGenerator extends AbstractGenerator<ILine> {
	/**
	 * Generator for the x-coordinate
	 */
	private final IGenerator<Double> xGenerator;

	private final IShapeFactory factory;

	/**
	 * Generate random lines between 0 100
	 */
	public LineGenerator() {
		this(100.0, new FactoryA());
	}

	/**
	 * Generate random positions between 0 and maxLength
	 *
	 * @param maxLength
	 */
	public LineGenerator(double maxLength) {
		this(maxLength, new FactoryA());
	}

	/**
	 * Generate random positions between 0 and maxLength
	 *
	 * @param maxLength
	 * @param factory
	 */
	public LineGenerator(double maxLength, IShapeFactory factory) {
		if (maxLength < 0.0) {
			throw new IllegalArgumentException("Length must be 0 or greater");
		}

		this.xGenerator = new DoubleGenerator(0.0, maxLength);
		this.factory = factory;
	}

	/**
	 * Generate random lines between 0 100
	 *
	 * @param factory
	 */
	public LineGenerator(IShapeFactory factory) {
		this(100.0, factory);
	}

	@Override
	public ILine generate(Random r) {
		return factory.line(xGenerator.generate(r));
	}
}
