/*
  Coded: Pouya Mohammadi
  CE @ AUT - Uni ID: 9829039
    Main class
    S3 - Question 3
 */

import java.util.Scanner;

public class Main {

    /**
     * Main method
     */
    public static void main(String[] args) {

        // Linked List
        MyLinkedList myLinkedList = new MyLinkedList();
        // Scanner to read input
        Scanner scanner = new Scanner(System.in);
        // Making an array of input data
        String[] inputnumbers = scanner.nextLine().split("\s");
        // Stack - the initail size is number of inputs + 1
        Stack stack = new Stack(inputnumbers.length + 1);

        // putting data in linked list
        for(String str : inputnumbers){
            myLinkedList.add(Integer.parseInt(str));
        }
        // pushing data of linked list into the stack
        for(int i = 0; i < myLinkedList.getSize(); i++){
            stack.push(myLinkedList.get(i));
        }
        // popping data from stack and putting it into linked list
        for(int i = 0; i < myLinkedList.getSize(); i++){
            myLinkedList.set(i, stack.pop());
        }
        // printing the result
        for(int i = 0; i < myLinkedList.getSize(); i++){
            System.out.print(myLinkedList.get(i) + " ");
        }
    }

}
