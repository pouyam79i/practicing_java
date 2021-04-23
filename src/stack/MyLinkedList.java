/*
  Coded: Pouya Mohammadi
  CE @ AUT - Uni ID: 9829039
    This class countains the LinkedList class
 */


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

    /**
     * Set new data to an existing node
     * @param index of node
     * @param data will be set as new date of the mentioned node
     */
    public void set(int index, int data){
        if(head == null){
            new Flag("No Data");
            return;
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
            return;
        }
        currentNode.setData(data);
    }

    // Getters
    public int getSize() {
        return currentSize;
    }

}
