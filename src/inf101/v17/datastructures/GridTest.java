package inf101.v17.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import inf101.v17.cell.CellState;

public class GridTest {
	Random random = new Random();

	/**
	 * Tests that trying to access outside of the dimensions of the grid throws
	 * an IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsTest() {
		IGrid grid = new MyGrid(10, 10, CellState.DEAD);

		try {
			grid.set(11, 0, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.set(0, 11, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
	}

	@Test
	public void setGetTest1() {
		IGrid grid = new MyGrid(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
				assertEquals(cs, grid.get(x, y));
			}
	}

	@Test
	public void setGetTest2() {
		IGrid grid = new MyGrid(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, CellState.random(random));
			}
		}

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
				assertEquals(cs, grid.get(x, y));
			}
	}

	@Test
	public void copyTest() {
		IGrid grid = new MyGrid(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
			}
		}

		IGrid newGrid = grid.copy();
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				assertEquals(grid.get(x, y), newGrid.get(x, y));
			}
		}
	}

	/**
	 * Test for height
	 */
	@Test
	public void getHeightTest() {
		IGrid grid = new MyGrid(50,50, CellState.DEAD);
		assertEquals(50, grid.getHeight());
	}

	/**
	 * Test for width
	 */
	@Test
	public void getWidthTest() {
		IGrid grid = new MyGrid(60,60, CellState.DEAD);
		assertEquals(60, grid.getWidth());
	}

	/**
	 * Test for a grid size of 0,0.
	 */
	/*@Test
	public void gridSizeTest1() {
		try {
			IGrid grid = new MyGrid(0,0, CellState.DEAD);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Decide between returning with error message or setting grid to minimum values");
		}
	}*/
}
