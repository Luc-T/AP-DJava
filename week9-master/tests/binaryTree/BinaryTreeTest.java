package binaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest<T> {

    private BinaryTree bt = new BinaryTree();

    void initialiseTest() throws NullPointerException{
        bt.insert(100);
        bt.insert(30);
        bt.insert(50);
        bt.insert(200);
        bt.insert(10);
        bt.insert(3);
        bt.insert(22);
        bt.insert(120);
        bt.insert(130);
    }

    @Test
    void testContainsValue(){
       initialiseTest();

        assertTrue(bt.contains(100));
        assertTrue(bt.contains(30));
        assertTrue(bt.contains(50));
        assertTrue(bt.contains(200));
        assertTrue(bt.contains(10));
        assertTrue(bt.contains(3));
        assertTrue(bt.contains(22));
        assertTrue(bt.contains(120));
        assertTrue(bt.contains(130));
    }

    @Test
    void testDoesNotContain(){
        initialiseTest();
        assertFalse(bt.contains(-5));
        assertFalse(bt.contains(101));
    }

    @Test
    void testTraversal(){
        initialiseTest();
        List<Integer> traList = new ArrayList<>();
        traList.add(3);
        traList.add(10);
        traList.add(22);
        traList.add(30);
        traList.add(50);
        traList.add(100);
        traList.add(120);
        traList.add(130);
        traList.add(200);
        System.out.println(bt.traverse());
        assertEquals(traList, bt.traverse());
    }

}