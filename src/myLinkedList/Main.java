package myLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList intList = new MyLinkedList();
        intList.add(13);
        intList.add(6);
        intList.add(25);
        intList.print();
        System.out.println(intList.getSize());
        intList.removeMiddle();
        intList.print();
        intList.removeIndex(0);
        intList.print();
    }
}
