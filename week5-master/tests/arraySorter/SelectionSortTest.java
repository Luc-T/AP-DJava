package arraySorter;

/**
 * A tester for selection sort.
 *
 * @param <T> the type of object in the arrays that this sorter sorts.
 *
 * @author Luc Taggart
 * @version November 2019
 */
public abstract class SelectionSortTest<T extends Comparable<? super T>> extends ArraySortTest<T> {
    @Override
    ArraySort<T> getSorter() {
        return new SelectionSort<T>();
    }
}