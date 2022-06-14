package array_list;

import java.util.Iterator;

public class MyArrayList<T> implements MyInterface<T> {

    private T[] objects;
    private int size;
    private int index;

    public MyArrayList() {
        objects = (T[]) new Object();
    }

    @Override
    public void add(T t) {


    }

    @Override
    public T delete(int index) {
        return null;
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
        return objects.length; //todo
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(objects);
    }

}
