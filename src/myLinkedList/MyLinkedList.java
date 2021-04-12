package myLinkedList;

/**
 * Class of node
 */
class Node{

    // next node
    private Node next;
    // previous node
    private Node previous;
    // data of this node
    private int data;

    /**
     * set next and previous to null
     */
    public Node(){
        next = null;
        previous = null;
    }
    /**
     * next node will be set to null
     * @param previous will be set as previous node
     */
    public Node(Node previous){
        next = null;
        this.previous = previous;
    }
    /**
     * @param next will be set as next node
     * @param previous will be set as previous node
     */
    public Node(Node next, Node previous){
        this.next = next;
        this.previous = previous;
    }

    // Getters
    public Node getNext() {
        return next;
    }
    public Node getPrevious() {
        return previous;
    }
    public int getData() {
        return data;
    }

    // Setters
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

/**
 * class of linked list
 */
public class MyLinkedList {

    // head of list
    private Node head;
    // size of list
    private int size;

    /**
     * Constructor
     */
    public MyLinkedList(){
        head = null;
        size = 0;
    }

    /**
     * add to the end of list
     * @param number will be added
     */
    public void add(int number){
        Node newNode = new Node(null);
        newNode.setData(number);
        if(head == null)
            head = newNode;
        else{
            if(size == 1) {
                newNode.setPrevious(head);
                head.setNext(newNode);
            }
            Node temp = head;
            for (int i = 1; i < size; i++)
                temp = temp.getNext();
            newNode.setPrevious(temp);
            temp.setNext(newNode);
        }
        size++;
    }

    /**
     * adds to the head of list
     * @param number will be added to the head of list
     */
    public void addFirst(int number){
        Node newNode = new Node(head, null);
        newNode.setData(number);
        head = newNode;
        size++;
    }

    /**
     * Print the middle data
     * if it was empty, -1 will be printed
     */
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
    }

    /**
     * Remove the middle data
     */
    void removeMiddle(){
        int index = (size+1) / 2;
        index--;
        if(size == 0){
            System.out.println();
            return;
        }
        if(index == 0){
            head = head.getNext();
            if(head != null)
                head.setPrevious(null);
            size--;
            return;
        }
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                temp.getPrevious().setNext(temp.getNext());
                temp.getNext().setPrevious(temp.getPrevious());
                break;
            }
            if(temp == null)
                break;
            temp = temp.getNext();
        }
        if(size > 0)
            size--;
    }

    /**
     * will print all nodes' data
     */
    void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    /**
     * Search if it exists in the list
     * @param number will be searched
     */
    void contains(int number){
        boolean isFound = false;
        Node temp = head;
        int index = 0;
        if(head == null){
            System.out.println(-1);
            return;
        }
        while (temp != null){
            if (temp.getData() == number) {
                isFound = true;
                System.out.println(index);
                break;
            }
            temp = temp.getNext();
            index++;
        }
        if(!isFound)
            System.out.println(-1);
    }

    /**
     * Remove a node with specified index
     * @param index will be search and the according node of this index  will be removed
     */
    void removeIndex(int index){
        if(index == 0 && size > 0){
            if(head != null)
                head = head.getNext();
            if(head != null)
                head.setPrevious(null);
            if(size > 0)
                size--;
            return;
        }
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                temp.getPrevious().setNext(temp.getNext());
                temp.getNext().setPrevious(temp.getPrevious());
                size--;
                break;
            }
            if(temp == null)
                break;
            temp = temp.getNext();
        }
    }

    // Getters
    public int getSize() {
        return size;
    }

}

