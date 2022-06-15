package array_list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private T[] objects;
    private static final int DEFAULT_CAPACITY = 10; // при создании без указания кол-ва элементов, будет 10 по умолчанию
    private int size; // поле счётчик

    public MyArrayList() {
        objects = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Negative number for MyArrayList capacity");
        }
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return objects[index];
    }

    @Override
    public void set(int index, T t) {
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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
    }

    @Override
    public String toString() {
        T[] temp = (T[]) new Object[size];
        System.arraycopy(objects, 0, temp, 0, size);
        return Arrays.toString(temp);
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(element)) {
                return true;
            }
        }
        return false;
    }


//    public boolean addAll(Collection<? extends T> collection) {
//        if (collection.size() == 0) {
//            return false;
//        }
//
//        Object[] a = collection.toArray();
//        int numNew = a.length;
//
//        Object[] objects = this.objects;
//
//        if (numNew > (objects.length - size)) {
//            objects = (T[]) new Object[size + numNew];
//        }
//        System.arraycopy(a, 0, objects, numNew, a.length);
//        size = size + numNew;
//        return true;
//    }
}
