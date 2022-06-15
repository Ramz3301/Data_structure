package array_list;

import java.util.Iterator;

/**
 *
 *
 * @see java.util.Iterator
 * @param <T>
 */

public class MyIterator<T> implements Iterator<T> {
    /**
     *
     */
    private T[] objects;
    /**
     *
     */
    private int index = 0;

    /**
     *
     * @param objects
     */
    public MyIterator(T[] objects) {
        this.objects = objects;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    /**
     *
     * @return
     */
    @Override
    public T next() {
        return objects[index++];
    }
}