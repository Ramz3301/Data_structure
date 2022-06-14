package array_list;

import java.util.Iterator;

public class MyArrayList<T> implements MyInterface<T> {

    private T[] objects;

    private int index;

    public MyArrayList() {
        objects = (T[]) new Object[0];
    }

    public MyArrayList(int size) {
        objects = (T[]) new Object[size];
    }

    @Override
    public boolean add(T t) {
        try {
            T[] tempArray = objects;
            objects = (T[]) new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, objects, 0, tempArray.length);
            objects[objects.length - 1] = t;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public T delete(int index) {
        T oldElement = objects[index];
        T[] tempArray = objects;
        objects = (T[]) new Object[objects.length - 1];
        System.arraycopy(tempArray, 0, objects, 0, index);
        int amountElementsAfterIndex = tempArray.length - 1 - index;
        System.arraycopy(tempArray, index, objects, index, amountElementsAfterIndex);
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
        return objects.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(objects);
    }

}
