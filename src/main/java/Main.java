import array_list.MyArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(0, 100);

        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));
    }

}