import array_list.MyArrayList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println(list.remove(0));

        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.delete(10);
    }

}