package inf101.v16.lab4.shapes.tests.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import inf101.v16.lab4.shapes.ICircle;
import inf101.v16.lab4.shapes.IShapeFactory;
import inf101.v16.util.IGenerator;
import inf101.v16.util.generators.CircleGenerator;
import inf101.v16.util.generators.DoubleGenerator;

import org.junit.Test;

public abstract class AbstractCircleTest extends AbstractShapeTest<ICircle> {

	private final IShapeFactory factory;

	public AbstractCircleTest(IShapeFactory factory) {
		super(new CircleGenerator(factory));
		this.factory = factory;
	}

	public void areaProperty(ICircle r) {
		assertApproxEquals("Area should be pi*radius^2",
				Math.PI * r.getRadius() * r.getRadius(), r.getArea());
	}

	public void checkReturnBounds(ICircle s) {
		assertTrue("Width should be non-negative: " + s.getWidth(),
				s.getWidth() >= 0.0);
		assertTrue("Height should be non-negative: " + s.getHeight(),
				s.getHeight() >= 0.0);
		assertTrue("Radius should be non-negative: " + s.getRadius(),
				s.getRadius() >= 0.0);
		assertTrue("Area should be non-negative: " + s.getArea(),
				s.getArea() >= 0.0);
		assertTrue(
				"Circumference should be non-negative: " + s.getCircumference(),
				s.getCircumference() >= 0.0);
	}

	public void circumferenceProperty(ICircle r) {
		assertApproxEquals("Circumference should be 2*pi*radius",
				2 * r.getRadius() * Math.PI, r.getCircumference());
	}

	public void radiusWidthHeightProperty(ICircle r) {
		assertEquals(r.getRadius() * 2, r.getWidth(), 0.0);
		assertEquals(r.getRadius() * 2, r.getHeight(), 0.0);
	}

	public void setGetRadiusProperty(ICircle r, double d) {
		r.setRadius(d);

		assertEquals(d, r.getRadius(), 0.0);
	}

	public void sizeBoxProperty(ICircle r) {
		assertEquals(r.getRadius() * 2, r.getSizeBox().getWidth(), 0.0);
		assertEquals(r.getRadius() * 2, r.getSizeBox().getHeight(), 0.0);

	}

	@Test
	public void testCircleArea() {
		for (int i = 0; i < N; i++) {
			areaProperty(gen.generate());
		}
	}

	@Test
	public void testCircleCirc() {
		for (int i = 0; i < N; i++) {
			circumferenceProperty(gen.generate());
		}
	}

	@Test
	public void testCircleSetGetRadius() {
		for (int i = 0; i < N; i++) {
			setGetRadiusProperty(gen.generate(), doubleGen.generate());
		}
	}

	@Test
	public void testCircleSizeBox() {
		for (int i = 0; i < N; i++) {
			sizeBoxProperty(gen.generate());
		}
	}

	@Test
	public void testIllegalArgs() {
		ICircle circle = gen.generate();

		try {
			circle.setRadius(-2);
			fail("Negative sizes should be forbidden");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	@Test
	public void testInvariants1() {
		for (int i = 0; i < N; i++) {
			checkReturnBounds(gen.generate());
		}
	}

	@Test
	public void testInvariants2() {
		// generate all sorts of sizes, including (invalid) negative ones
		IGenerator<Double> dGen = new DoubleGenerator(-Double.MAX_VALUE,
				Double.MAX_VALUE);

		for (int i = 0; i < 10 * N; i++) {
			try {
				// this should fail with an IllegalArgumentException if the
				// sizes are inappropriate
				ICircle shape = factory.circle(dGen.generate());

				checkReturnBounds(shape); // otherwise we'll find bad data here
			} catch (IllegalArgumentException e) {
				// expected
			}
		}

		try {
			ICircle shape = gen.generate();
			// this should fail with an IllegalArgumentException if the
			// sizes are inappropriate
			shape.setRadius(dGen.generate());

			checkReturnBounds(shape); // otherwise we'll find bad data here
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
}
