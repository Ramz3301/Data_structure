package array_list;

import java.util.Iterator;

/**
 * An iterator over MyArrayList
 *
 * @see java.util.Iterator
 * @see MyArrayList
 * @param <T>
 */

public class MyIterator<T> implements Iterator<T> {
    /**
     * Type of the array over which we are iterating
     */
    private T[] objects;
    /**
     * Variable which cah help us with find where now out Iterator.
     */
    private int index = 0;

    /**
     * Constructor with T parametrized array.
     * @param objects
     */
    public MyIterator(T[] objects) {
        this.objects = objects;
    }

    /**
     * Check next element.
     * @return {@code true} if list has next element
     * or {@code false} if list hasn't next element.
     */
    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    /**
     * Method for get next element.
     * @return
     */
    @Override
    public T next() {
        return objects[index++];
    }
}