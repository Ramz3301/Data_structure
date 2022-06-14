package array_list;

public interface MyInterface<T> extends Iterable<T> {

    void add(T t);

    T delete(int index);

    T get(int index);

    void update(int index, T t);

    int size();
}
