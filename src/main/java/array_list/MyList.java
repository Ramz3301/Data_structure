package array_list;

/**
 * Interface for ordered Collection. Allow duplicate elements and null.
 * Have access elements by index.
 * @param <T>
 */
public interface MyList<T> extends Iterable<T> {

    /**
     * Appends the specified element to the end of this list.
     * <br>
     * If this element added to full busy list, list grows.
     * @param t element to be appended to list
     * @return {@code true} if element added
     */
    boolean add(T t);

    /**
     *  Appends the specified element to the specified position of this list.
     * @param index
     * @param t
     * @return {@code true} if element added
     */
    boolean add(int index, T t);

    /**
     * Remove element in list by index.
     * @param index
     * @return Element which we removed
     * @throws IndexOutOfBoundsException - if index less than zero or bigger than size
     */
    T remove(int index);

    /**
     * Returns an element by index.
     * @param index
     * @return T - element
     * @throws IndexOutOfBoundsException if index < 0 or index more than size of list.
     */
    T get(int index);

    /**
     * With this method you can replace element by index.
     * @param index - number of index which we want to replace element
     * @param t - element which we add to list in this index
     */
    void set(int index, T t);

    /**
     * @return {@code true}  if list have no elements or
     *   {@code false} if list have 1 or more elements,
     *  including null.
     */
    int size();

    /**
     * @return {@code true}  if list have no elements or
     *   {@code false} if list have 1 or more elements,
     * including null.
     */
    boolean isEmpty();

    /**
     * Method for checking element in list implementation.
     * @param element
     * @return {@code true} if list contains it element
     * and {@code false} if not.
     */
    boolean contains(T element);
}
