package inf101.v16.lab4.shapes.tests;

import static org.junit.Assert.assertEquals;
import inf101.v16.util.IGenerator;
import inf101.v16.util.generators.DoubleGenerator;
import inf101.v16.util.generators.IntGenerator;
import inf101.v16.util.generators.LineGenerator;
import inf101.v16.util.generators.ListGenerator;
import inf101.v16.util.generators.RectangleGenerator;
import inf101.v16.util.generators.StringGenerator;

import java.util.List;
import java.util.Random;

import org.junit.Test;

public class GeneratorTest {
	private final Random rng = new Random();
	private static final int N = 10000;

	/**
	 * Test that all elements in the collection returned by gen.generateEquals
	 * are actually equal.
	 *
	 * @param gen
	 *            A generator
	 */
	public <T> void generateEqualsProperty(IGenerator<T> gen) {
		List<T> elements = gen.generateEquals(rng, 2);

		T obj = elements.get(0);

		for (T o : elements) {
			assertEquals(obj, o);
		}
	}

	@Test
	public void testDoubleGenerator() {
		for (int i = 0; i < N; i++) {
			generateEqualsProperty(new DoubleGenerator());
			generateEqualsProperty(new DoubleGenerator(i));
			generateEqualsProperty(new DoubleGenerator(-i, i + 1));
		}
	}

	@Test
	public void testIntGenerator() {
		for (int i = 0; i < N; i++) {
			generateEqualsProperty(new IntGenerator());
			generateEqualsProperty(new IntGenerator(i));
			generateEqualsProperty(new IntGenerator(-i, i + 1));
		}
	}

	@Test
	public void testLineGenerator() {
		for (int i = 0; i < N; i++) {
			generateEqualsProperty(new LineGenerator());
		}
		generateEqualsProperty(new LineGenerator());
	}

	@Test
	public void testListGenerator() {
		for (int i = 0; i < N; i++) {
			generateEqualsProperty(new ListGenerator<String>(
					new StringGenerator()));
		}
		generateEqualsProperty(new ListGenerator<>(new StringGenerator()));
	}



	@Test
	public void testRectangleGenerator() {
		for (int i = 0; i < N; i++) {
			generateEqualsProperty(new RectangleGenerator());
		}
		generateEqualsProperty(new RectangleGenerator());
	}

	@Test
	public void testStringGenerator() {
		for (int i = 0; i < N; i++) {
			generateEqualsProperty(new StringGenerator());
			generateEqualsProperty(new StringGenerator(i + 1));
		}
		generateEqualsProperty(new StringGenerator(10, N));
	}

}
