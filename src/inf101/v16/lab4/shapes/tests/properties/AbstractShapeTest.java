package inf101.v16.lab4.shapes.tests.properties;

import static org.junit.Assert.assertEquals;
import inf101.v16.lab4.shapes.IShape;
import inf101.v16.util.IGenerator;
import inf101.v16.util.generators.DoubleGenerator;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractShapeTest<S extends IShape> {
	protected final IGenerator<S> gen;
	protected final IGenerator<Double> doubleGen = new DoubleGenerator();

	protected static final int N = 1000;

	public static void assertApproxEquals(double d1, double d2) {
		assertEquals(d1, d2, Math.abs(d1 / 1e6));
	}

	public static void assertApproxEquals(String msg, double d1, double d2) {
		assertEquals(msg, d1, d2, Math.abs(d1 / 1e6));
	}

	public AbstractShapeTest(IGenerator<S> gen) {
		this.gen = gen;
	}

	public void areaProperty(IShape s) {
		Assert.assertTrue("Area should be <= area of size box (" + s.getArea()
				+ " > " + s.getSizeBox().getArea() + ")", s.getArea() <= s
				.getSizeBox().getArea());
	}

	@Test
	public void equalsTest() {
		StandardProperties.allEqualsTests(gen, N);
	}

	public void heightProperty(IShape s) {
		assertEquals(s.getSizeBox().getHeight(), s.getHeight(), 0.0);
	}

	@Test
	public void testArea() {
		for (int i = 0; i < N; i++) {
			areaProperty(gen.generate());
		}
	}

	@Test
	public void testHeight() {
		for (int i = 0; i < N; i++) {
			heightProperty(gen.generate());
		}
	}

	@Test
	public void testWidth() {
		for (int i = 0; i < N; i++) {
			widthProperty(gen.generate());
		}
	}

	@Test
	public void toStringTest() {
		StandardProperties.toStringEqualStrongTest(gen, N);
	}

	public void widthProperty(IShape s) {
		assertEquals(s.getSizeBox().getWidth(), s.getWidth(), 0.0);
	}

}
