package genericMethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SwapTest {
    /**
     * A section of tests for swap
     */

    private String[] people ={"Bob", "Tim", "Timothy", "Bernard"};
    private Double[] doubleNums={5.1, 1.5, 7.0, 2.4};

    @Test
    void testNotEquals() {
        String[] peopleCopy = people.clone();
        assertNotEquals(Swap.swap(people, 1,3), peopleCopy);
    }

    @Test
    void testSwapStrings() {
        String[] peopleSwapped = {"Bob", "Bernard", "Timothy", "Tim"};
        assertArrayEquals(Swap.swap(people, 1,3), peopleSwapped);
    }

    @Test
    void testSwapFloats() {
        Double[] doublesSwapped = {2.4, 1.5, 7.0, 5.1};
        assertArrayEquals(Swap.swap(doubleNums, 0, 3), doublesSwapped);
    }

    @Test
    void testIndexTooSmall() throws IndexOutOfBoundsException {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Swap.swap(people, 2, -4);
        });
    }

    @Test
    void testIndexTooLarge() throws IndexOutOfBoundsException {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Swap.swap(people, 1, 400);
        });
    }
}
