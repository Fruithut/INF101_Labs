package inf101.v17.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class GridTest {
	Random random = new Random();

	/**
	 * Tests that trying to access outside of the dimensions of the grid throws
	 * an IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsTest() {
		IGrid<Integer> grid = new MyGrid<Integer>(10, 10, 0);

		try {
			grid.set(11, 0, 4);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.set(0, 11, 4);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
	}

	@Test
	public void setGetTest1() {
		IGrid<Integer> grid = new MyGrid<>(100, 100, 0);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				Integer i = random.nextInt();
				grid.set(x, y, i);
				assertEquals(i, grid.get(x, y));
			}
	}

	@Test
	public void setGetTest2() {
		IGrid<Integer> grid = new MyGrid<>(100, 100, 0);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, x * y);
			}

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, x * y);
				assertEquals(x * y, (int) grid.get(x, y));
			}
	}
	
	@Test
	public void copyTest() {
		IGrid<Integer> grid = new MyGrid<>(100, 100, 0);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				Integer i = random.nextInt();
				grid.set(x, y, i);
			}
		
		IGrid<Integer> newGrid = grid.copy();
		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				assertEquals(grid.get(x, y), newGrid.get(x,y));
			}
	}
}
