package arraySorter;

/**
 * A tester for quick sort.
 *
 * @param <T> the type of object in the arrays that this sorter sorts.
 *
 * @author Luc Taggart
 * @version November 2019
 */
public abstract class QuickSortTest<T extends Comparable<? super T>> extends ArraySortTest<T> {
    @Override
    ArraySort<T> getSorter() {
        return new QuickSort<T>();
    }
}
