/*
  Coded: Pouya Mohammadi
  CE @ AUT - Uni ID: 9829039
    This class countains the linked list array
 */

package stack;

/**
 * Class of Node
 */
class Node{

    /**
     * Node's Data
     */
    private int data;
    /**
     * Next Node
     */
    private Node next;
    /**
     * Previous Node
     */
    private Node previous;

    /**
     * Initialize a Node
     * @param data will be saved
     */
    public Node(int data){
        this.data = data;
        previous = null;
        next = null;
    }

    // Setters
    public void setData(int data) {
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    // Getters
    public int getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public Node getPrevious() {
        return previous;
    }

}

public class MyLinkedList {

    /**
     * head of list
     */
    private Node head;
    /**
     * Size of list
     */
    private int currentSize;

    /**
     * Initialize a linked list of 'MyLinkedList' class
     */
    public MyLinkedList(){
        head = null;
        currentSize = 0;
    }

    /**
     * Adds a new Node
     * @param data will be saved as the Node data
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            currentSize++;
            return;
        }
        Node currentNode = head;
        while (currentNode.getNext() != null)
            currentNode = currentNode.getNext();
        currentNode.setNext(newNode);
        newNode.setPrevious(currentNode);
        currentSize++;
    }

    /**
     * Returns Data of a Node
     * @param index of a Node
     * @return  Data of Node,
     */
    public int get(int index){
        if(head == null){
            new Flag("No Data");
            return 0;
        }

        int currentIndex = 0;
        Node currentNode = head;

        while (currentIndex != index){
            if(currentNode.getNext() == null)
                break;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        if(currentIndex != index){
            new Flag("No Data. index != currentIndex");
            return 0;
        }
        return currentNode.getData();
    }

    /**
     * Removes a Node
     * @param index of Node
     */
    private void remove(int index){

        if(index < 0)
            return;

        if(head == null){
            new Flag("Linked list is empty");
            return;
        }

        int currentIndex = 0;
        Node currentNode = head;

        while(currentIndex != index){
            if(currentNode.getNext() == null)
                break;
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        if(index != currentIndex){
            new Flag("Index != current Node. cannot remove");
            return;
        }

        if(currentNode.getPrevious() != null) {
            currentNode.getPrevious().setNext(currentNode.getNext());
            if (currentNode.getNext() != null){
                currentNode.getNext().setPrevious(currentNode.getPrevious());
            }
            currentNode = null;
            currentSize--;
        }
        else{
            if(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
                currentNode.setPrevious(null);
                head = currentNode;
            }
            else
                head = null;
            currentSize--;
        }
    }

    // Getters
    public int getCurrentSize() {
        return currentSize;
    }

}
