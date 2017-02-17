package inf101.v17.tests;

import static org.junit.Assert.*;

import inf101.v17.datastructures.IGrid;
import inf101.v17.datastructures.MyGrid;
import inf101.v17.util.IGenerator;
import inf101.v17.util.generators.IntGenerator;
import inf101.v17.util.generators.MyGridGenerator;
import inf101.v17.util.generators.StringGenerator;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyGridTest {
	private static final int N = 1000000/100;

	private IGenerator<String> strGen = new StringGenerator();
	private IGenerator<IGrid<String>> gridGen = new MyGridGenerator<String>(strGen);
	private IGenerator<Integer> intGen = new IntGenerator(1, 100);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test that get gives back the same value after set.
	 */
	@Test
	public void setGetTest() {
		IGrid<String> grid = gridGen.generate();

		IGenerator<Integer> wGen = new IntGenerator(0, grid.getWidth());
		IGenerator<Integer> hGen = new IntGenerator(0, grid.getHeight());

		for (int i = 0; i < N; i++) {
			int x = wGen.generate();
			int y = hGen.generate();
			String s = strGen.generate();
			
			setGetProperty(grid, x, y, s);
		}
	}

	@Test
	public void setGetIndependentTest() {
		IGrid<String> grid = gridGen.generate();

		IGenerator<Integer> wGen = new IntGenerator(0, grid.getWidth());
		IGenerator<Integer> hGen = new IntGenerator(0, grid.getHeight());

		IGenerator<Integer> wGen2 = new IntGenerator(0, grid.getWidth());
		IGenerator<Integer> hGen2 = new IntGenerator(0, grid.getHeight());

		for (int i = 0; i < N; i++) {
			int x = wGen.generate(), y = hGen.generate();
			int x2 = wGen2.generate(), y2 = hGen2.generate();
			String s = strGen.generate();

			setGetIndependentProperty(grid, x, y, x2,y2, s);
		}
	}

	@Test
	public void widthTest() {
		for (int i = 0; i < N; i++) {
			int x = intGen.generate(), y = intGen.generate();
			String undefined = strGen.generate();
			IGrid<String> random = new MyGrid<>(x,y,undefined);

			assertEquals(x,random.getWidth());
		}
	}

	@Test
	public void heightTest() {
		for (int i = 0; i < N; i++) {
			int x = intGen.generate(), y = intGen.generate();
			String undefined = strGen.generate();
			IGrid<String> random = new MyGrid<>(x,y,undefined);

			assertEquals(y,random.getHeight());
		}
	}

	/**
	 * get(x,y) is val after set(x, y, val)
	 */
	private <T> void setGetProperty(IGrid<T> grid, int x, int y, T val) {
		grid.set(x,y,val);
		assertEquals(val, grid.get(x,y));
	}

	/**
	 * A set on (x1,y1) doesn't affect a get on a different (x2,y2)
	 */
	private <T> void setGetIndependentProperty(IGrid<T> grid, int x1, int y1, int x2, int y2, T val) {
		if (x1 != x2 && y1 != y2) {
			T s = grid.get(x2, y2);
			grid.set(x1, y1, val);
			assertEquals(s, grid.get(x2, y2));
		}
	}

	//Below; tests after StringTest-format
	public void transitiveProperty(IGrid s1, IGrid s2, IGrid s3) {
		if(s1.equals(s2) && s2.equals(s3)) {assertEquals(s1, s3);}
	}

	public void reflexiveProperty(IGrid s1) {
		assertEquals(s1, s1);
	}

	public void symmetricProperty(IGrid s1, IGrid s2) {
		if(s1.equals(s2)) {assertEquals(s2,s1);}
	}

	public void hashEqualsProp(IGrid s1, IGrid s2) {
		if (s1.equals(s2)){
			assertEquals(s1.hashCode(),s2.hashCode());
		}
	}

	@Test
	public void gridTransitiveTest() {
		IGrid one, two, three;
		for (int i = 0; i < N; i++) {
			one = gridGen.generate();
			two = gridGen.generate();
			three = gridGen.generate();
			transitiveProperty(one,two,three);
		}
	}

	@Test
	public void gridTransitiveStringTest2() {
		for (int i = 0; i < N; i++) {
			List<IGrid<String>> rand = gridGen.generateEquals(3);
			transitiveProperty(rand.get(0),rand.get(1), rand.get(2));
		}
	}

	@Test
	public void gridReflexiveTest() {
		for (int i = 0; i < N; i++) {
			reflexiveProperty(gridGen.generate());
		}
	}

	@Test
	public void gridSymmetricTest() {
		IGrid one, two;
		for (int i = 0; i < N; i++) {
			one = gridGen.generate();
			two = gridGen.generate();
			symmetricProperty(one,two);
		}
	}

	@Test
	public void gridHashTest() {
		IGrid one, two;
		for (int i = 0; i < N; i++) {
			one = gridGen.generate();
			two = gridGen.generate();
			hashEqualsProp(one,two);
		}
	}


}
