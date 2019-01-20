package inf101.v17.lab6.shapes.tests.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import inf101.v17.lab6.shapes.IRectangle;
import inf101.v17.lab6.shapes.IShapeFactory;
import inf101.v17.util.IGenerator;
import inf101.v17.util.generators.DoubleGenerator;
import inf101.v17.util.generators.RectangleGenerator;

import org.junit.Test;

/**
 * Common tests for all implementations of IRectangle
 *
 * @author anya
 *
 */
public abstract class AbstractRectangleTest extends
AbstractShapeTest<IRectangle> {

	public final IShapeFactory factory;

	public AbstractRectangleTest(IShapeFactory factory) {
		super(new RectangleGenerator(factory));
		this.factory = factory;
	}

	public void areaProperty(IRectangle r) {
		assertApproxEquals("Area should be width*height",
				r.getWidth() * r.getHeight(), r.getArea());
	}

	/**
	 * Check that return values are always within bounds
	 */
	public void checkReturnBounds(IRectangle s) {
		assertTrue("Area should be non-negative: " + s.getArea(),
				s.getArea() >= 0.0);
		assertTrue(
				"Circumference should be non-negative: " + s.getCircumference(),
				s.getCircumference() >= 0.0);
		assertTrue("Width should be non-negative: " + s.getWidth(),
				s.getWidth() >= 0.0);
		assertTrue("Height should be non-negative: " + s.getHeight(),
				s.getHeight() >= 0.0);
	}

	public void circumferenceProperty(IRectangle r) {
		assertApproxEquals("Circumference should be 2*width+2*height",
				2 * r.getWidth() + 2 * r.getHeight(), r.getCircumference());
	}

	public void setGetHeightProperty(IRectangle r, double d) {
		double w = r.getWidth();
		r.setHeight(d);

		assertEquals("Setting height should change height", d, r.getHeight(),
				0.0);
		assertEquals("Setting height should not change width", w, r.getWidth(),
				0.0); // width and height are independent
	}

	public void setGetWidthProperty(IRectangle r, double d) {
		double h = r.getHeight();
		r.setWidth(d);

		assertEquals("Setting width should change width", d, r.getWidth(), 0.0);
		assertEquals("Setting width should not change height", h,
				r.getHeight(), 0.0); // width and height are independent
	}

	public void sizeBoxProperty(IRectangle r) {
		assertEquals("SizeBox should be equal to rectangle itself", r,
				r.getSizeBox());
	}

	/**
	 * Test that illegal arguments are rejected with an exception.
	 */
	@Test
	public void testIllegalArgs1() {
		IRectangle rect = gen.generate();

		try {
			rect.setHeight(-2);
			fail("Negative sizes should be forbidden");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	/**
	 * Test that illegal arguments are rejected with an exception.
	 */
	@Test
	public void testIllegalArgs2() {
		IRectangle rect = gen.generate();

		try {
			rect.setWidth(-2);
			fail("Negative sizes should be forbidden");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	/**
	 * Check that return values are always within bounds
	 */
	@Test
	public void testInvariants1() {
		for (int i = 0; i < N; i++) {
			checkReturnBounds(gen.generate());
		}
	}

	/**
	 * Check that return values are within bounds even if we attempt to
	 * construct illegal object (e.g. with negative sizes)
	 */
	@Test
	public void testInvariants2() {
		// generate all sorts of sizes, including (invalid) negative ones
		IGenerator<Double> dGen = new DoubleGenerator(-Double.MAX_VALUE,
				Double.MAX_VALUE);

		for (int i = 0; i < 10 * N; i++) {
			try {
				// this should fail with an IllegalArgumentException if the
				// sizes are inappropriate
				IRectangle shape = factory.rectangle(dGen.generate(),
						dGen.generate());

				checkReturnBounds(shape); // otherwise we'll find bad data here
			} catch (IllegalArgumentException e) {
				// expected
			}
		}

		try {
			IRectangle shape = gen.generate();
			// this should fail with an IllegalArgumentException if the
			// sizes are inappropriate
			shape.setWidth(dGen.generate());
			shape.setHeight(dGen.generate());

			checkReturnBounds(shape); // otherwise we'll find bad data here
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	/**
	 * Test that getArea() is correct
	 */
	@Test
	public void testRectArea() {
		for (int i = 0; i < N; i++) {
			areaProperty(gen.generate());
			areaProperty(gen.generate().getSizeBox());
		}
	}

	/**
	 * Test that getCircumference is correct
	 */
	@Test
	public void testRectCirc() {
		for (int i = 0; i < N; i++) {
			circumferenceProperty(gen.generate());
			circumferenceProperty(gen.generate().getSizeBox());
		}
	}

	/**
	 * Test effect and independence of set/get
	 */
	@Test
	public void testRectSetGetHeight() {
		for (int i = 0; i < N; i++) {
			setGetHeightProperty(gen.generate(), doubleGen.generate());
		}
	}

	/**
	 * Test effect and independence of set/get
	 */
	@Test
	public void testRectSetGetWidth() {
		for (int i = 0; i < N; i++) {
			setGetWidthProperty(gen.generate(), doubleGen.generate());
		}
	}

	/**
	 * Test that the sizebox is an equal rectangle to this one
	 */
	@Test
	public void testRectSizeBox() {
		for (int i = 0; i < N; i++) {
			sizeBoxProperty(gen.generate());
		}
	}
}
