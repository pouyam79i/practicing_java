package myLinkedList;

class Node{

    private Node next;
    private Node previous;

    private int data;

    public Node(){
        next = null;
        previous = null;
    }
    public Node(Node previous){
        next = null;
        this.previous = previous;
    }
    public Node(Node next, Node previous){
        this.next = next;
        this.previous = previous;
    }



    public Node getNext() {
        return next;
    }
    public Node getPrevious() {
        return previous;
    }
    public int getData() {
        return data;
    }


    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public void setData(int data) {
        this.data = data;
    }

}

public class MyLinkedList {

    private Node head;
    private Node lastNode;
    private int size;

    public MyLinkedList(){
        head = null;
        lastNode = null;
        size = 0;
    }

    public void add(int number){
        Node newNode = new Node(lastNode);
        newNode.setData(number);
        if(head == null)
            head = newNode;
        else{
            newNode.getPrevious().setNext(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public void addFirst(int number){
        Node newNode = new Node(head, null);
        newNode.setData(number);
        head = newNode;
        size++;
    }

    public void findMiddle

}
