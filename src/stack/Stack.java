/*
  Coded by Pouya Mohammadi
  CE @ AUT - Uni ID: 9829039
  This Class is Stack class
  question 3
 */

public class Stack {

    /**
     * Last Node
     */
    private Node lastIn;
    /**
     * Stack size
     */
    private int stackSize;
    /**
     * Current size of stack
     */
    private int currentSize;

    /**
     * Stack constructor
     * If there is no initial value for stackSize, it will be set as 0
     * It means no limit
     */
    public Stack(){
        new Stack(0);
    }

    /**
     * Stack constructor
     * @param stackSize is the size of stack, if stackSize <= 0 there will be no limit for the size
     */
    public Stack(int stackSize){
        lastIn = null;
        currentSize = 0;
        if(stackSize > 0)
            this.stackSize = stackSize;
        else
            this.stackSize = 0;
    }

    /**
     * Push a data to the stack
     * @param data will be add, if there is enough space
     */
    public void push(int data){
        if(currentSize < stackSize || stackSize <= 0){
            Node newNode = new Node(data);
            newNode.setPrevious(lastIn);
            lastIn = newNode;
            currentSize++;
        }
        else{
            System.out.println("Stack Overflow !");
        }
    }

    /**
     * Pop a node and reads the data, then delete it
     * @return the data of 'lastIn'
     */
    public int pop(){
        if(lastIn != null){
            int data = lastIn.getData();
            if(lastIn.getPrevious() != null)
                lastIn = lastIn.getPrevious();
            else
                lastIn = null;
            currentSize--;
            return data;
        }
        else {
            System.out.println("Stack Underflow !");
            return 0;
        }
    }

    /**
     * Reads the data of last node
     * @return the data of 'lastIn' node
     */
    public int peek(){
        if(lastIn != null)
            return lastIn.getData();
        else{
            System.out.println("No data");
            return 0;
        }
    }

    /**
     * Checks if stack is full
     * @return true if stack is full
     */
    public boolean isFull(){
        if(stackSize <= 0)      // This means the stack has no limit
            return false;
        if(currentSize == stackSize)
            return true;
        else
            return false;
    }

    /**
     * Checks if stack is empty
     * @return true is stack is empty
     */
    public boolean isEmpty(){
        if(currentSize == 0)
            return true;
        else
            return false;
    }

    /**
     * @return the current size of stack
     */
    public int getSize(){
        return currentSize;
    }

}

