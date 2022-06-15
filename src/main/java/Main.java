import array_list.MyArrayList;
import array_list.MyArrays;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0);
        list.add(30);
        list.add(20);
        list.add(10);

        System.out.println(MyArrays.quicksort(list));

        ArrayList<Integer> list1 = new ArrayList();
    }

}
