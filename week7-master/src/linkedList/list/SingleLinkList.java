package linkedList.list;

import linkedList.node.SingleLinkNode;

/**
 * Define a singly linked list
 *
 * @param <T> the type of object being stored in the list
 *
 * @author Luc Taggart
 * @version November 2019
 */
public class SingleLinkList<T> extends BasicList<SingleLinkNode<T>,T> implements List<T>{

    /**
     * Method for adding a new node to the list
     *
     * @param index the index at which the new entry should be added.
     * @param value the value to be added.
     * @throws ListAccessError
     */

    @Override
    public void add(int index, T value) throws ListAccessError {

        if (index < 0 ) {
            throw new ListAccessError("Index out of bounds");
        } else if (index == 0){
            try {
                SingleLinkNode<T> firstNode = new SingleLinkNode<T>(value);
                firstNode.setNext(getNode(0));
                setRoot(firstNode);
            } catch (ListAccessError listAccessError) {
                throw new ListAccessError("Failed to get node");
            }
        } else {
            SingleLinkNode<T> newNode = new SingleLinkNode<T>(value, getRoot());
            try {
            getNode(index - 1).setNext(newNode);
            newNode.setNext(getNode(index+1));
            } catch (NullPointerException nullPE) {
                throw new ListAccessError("No node at index" + (index-1) + "");
            }
        }
    }

    /**
     * Removes the given node from the list by replacing
     * the pointer to it from the node prior to skip that node
     *
     * @param index the index of the entry to be removed.
     * @return returns vaule of node to be deleted
     * @throws ListAccessError
     */
    @Override
    public T remove(int index) throws ListAccessError {
        if (index == 0) {
            SingleLinkNode<T> delNode = getRoot();
            setRoot(getNode(1));
            return delNode.getValue();
        }
        else if (index < 0) {
            throw new ListAccessError("Index out of bounds");
        }
        else {
            SingleLinkNode<T> sendNode = getNode(index);
            getNode(index-1).setNext(getNode(index+1));
            return sendNode.getValue();
        }
    }

    /**
     * Calls the getNode function and returns the value
     *
     * @param index the index of the entry to be accessed.
     * @return returns the node value requested
     * @throws ListAccessError
     */
    @Override
    public T get(int index) throws ListAccessError {
        return getNode(index).getValue();
    }

    /**
     * Gets the node at that given index and returns it
     *
     * @param index location of requested node
     * @return returns the node requested
     * @throws ListAccessError
     */
    public SingleLinkNode<T> getNode (int index) throws ListAccessError {
            SingleLinkNode<T> currentNode = getRoot();
            for (int i = 1; i == index; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
    }
}
