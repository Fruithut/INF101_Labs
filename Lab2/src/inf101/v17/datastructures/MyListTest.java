package inf101.v17.datastructures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import inf101.v17.cell.CellState;


public class MyListTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void setGetTest() {
		IList list = new MyList();
		Random rand = new Random();
		
		for(int i = 0; i < 1000; i++)
			list.add(CellState.random(rand));
		
		for(int i = 0; i < 1000; i++) {
			CellState element = CellState.random(rand);
			list.set(i, element);
			assertEquals(element, list.get(i));
		}
	}
}
