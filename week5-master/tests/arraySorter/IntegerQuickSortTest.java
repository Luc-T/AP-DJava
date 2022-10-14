package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import scope.IntegerScope;

/**
 * Tests quick sort for integer arrays.
 *
 * @author Luc Taggart
 * @version November 2019
 */
public class IntegerQuickSortTest extends QuickSortTest<Integer>{
    @Override
    ArrayGenerator<Integer> getGenerator() {
        return new IntegerArrayGenerator(new IntegerScope());
    }
}
