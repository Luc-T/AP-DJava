package genericMethods;

/**
 * This class goes through two points in a given array
 * and compares each element, returning the largest between
 * the two (excluding last).
 *
 * @author Luc Taggart
 * @version October 2019
 * */

public class Max {

    /**
     * Find largest object
     * @param <T> the type of objects being compared
     * @param array the array containing the objects being compared
     * @param first where Max() begins its comparison
     * @param second the index Max() will search to but not compare(exclusive)
     * */

    public static <T extends Comparable<? super T>> T max(T[] array, int first, int second) {
        T largest = array[first];
        for (int i = first+1; i < second; i++) {
            if (largest.compareTo(array[i]) < 0) {
                largest = array[i];
            }
        }
        return largest;
    }
}
