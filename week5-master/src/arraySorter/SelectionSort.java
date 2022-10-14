package arraySorter;

import genericMethods.Swap;

/**
 * The implementation of selection sort
 *
 * @author Luc Taggart
 * @version November 2019
 */

public class SelectionSort<T extends Comparable<? super T>> implements ArraySort<T> {

    /**
     * Sort the array according to the quick sort method.
     *
     * @param array the array being sorted.
     * @return return the sorted array.
     */

    public T[] sort(T[] array) {

        int n = array.length;

        // One by one move boundary of unsorted sub-array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[min_idx]) < 0) {

                    min_idx = j;
                    // Swap the found minimum element with the first element
                }
            }
            //imported method made from week5
            //swaps the two items located at given index's
            Swap.swap(array, min_idx, i);
        }
        return array;
    }
}
