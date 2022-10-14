package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A full implementation of sorted binary trees.
 *
 *
 * @param <T> the type of value stored in the tree.
 * @author Luc Taggart.
 * @version January 2020.
 */
public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {

    /**
     * The root node of this tree.
     */
    private TreeNode<T> root;

    /**
     * Construct an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a singleton tree.
     * A singleton tree contains a value in the root, but the left and right subtrees are
     * empty.
     *
     * @param value the value to be stored in the tree.
     */
    public BinaryTree(T value) {
        root = new TreeNode<>(value);
    }

    /**
     * Construct a tree with a root value, and left and right subtrees.
     *
     * @param value the value to be stored in the root of the tree.
     * @param left  the tree's left subtree.
     * @param right the tree's right subtree.
     */
    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        root = new TreeNode<>(value, left, right);
    }

    /**
     * Check if the tree is empty.
     *
     * @return true iff the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     *
     * @param value the value to be inserted into the tree.
     */
    public void insert(T value) {
        if (isEmpty()) {
            root = new TreeNode(value);
        } else if (value.compareTo(getValue()) < 0) {
            getLeft().insert(value);
        } else {
            getRight().insert(value);
        }
    }

    /**
     * Get the value stored at the root of the tree.
     *
     * @return the value stored at the root of the tree.
     */
    public T getValue() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("Root is null!");
        }
        return root.getValue();
    }

    /**
     * Change the value stored at the root of the tree.
     *
     * @param value the new value to be stored at the root of the tree.
     */
    public void setValue(T value) {
        root.setValue(value);
    }

    /**
     * Get the left subtree of this tree.
     *
     * @return This tree's left subtree.
     */
    public BTree<T> getLeft() {
        return root.getLeft();
    }

    /**
     * Change the left subtree of this tree.
     *
     * @param tree the new left subtree.
     */
    public void setLeft(BTree<T> tree) throws NullPointerException {
        if (tree.getValue().compareTo(getValue()) > 0){
            throw new NullPointerException("left items must be less than the root");
        }
        root.setLeft(tree);
    }

    /**
     * Get the right subtree of this tree.
     *
     * @return this tree's right subtree.
     */
    public BTree<T> getRight() {
        return root.getRight();
    }

    /**
     * Change the right subtree of this tree.
     *
     * @param tree the new right subtree.
     */
    public void setRight(BTree<T> tree) {
        if (tree.getValue().compareTo(getValue()) < 0){
            throw new NullPointerException("left items must be greater than the root");
        }
        root.setRight(tree);
    }

    /**
     * Check if the tree contains a given value.
     * Works by searching recursively a side of the tree.
     * If the parent node is not the item it is looking for,
     * it compares the side of the desired value to the node.
     * If it is smaller, the method goes down the left, otherwise it goes to the right.
     *
     * @param value the value to be checked.
     * @return true if the value is in the tree.
     */
    public boolean contains(T value) {
        if (isEmpty()) {
            return false; //if the root is empty, then there are no more nodes to search
        } else if (getValue().compareTo(value) == 0) {
            return true;//the node has been found
        } else if (getValue().compareTo(value) > 0) {
            return getLeft().contains(value);
            //the root node is greater than what we seek,
            //so search the left side
        }else if (getValue().compareTo(value) < 0){
            return getRight().contains(value);
            //the root node is less than what we seek,
            //so search the right t side
        }
        return false; //the node is not in the tree
    }

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     *
     * @return a list of all the values in the tree.
     */
    public List<T> traverse() {
        List<T> traversalList = new ArrayList<T>();
        inOrder(traversalList);
        return traversalList;
    }

    /**
     * Recursively calls itself to find the leftmost mode and works its
     * way through the tree as an in order traversal.
     *
     * @param list the list of each node traversed in the inOrder method
     * @throws NullPointerException if a node is non-existent it throws this exception
     */
    public void inOrder(List<T> list) throws NullPointerException {
        if (isEmpty()) return;
        ((BinaryTree<T>) getLeft()).inOrder(list);
        list.add(getValue());
        ((BinaryTree<T>) getRight()).inOrder(list);
    }
}

