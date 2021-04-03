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
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    public void add(int number){
        Node newNode = new Node(null);
        newNode.setData(number);
        if(head == null)
            head = newNode;
        else{
            Node temp = head;
            for (int i = 1; i < size; i++)
                temp = temp.getNext();
            temp.setNext(newNode);
        }
        size++;
    }

    public void addFirst(int number){
        Node newNode = new Node(head, null);
        newNode.setData(number);
        head = newNode;
        size++;
    }

    public void findMiddle(){
        boolean isFound = false;
        int index = (size+1) / 2;
        index--;
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                System.out.println(temp.getData());
                isFound = true;
                break;
            }
            temp = temp.getNext();
        }
        if(!isFound) {
            System.out.println(-1);
        }
    }

    void removeMiddle(){
        int index = (size+1) / 2;
        index--;
        if(index == 0){
            head = head.getNext();
            size--;
            return;
        }
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                temp.getPrevious().setNext(temp.getNext());
                break;
            }
            temp = temp.getNext();
        }
    }


    void print(){
        Node temp = head;
        if(head == null){
            System.out.println();
            return;
        }
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    void contains(int number){
        Node temp = head;
        int index = 0;
        if(head == null){
            System.out.println(-1);
            return;
        }
        while (temp != null){
            if (temp.getData() == number) {
                System.out.println(index);
                break;
            }
            temp = temp.getNext();
        }
    }

    void removeIndex(int index){
        if(index == 0){
            head = head.getNext();
            if(size > 0)
                size--;
            return;
        }
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                temp.getPrevious().setNext(temp.getNext());
                break;
            }
        }
    }

}
