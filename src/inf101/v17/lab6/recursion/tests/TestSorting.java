package inf101.v17.lab6.recursion.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import inf101.v17.lab6.recursion.Sorting;

public class TestSorting {
    public static final int TESTS = 5;
    public static final int LISTLEN = 10000 * 1;
    private static final Random r = new Random();

    /**
     * Simple test for selection sort
     */
    @Test
    public void testSelectionSortSimple() {
        Integer[] lst = { 3, 5, 7, 1, 9, 9, 3, 4, 2 };
        doTestSelectionSort(lst);
        String[] lst2 = { "Hello", "Rolling in the Deep", "Someone Like You", "Chasing Pavements"};
        doTestSelectionSort(lst2);
    }

    /**
     * Big test for selection sort
     */
    @Test
    public void testSelectionSortBig() {
        for (int i = 0; i < TESTS; i++) {
            Integer[] lst = new Integer[LISTLEN];
            for (int j = 0; j < LISTLEN; j++) {
                lst[j] = r.nextInt(LISTLEN) - (LISTLEN / 2);
            }
            doTestSelectionSort(lst);
        }
    }

    /**
     * Simple test for merge sort
     */
    @Test
    public void testMergeSortSimple() {
        Integer[] lst = { 3, 5, 7, 1, 9, 9, 3, 4, 2 };
        doTestMergeSort(lst);
        String[] lst2 = { "Hello", "Rolling in the Deep", "Someone Like You", "Chasing Pavements"};
        doTestMergeSort(lst2);
    }

    /**
     * Big test for merge sort
     */
    @Test
    public void testMergeSortBig() {
        for (int i = 0; i < TESTS; i++) {
            Integer[] lst = new Integer[LISTLEN];
            for (int j = 0; j < LISTLEN; j++) {
                lst[j] = r.nextInt(LISTLEN) - (LISTLEN / 2);
            }
            doTestMergeSort(lst);
        }
    }

    /**
     * Helper function to test selection sort on a single given list.
     * 
     * @param lst
     *            the list on which to test selection sort
     */
    private <T extends Comparable<T>> void doTestSelectionSort(T[] lst) {
        T[] cpy = Arrays.copyOf(lst, lst.length);
        Arrays.sort(cpy);
        Sorting.selectionSort(lst);
        assertTrue(Arrays.equals(lst, cpy));
    }
    
    /**
     * Helper function to test merge sort on a single given list. Note that this
     * currently do not call merge sort at all, and will likely fail.
     * 
     * @param lst
     *            the list on which to test merge sort
     */
    private <T extends Comparable<T>> void doTestMergeSort(T[] lst) {
        T[] cpy = Arrays.copyOf(lst, lst.length);
        Arrays.sort(cpy);
        // TODO: Uncomment below
        // Sorting.mergeSort(lst);
        assertTrue(Arrays.equals(lst, cpy));
    }

}
