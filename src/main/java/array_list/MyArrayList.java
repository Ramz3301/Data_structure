package array_list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Resizable-array which can contains Objects. Implements add, read, update, delete operations. Permits all elements,
 * including null.
 * <br>
 * Each MyArrayList has capacity.
 *
 * @author Ramzan Kurbanov
 * @see array_list.MyList
 * @see array_list.MyIterator
 * @param <T> the type of elements in this list
 */
public class MyArrayList<T> implements MyList<T> {

    /**
     * The array into which the elements of the MyArrayList are stored.
     */
    private T[] objects;
    /**
     * Default initial capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The number of MyArrayList elements
     */
    private int size;

    /**
     * Constructs an empty list with the initial capacity of ten
     */
    public MyArrayList() {
        objects = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Negative number for MyArrayList capacity");
        }
        objects = (T[]) new Object[capacity];
    }

    /**
     * Appends the specified element to the end of this list.
     * <br>
     * If this element added to full busy list, list grows.
     * @param t element to be appended to list
     * @return {@code true}
     */
    @Override
    public boolean add(T t) {
        if (size >= objects.length) {
            T[] tempArray = objects;
            objects = (T[]) new Object[objects.length * 3 / 2];
            System.arraycopy(tempArray, 0, objects, 0, tempArray.length);
        }

        objects[size++] = t;
        return true;
    }

    /**
     *  Appends the specified element to the specified position of this list.
     *  <br>
     *  If this element added to full busy list, list grows.
     * @param index
     * @param t
     * @return
     */
    @Override
    public boolean add(int index, T t) {
        if (size >= objects.length) {
            T[] tempArray = objects;
            objects = (T[]) new Object[objects.length * 3 / 2 + 1];
            System.arraycopy(tempArray, 0, objects, 0, tempArray.length);
        }

        T temp = objects[index];
        objects[index] = t;

        System.arraycopy(objects, index, objects, index + 1, size - index);

        objects[index + 1] = temp;
        size++;
        return true;
    }

    /**
     * Remove element in list by index.
     * @param index
     * @return Element which we removed
     * @throws IndexOutOfBoundsException - if index less than zero or bigger than size
     */
    @Override
    public T remove(int index) {

        if (index < 0) {
            throw new IndexOutOfBoundsException("Try to remove negative element of array");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("Index bigger than size of array");
        }

        T oldElement = objects[index];
        objects[index] = null;
        int numMoved = objects.length - index - 1;
        System.arraycopy(objects, index + 1, objects, index, numMoved);
        size--;
        return oldElement;
    }

    /**
     * Returns an element by index.
     *
     * @param index
     * @return T - element
     * @throws IndexOutOfBoundsException if index < 0 or index more than size of list.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return objects[index];
    }

    /**
     * With this method you can replace element by index.
     * @param index - number of index which we want to replace element
     * @param t - element which we add to list in this index
     */
    @Override
    public void set(int index, T t) {
        objects[index] = t;
    }

    /**
     * @return  number of the elements in MyArrayList.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method for add possibility iteration with for-each loop.
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(objects);
    }


    /**
     * @return {@code true}  if MyArrayList have no elements or
     *   {@code false} if MyArrayList have 1 or more elements,
     * including null.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Clear all list elements and replace them with null.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
    }

    /**
     * String representation for list.
     * @return {@code String}
     */
    @Override
    public String toString() {
        T[] temp = (T[]) new Object[size];
        System.arraycopy(objects, 0, temp, 0, size);
        return Arrays.toString(temp);
    }

    /**
     * Method for checking element in MyArrayList.
     * @param element
     * @return {@code true} if list contains it's element
     * and {@code false} if not.
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

}
