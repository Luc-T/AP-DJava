package genericMethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {
    /**
     * A section of tests for Max
     */

    private String[] people ={"Bob", "Tim", "A", "Timothy", "Bernard"};
    private Double[] doubleNums={5.1, 1.5, 7.0, 2.4};
    private Double[] doubleNums2={3.1, 7.5, 100.24, 22.1, 0.0, 100.24, 99.50, 246.8, 123.4};

    @Test
    void testLargerName() {
        assertEquals(Max.max(people, 0, 4), "Timothy");
    }
    @Test
    void testLargerDouble() {
        assertEquals(Max.max(doubleNums, 0, 3), 7.0);
    }
    @Test
    void testLargerDouble2() {
        assertEquals(Max.max(doubleNums2, 2, 8), 246.8);
    }
    @Test
    void testNotSmall() {
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> Max.max(doubleNums, 1,
                100));
    }

}