package linkedList.list;
import linkedList.node.SingleLinkNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Some simple tests too check the Single linked list functions
 *
 * @author Luc Taggart
 * @version November 2019
 */
class SingleLinkListTest<T extends Comparable<? super T>>{

    @Test
    void testNewLinkedList() {
        SingleLinkList daList = new SingleLinkList();
        assertTrue(daList.isEmpty());

        SingleLinkNode<Integer> firstNode = new SingleLinkNode<>(10);
        daList.setRoot(firstNode);
        assertFalse(daList.isEmpty());
    }

    @Test
    void testAddToList() {
        SingleLinkList aList = new SingleLinkList();
        try {
            aList.add(0, 5);
            aList.add(1, 55);
            aList.add(2, 66);
            aList.add(5, 8);
        } catch (ListAccessError listAccessError) {
            fail("List could not add nodes");
        }
    }

}