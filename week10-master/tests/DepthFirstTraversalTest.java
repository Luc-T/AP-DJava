import graph.AdjacencyGraph;
import graph.DepthFirstTraversal;
import graph.GraphError;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstTraversalTest {
    DepthFirstTraversal<Integer> dft = new DepthFirstTraversal<>();

    void initialiseTest() throws GraphError {
        dft.add(0);
        dft.add(1);
        dft.add(2);
        dft.add(3);
        dft.add(4);
        dft.add(5);
        dft.add(0, 1);
        dft.add(0, 3);
        dft.add(1, 2);
        dft.add(2, 1);
        dft.add(2, 4);
        dft.add(2, 5);
        dft.add(4, 5);
        dft.add(5, 4);
    }

    //test the traversal contains all the nodes in the graph
    @Test
    void testContains() throws GraphError {
        int[] ans = {0, 1, 2, 4, 5, 3};
        List<Integer> traAns = new ArrayList<Integer>();
        for (int id: ans) {
            traAns.add(id);
        }
        List<Integer> traList;
        initialiseTest();
        traList = dft.traverse();
        for (Integer i : traAns) {
            assertTrue(traAns.contains(traList.get(i)));
        }
    }

    //test the traversal result has the same number of nodes as the graph
    @Test
    void testSize() throws GraphError {
        List<Integer> traList;
        initialiseTest();
        traList = dft.traverse();
        assertEquals(6, traList.size());
    }

    //test the sort to affirm it has no repeats in the result
    @Test
    void testHasRepeat() throws GraphError {
        List<Integer> traversalList;
        List<Integer> traversalChecker = new ArrayList<>();
        Boolean foundRepeat = false;
        initialiseTest();
        traversalList = dft.traverse();
        for (Integer i : traversalList) {
            if (traversalChecker.contains(traversalList.get(i))) {
                foundRepeat = true;
            } traversalChecker.add(traversalList.get(i));
        } assertFalse(foundRepeat);
    }
}