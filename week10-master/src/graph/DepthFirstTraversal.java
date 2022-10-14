package graph;

import java.util.*;
/**
 * Allows a depth first traversal of a tree made from the AdjacencyGraph class
 *
 * @author Luc Taggart
 * @version January 2020
 */
public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T> {

    private List<T> traversal = new ArrayList<T>(); // the traversal

    /**
     * Perform a depth first traversal of the graph and return a list of nodes
     * in the order in which they are visited.
     * @return a depth first traversal of the graph
     */
    @Override
    public List<T> traverse() throws GraphError {
        T node = getUnvisitedNode(); // get an unvisited node
        while (node!= null) { //while there is at least one unvisited node
            visitNode(node);//visit it
            node = getUnvisitedNode();
        }
        for (T t : traversal) {
            System.out.println(t.toString());
        }
        return traversal;
    }

    /**
     * Get the next node to visit, as well as counting
     * nodes that are scheduled to be visited (i.e. in the to do list) as visited.
     * @return a node that has not yet been visited, and that is not yet scheduled to be visited, or return null if no such node exists
     */
    private T getUnvisitedNode() {
        for (T node: getNodes()) { // check all the nodes
            if (!visited(node)) { // if this node has not been "visited"
                return node; // then this is an unvisited node
            }
        }
        // checked all nodes, and there are no unvisited nodes
        return null; // so return null
    }


    /**
     * Check if a node has been visited, or needs to be visited.
     * I.e. check if the node is
     * <ul>
     *   <li> in the traversal and thus, has been visited
     *   <li> or in the to do list thus, scheduled to be visited
     * </ul>
     * @return this node has been visited, or is scheduled to be visited
     */
    private boolean visited(T node) {
        // the node has been visited and is in the traversal
        return traversal.contains(node);
    }

    /**
     * Visit a node by adding it to the traversal, and then recursively visiting all its neighbours.
     * @param node the node to be visited
     * @throws GraphError if the node does not exist in this graph
     */
    private void visitNode(T node) throws GraphError {
        if (visited(node))  // If the node is already in the list ...
            return; // ... there is no need to visit it again.
        traversal.add(node); // add the node to the list
        // Continue recursively for all the node's neighbours...
        for (T neighbour: getNeighbours(node)) {
            visitNode(neighbour);
        }


    }
}
