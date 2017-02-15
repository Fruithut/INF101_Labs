package inf101.v17.tests;
import static org.junit.Assert.*;

import inf101.v17.util.IGenerator;
import inf101.v17.util.generators.StringGenerator;

import org.junit.Test;

public class StringTest {
	private final IGenerator<String> strGen = new StringGenerator();
	private final int N = 100000;
	@Test
	public void stringTest1() {
		assertEquals("foo", "FOO".toLowerCase());
	}
	
	@Test
	public void stringTest2() {
		for(int i = 0; i < N; i++) {
			String s = strGen.generate();
			
			assertEquals(s + s, s.concat(s));
		}
			
	}
}

