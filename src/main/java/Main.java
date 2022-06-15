import array_list.MyArrayList;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(230);


        System.out.println(list.contains(230));
    }

}
