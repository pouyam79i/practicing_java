/*
  Coded: Pouya Mohammadi
  CE @ AUT - Uni ID: 9829039
    This class countains the Node
 */


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

