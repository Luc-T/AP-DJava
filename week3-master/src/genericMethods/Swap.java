package genericMethods;

/**
 * This class defines a static method that will swap
 * two items within an array which is given
 *
 * @author Luc Taggart
 * @version October 2019
 */
public class Swap {

/**
 * Swap two objects
 * @param <T> the type of the two objects being swapped
 * @param array the array the two objects are in
 * @param first one of the two objects being swapped
 * @param second the second object being swapped
 * @return returns the array once the objects are in their new positions
 * */
    public static <T> T[] swap(T[] array, int first, int second) throws IndexOutOfBoundsException{
        if (first > array.length || second > array.length) {
            throw new IndexOutOfBoundsException();
        }
        else if (first < 0 || second < 0) {
            throw new IndexOutOfBoundsException();
        }
        else {
            T temp;
            temp = array[first];
            array[first] = array[second];
            array[second] = temp;
            return array;
        }
    }
}