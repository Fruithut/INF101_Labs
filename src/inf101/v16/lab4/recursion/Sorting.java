package inf101.v16.lab4.recursion;

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
    public static <T extends Comparable<T>> void selectionSort(T[] lst) {
        // For each position k in the list starting with the leftmost position,
        // we put the smallest item from the remainder of the list here.
        for (int k = 0; k < lst.length; k++) {
            // Step 1: Find the smallest element in remainder of list
            int minIdx = k;
            T minVal = lst[k];
            for (int i = k + 1; i < lst.length; i++) {
                if (lst[i].compareTo(minVal) < 0) {
                    minIdx = i;
                    minVal = lst[i];
                }
            }
            // Step 2: Move that smallest element to position k
            swap(lst, k, minIdx);
        }
    }

    /**
     * Swaps two elements of an array (destructive)
     * 
     * @param lst
     *            the array of elements
     * @param i
     *            the index of the first element
     * @param j
     *            the index of the second element
     */
    private static <T> void swap(T[] lst, int i, int j) {
        T tmp = lst[i];
        lst[i] = lst[j];
        lst[j] = tmp;
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
    // TODO: Write mergeSort()

}
