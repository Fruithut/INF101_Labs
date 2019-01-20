package inf101.v17.lab6.recursion;

import java.util.*;

public class Sorting {

    /**
     * Selection sort (destructive)
     * 
     * Below is an improved version of selection sort from class, modified to
     * sort a list containing any type of elements. (It also use a "swap" helper
     * method rather than making a copy of the array, which saves us some space,
     * though the main idea of the algorithm remains the same.)
     * 
     * @param lst
     */
    public static <T extends Comparable<T>> void selectionSort(List<T> lst) {
        // For each position k in the list starting with the leftmost position,
        // we put the smallest item from the remainder of the list here.
        for (int k = 0; k < lst.size(); k++) {
            // Step 1: Find the smallest element in remainder of list
            int minIdx = k;
            T minVal = lst.get(k);
            for (int i = k + 1; i < lst.size(); i++) {
                if (lst.get(i).compareTo(minVal) < 0) {
                    minIdx = i;
                    minVal = lst.get(i);
                }
            }
            // Step 2: Move that smallest element to position k
            Collections.swap(lst, k, minIdx);
        }
    }

    /**
     * Merge sort (destructive)
     * 
     * You should here write a version of merge sort which can sort any type of
     * array containing mutually comparable elements. You may refer to the
     * lecture notes, though this is also an excellent opportunity to see if you
     * remember the algorithm well enough to write it yourself.
     * 
     * @param lst list of mutually comparable elements to be sorted.
     */

    //Manual tester
    /*public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(6);
        x.add(3);
        x.add(4);
        System.out.println(x);
        mergeSort(x);
        System.out.println(x);
    }*/

    public static <T extends Comparable<T>> void mergeSort(List<T> lst) {
        List<T> copy = lst;
        ArrayList<T> helper = new ArrayList<>();
        mergesorter(copy, helper,0, copy.size() - 1);
    }

    private static <T extends Comparable<T>> void mergesorter(List<T> copy, ArrayList<T> helper, int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesorter(copy, helper, low, middle);
            // Sort the right side of the array
            mergesorter(copy, helper,middle + 1, high);
            // Combine them both
            merge(copy, helper, low, middle, high);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> copy, ArrayList<T> helper, int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper.add(i,copy.get(i));
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper.get(i).compareTo(helper.get(j)) <= 0) {
                copy.set(k, helper.get(i));
                i++;
            } else {
                copy.set(k, helper.get(j));
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            copy.set(k, helper.get(i));
            k++;
            i++;
        }

    }
}
