package array_list;

public interface MyList<T> extends Iterable<T> {

    boolean add(T t);

    boolean add(int index, T t);

    T remove(int index);

    T get(int index);

    void set(int index, T t);

    int size();

    boolean isEmpty();

    boolean contains(T element);
}
