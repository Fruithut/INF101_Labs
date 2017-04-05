package inf101.v17.lab6.shapes.tests.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import inf101.v17.lab6.shapes.ILine;
import inf101.v17.lab6.shapes.IShapeFactory;
import inf101.v17.util.generators.LineGenerator;

import org.junit.Test;

public abstract class AbstractLineTest extends AbstractShapeTest<ILine> {

	public AbstractLineTest(IShapeFactory factory) {
		super(new LineGenerator(factory));
	}

	public void areaProperty(ILine r) {
		assertApproxEquals("Area should be width*height",
				r.getWidth() * r.getHeight(), r.getArea());
	}

	public void circumferenceProperty(ILine r) {
		assertApproxEquals("Circumference should be 2*width+2*height",
				2 * r.getWidth() + 2 * r.getHeight(), r.getCircumference());
	}

	public void lengthWidthProperty(ILine r) {
		assertEquals("Line length should be equal to width", r.getLength(), r.getWidth(), 0.0);
	}

	public void setGetLengthProperty(ILine r, double d) {
		r.setLength(d);

		assertEquals(d, r.getLength(), 0.0);
	}

	public void sizeBoxProperty(ILine r) {
		assertEquals(r.getLength(), r.getSizeBox().getWidth(), 0.0);
	}

	@Test
	public void testIllegalArgs() {
		ILine line = gen.generate();

		try {
			line.setLength(-2);
			fail("Negative sizes should be forbidden");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	@Test
	public void testLineArea() {
		for (int i = 0; i < N; i++) {
			areaProperty(gen.generate());
		}
	}

	@Test
	public void testLineCirc() {
		for (int i = 0; i < N; i++) {
			circumferenceProperty(gen.generate());
		}
	}

	@Test
	public void testLineSetGetLength() {
		for (int i = 0; i < N; i++) {
			setGetLengthProperty(gen.generate(), doubleGen.generate());
		}
	}

	@Test
	public void testLineSizeBox() {
		for (int i = 0; i < N; i++) {
			sizeBoxProperty(gen.generate());
		}
	}

}
