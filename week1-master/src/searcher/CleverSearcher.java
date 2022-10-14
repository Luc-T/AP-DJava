package searcher;

import java.util.Arrays;

/**
 * A class that uses Searchers int array and index.
 *
 * Searches for the Kth largest int in the array
 * Uses a small array, swapping out items that are too small
 * until it has the K largest items from main array
 *
 * @author Luc Taggart
 * @version October 2019
 *
 */

public class CleverSearcher extends Searcher {

    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    /**
     * We are finding the Kth largest element.
     *
     * <ul>
     *     <li> Sort the array</li>
     *     <li> Take the first k items from array, this is smallArray</li>
     *     <li> Go through array, replacing items larger than the smallest item in smallArray</li>
     *     <li> When complete: smallArray is the k largest items in array</li>
     *     <li> Return smallest item from smallArray</li>
     * </ul>
     *
     * @throws IndexingError makes sure k is not larger/smaller than the array to search
     * @return kth largest element of smallArray
    */
    @Override
    public int findElement() throws IndexingError
    {
        //Acquire given array and which biggest number wanted
        int[] array = getArray();
        int k = getIndex();
        //Verifies k is a positive number and isn't larger than array size
        if (k <= 0 || k > array.length) {
            throw new IndexingError();
        }
        //make smallArray, size k
        int[] smallArray = new int[k];
        int index = 0;
        for (; index < k; index++) {
            smallArray[index] = array[index];
        }
        Arrays.sort(smallArray);
        //Until every element has been checked by smallArray
        //Swap items in smallArray until five largest items have been found
        for(; index < array.length; index++) {
            if (array[index] > smallArray[0]){
                smallArray[0] = array[index];
                int temp;
                for(int i = 0; i < smallArray.length -1; i++) {
                    //Once a new contending int has been found, sort the smallArray
                    if (smallArray[i] > smallArray[i+1]){
                        temp = smallArray[i+1];
                        smallArray[i+1] = smallArray[i];
                        smallArray[i] = temp;
                    }
                    else{
                        //When new int place is confirmed, no need to continue sorting smallArray
                        break;
                    }
                }
            }
        }
        return smallArray[0];
    }

}
