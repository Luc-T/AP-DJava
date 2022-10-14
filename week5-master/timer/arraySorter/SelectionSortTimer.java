package arraySorter;


import timer.Timer;

/**
 * Base implementation for selection sort timers.
 *
 * @param <T> the type of object sorted by the selection sort to be timed.
 *
 * @author Luc Taggart
 * @version November 2019
 */
public abstract class SelectionSortTimer<T extends Comparable<? super T>> extends SelectionSort<T> implements Timer {

    private T[] array; // this is the array that will be sorted

    void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public void timedMethod() {
        sort(array);
    }

    @Override
    public long getMaximumRuntime() {
        return 8;
    }

    @Override
    public int getMinimumTaskSize() {
        return 1;
    }

    @Override
    public int getMaximumTaskSize() {
        return 1000000000;
    }

    @Override
    public int getRunSetSize() {
        return 10;
    }
}