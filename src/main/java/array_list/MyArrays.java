package array_list;

/**
 * Class contains method for quick sorting MyArrayList.
 * @see MyArrayList
 */
public class MyArrays {
    /**
     * Method for quick sorting MyArrayList.
     * @param array
     * @return MyArrayList<T>
     * @param <T>
     */
    public static  <T extends Comparable<T>> MyArrayList<T> quicksort(MyArrayList<T> array) {
        if (array.size() < 2) {
            return array;
        }

        MyArrayList<T> sorted;
        MyArrayList<T> lesser = new MyArrayList<>();
        MyArrayList<T> greater = new MyArrayList<>();
        T pivot = array.get(array.size() - 1); // получение последнего элемента

        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i).compareTo(pivot) < 0) {
                lesser.add(array.get(i));
            } else if (array.get(i).compareTo(pivot) > 0){
                greater.add(array.get(i));
            }
        }

        lesser = quicksort(lesser);
        greater = quicksort(greater);

        lesser.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            lesser.add(greater.get(i));
        }
        sorted = lesser;

        return sorted;
    }

}
