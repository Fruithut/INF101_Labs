package inf101.v17.tests;
import static org.junit.Assert.*;

import inf101.v17.util.IGenerator;
import inf101.v17.util.generators.StringGenerator;

import org.junit.Test;

import java.util.List;

public class StringTest {
	private final IGenerator<String> strGen = new StringGenerator();
	private final int N = 100000;

	public void transitiveProperty(String s1, String s2, String s3) {
		if(s1.equals(s2) && s2.equals(s3)) {assertEquals(s1, s3);}
	}

	public void reflexiveProperty(String s1) {
		assertEquals(s1, s1);
	}

	public void symmetricProperty(String s1, String s2) {
		if(s1.equals(s2)) {assertEquals(s2,s1);}
	}

	public void hashEqualsProp(String s1, String s2) {
		if (s1.equals(s2)){
			assertEquals(s1.hashCode(),s2.hashCode());
		}
	}

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

	@Test
	public void stringTransitiveTest() {
		String one, two, three;
		for (int i = 0; i < N; i++) {
			one = strGen.generate();
			two = strGen.generate();
			three = strGen.generate();
			transitiveProperty(one,two,three);
		}
	}

	@Test
	public void stringTransitiveTest2() {
		for (int i = 0; i < N; i++) {
			List<String> rand = strGen.generateEquals(3);
			transitiveProperty(rand.get(0),rand.get(1), rand.get(2));
		}
	}

	@Test
	public void stringReflexiveTest() {
		for (int i = 0; i < N; i++) {
			reflexiveProperty(strGen.generate());
		}
	}

	@Test
	public void stringSymmetricTest() {
		String one, two;
		for (int i = 0; i < N; i++) {
			one = strGen.generate();
			two = strGen.generate();
			symmetricProperty(one,two);
		}
	}

	@Test
	public void stringHashTest() {
		String one, two;
		for (int i = 0; i < N; i++) {
			one = strGen.generate();
			two = strGen.generate();
			hashEqualsProp(one,two);
		}
	}

}

