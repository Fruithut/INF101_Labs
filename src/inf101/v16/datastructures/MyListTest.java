package inf101.v16.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyListTest {
	Random random = new Random();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addGetTest() {
		IList<Integer> list = new MyList<>();
		
		for(int i = 0; i < 100; i++)
			list.add(i);
		
		for(int i = 0; i < 100; i++)
			assertEquals(i, (int)list.get(i));
		
		assertEquals(100, list.size());
	}
	
	@Test
	public void setGetTest() {
		IList<Integer> list = new MyList<>();
		
		for(int i = 0; i < 1000; i++)
			list.add(random.nextInt());
		
		for(int i = 0; i < 1000; i++) {
			int element = random.nextInt();
			list.set(i, element);
			assertEquals(element, (int)list.get(i));
		}
	}
}
