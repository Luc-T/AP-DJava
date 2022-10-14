package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceCountingSortTest {
    ReferenceCountingSort<Integer> rcs = new ReferenceCountingSort<>();

    void initialiseTest() throws GraphError {
        rcs.add(0);
        rcs.add(1);
        rcs.add(2);
        rcs.add(3);
        rcs.add(4);
        rcs.add(5);
        rcs.add(6);
        rcs.add(7);
        rcs.add(8);
        rcs.add(9);
        rcs.add(0, 5);
        rcs.add(0, 1);
        rcs.add(1, 7);
        rcs.add(3, 2);
        rcs.add(3, 8);
        rcs.add(3, 4);
        rcs.add(6, 0);
        rcs.add(6, 1);
        rcs.add(6, 2);
        rcs.add(8, 7);
        rcs.add(8, 4);
        rcs.add(9, 4);
    }

    @Test
    void testGetSort() throws GraphError {
        initialiseTest();

        List<Integer> traAns = new ArrayList<Integer>();
        int[] ans = {3, 6, 0, 1, 2, 5, 8, 7, 9, 4};
        for (int id: ans) {
            traAns.add(id);
        }
        List<Integer> traList;
        traList = rcs.getSort();
        for (Integer i : traAns) {
            assertEquals(traAns.get(i), traList.get(i));
        }
    }

}