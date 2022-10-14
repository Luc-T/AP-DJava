package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Perform a reference counting topological sort on a graph.
 *
 * @author Luc Taggart
 * @version January 2020
 */
public class ReferenceCountingSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T> {

    private HashMap<T, Integer> refCount = new HashMap<T, Integer>();
    private ArrayList<T> rcSort = new ArrayList<T>();

    /**
     * This method is called from outside classes for a
     * reference counting topological sort.
     *
     * @return the list of a full reference counting sort
     */
    @Override
    public List<T> getSort() throws GraphError {
        setUpRefCounts(); //calculate the initial reference counts
        doSort(); //sort the nodes
        return rcSort;
    }

    /**
     * Each node is set at refCount 0 but then for each
     * neighbour a node has its refCount is increased.
     *
     */
    private void setUpRefCounts() throws GraphError {
        //Loop through every node in the graph and add them to hashmap at ref count 0
        for (T node: getNodes()){
            refCount.put(node, 0);
        }
        //For each node, get neighbours, and each neighbour,
        //increment their ref count by 1 in hashmap
        for (T node: getNodes()) {
            for (T neighbour: getNeighbours(node)) {
                increaseRefCount(neighbour);
            }
        }
    }

    /**
     * The method adds the node to the sort then 'removes' it from
     * the graph.
     *
     * @param node the node to be visited and then removed from the graph
     */
    private void visitNode(T node) throws GraphError {
        rcSort.add(node);
        //for all neighbours, reduce reference count by 1
        for (T neighbour: getNeighbours(node)) {
            decreaseRefCount(neighbour);
        }
        //remove node from hashmap
        refCount.remove(node);
    }


    /**
     * Create a node and make it equal to the first node found with
     * refCount 0, then visit it.
     *
     */
    private void doSort() throws GraphError {
        T node;
        while ((node = nextNode()) != null) {
            visitNode(node);
        }
    }

    /**
     * Go through the hashmap until a node of refCount 0 is found.
     *
     * @return return the next node to be sorted
     */
    private T nextNode(){
        for (Entry<T, Integer> entry : refCount.entrySet()) {
            if(entry.getValue() == 0){
                return (T) entry.getKey();
            }
        }
        return null;
    }

    /**
     * Decrease the refCount of the node and save it
     *
     * @param neighbour the node to decrease the count of
     */
    private void decreaseRefCount(T neighbour) {
        Integer count = refCount.get(neighbour);
        if (count != null) {
            count--;
            refCount.put(neighbour, count);
        }
    }

    /**
     * Increase the refCount of the node and save it
     *
     * @param neighbour the node to increase the count of
     */
    private void increaseRefCount(T neighbour) {
        Integer count = refCount.get(neighbour);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        refCount.put(neighbour, count);
    }


}
