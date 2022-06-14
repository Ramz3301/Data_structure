package array_list;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private T[] objects;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList() {
        objects = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        objects = (T[]) new Object[capacity];
    }

    @Override
    public boolean add(T t) {
        if (size >= objects.length) {
            T[] tempArray = objects;
            objects = (T[]) new Object[objects.length * 3 / 2 + 1];
            System.arraycopy(tempArray, 0, objects, 0, tempArray.length);
        }

        objects[size++] = t;
        return true;
    }

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

    @Override
    public T remove(int index) {
        T oldElement = objects[index]; // чтобы вернуть при удалении
        objects[index] = null;
        int numMoved = objects.length - index - 1;
        System.arraycopy(objects, index + 1, objects, index, numMoved);
        size--;
        return oldElement;
    }

    @Override
    public T get(int index) {
        return objects[index];
    }

    @Override
    public void update(int index, T t) {
        objects[index] = t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(objects);
    }

}
