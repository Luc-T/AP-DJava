package arraySorter;

import genericMethods.Swap;

/**
 * The implementation of quick sort
 *
 * @author Luc Taggart
 * @version November 2019
 */

public class QuickSort<T extends Comparable<? super T>> implements ArraySort<T> {

    /**
     * Sorts the array using the quick sort method.
     *
     * @param array the array to be sorted.
     * @return returns sorted array.
     */

    public T[] sort(T[] array) {
        int high = array.length;
        //Send array, first index and last index to an iterative method
        this.sorter(array, 0, high-1);

        return array;
    }

    /**
     * Sorts items between the two index's
     *
     * @param array array being sorted
     * @param low the lower side of the part of the array being sorted
     * @param high the further side of the part of the array being sorted
     * @return returns the new partition index for sorter()
     */

    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low-1; // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (pivot.compareTo(array[j]) > 0) {
                i++;

                Swap.swap(array, i, j);
            }
        }

        Swap.swap(array, i+1, high);
        return i+1;
    }

    /**
     * Finds the pivot by comparing the current element
     *
     * @param array array being sorted
     * @param low used as the start of the array
     * @param high used as the end of the array
     */
    public void sorter(T[] array, int low, int high) {
        if (low < high) {
            // puts array[partitionIndex] at right place
            int partitionIndex = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            sorter(array, low, partitionIndex-1);
            sorter(array, partitionIndex+1, high);
        }
    }

}
