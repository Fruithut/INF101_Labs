package inf101.v17.lab6.recursion.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import inf101.v17.lab6.recursion.Sorting;
import inf101.v17.util.IGenerator;
import inf101.v17.util.generators.IntGenerator;
import inf101.v17.util.generators.ListGenerator;
import inf101.v17.util.generators.StringGenerator;

/**
 * @author anya
 *
 */
public class TestSorting {
	public static final int N = 500;
	public static final int LISTLEN = 1000;
	public static final IGenerator<List<Integer>> intListGen = new ListGenerator<>(new IntGenerator(), LISTLEN);
	public static final IGenerator<List<String>> strListGen = new ListGenerator<>(new StringGenerator(), LISTLEN);

	/**
	 * Simple test for selection sort
	 */
	@Test
	public void testSelectionSort1() {
		for (int i = 0; i < N; i++) {
			doTestSelectionSort(intListGen.generate());
			doTestSelectionSort(strListGen.generate());
		}
	}


	/**
	 * Simple test for selection sort
	 */
	@Test
	public void testSelectionSort2() {
		for (int i = 0; i < N; i++) {
			List<Integer> intList = intListGen.generate();
			Sorting.selectionSort(intList);
			listOrderedProperty(intList);
			
			
			List<String> strList = strListGen.generate();
			Sorting.selectionSort(strList);
			listOrderedProperty(strList);
		}
	}

	/**
	 * Simple test for selection sort
	 */
	@Test
	public void testMergeSort1() {
		for (int i = 0; i < N; i++) {
			doTestMergeSort(intListGen.generate());
			doTestMergeSort(strListGen.generate());
		}
	}


	/**
	 * Simple test for selection sort
	 */
	@Test
	public void testMergeSort2() {
		for (int i = 0; i < N; i++) {
			List<Integer> intList = intListGen.generate();
			Sorting.mergeSort(intList);
			listOrderedProperty(intList);
			
			
			List<String> strList = strListGen.generate();
			Sorting.mergeSort(strList);
			listOrderedProperty(strList);
		}
	}

	
	/**
	 * Helper function to test selection sort on a single given list.
	 * 
	 * @param lst
	 *            the list on which to test selection sort
	 */
	private <T extends Comparable<T>> void doTestSelectionSort(List<T> lst) {
		List<T> cpy = new ArrayList<T>(lst);
		Collections.sort(cpy);
		Sorting.selectionSort(lst);
		assertTrue(lst.equals(cpy));
	}

	/**
	 * If a list is sorted, then, for any two indices i and j, i < j <=> list.get(i) < list.get(j).
	 * 
	 * You could use this property by calling it many times on a sorted list, with many different values for i and j.
	 * 
	 * @param lst
	 * @param i
	 * @param j
	 */
	private <T extends Comparable<T>> void elementsOrderedProperty(List<T> lst, int i, int j) {
		if (lst.size() > 0) {
			i = Math.abs(i) % lst.size();
			j = Math.abs(j) % lst.size();
			
			assertEquals("Expected " + lst.get(i) + " <= " + lst.get(j), Integer.compare(i, j), lst.get(i).compareTo(lst.get(j)));
		}
	}

	/**
	 * If a list is sorted, any element earlier in the list should be smaller or equal to the next element.
	 * 
	 * The property method checks that the whole list is sorted.
	 * 
	 * @param lst
	 */
	private <T extends Comparable<T>> void listOrderedProperty(List<T> lst) {
		if (lst.size() > 1) {
			T lastElement = lst.get(0); // pick first element
			
			// iterate through the rest of the list
			for(int i = 1; i < lst.size(); i++) {
				assertTrue("Expected element " + (i-1) + "=" + lastElement + " to be less than/equal to element " + i + "=" + lst.get(i), lastElement.compareTo(lst.get(i)) <= 0);
				lastElement = lst.get(i);
			}
		}
		else {
			assertTrue(true); // a list of size 1 or smaller is always sorted
		}
	}

	
	/**
	 * Helper function to test merge sort on a single given list. Note that this
	 * currently do not call merge sort at all, and will likely fail.
	 * 
	 * @param lst
	 *            the list on which to test merge sort
	 */
	private <T extends Comparable<T>> void doTestMergeSort(List<T> lst) {
		List<T> cpy = new ArrayList<T>(lst);
		Collections.sort(cpy);
		Sorting.mergeSort(lst);
		assertEquals(cpy, lst); 
	}

}
