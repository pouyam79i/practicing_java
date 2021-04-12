package myLinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> inputs = new ArrayList<String>();
        MyLinkedList intList = new MyLinkedList();
        Scanner sc = new Scanner(System.in);
        int size = 0;
        String input;

        do {
            input = sc.nextLine();
            inputs.add(input);
        } while (!input.equals("finish"));

        label:
        for(String inps : inputs){
            String[] inputArray = inps.split(" ");
            switch (inputArray[0]) {
                case "add":
                    intList.add(Integer.parseInt(inputArray[1]));
                    break;
                case "addFirst":
                    intList.addFirst(Integer.parseInt(inputArray[1]));
                    break;
                case "findMiddle":
                    intList.findMiddle();
                    break;
                case "removeMiddle":
                    intList.removeMiddle();
                    break;
                case "print":
                    intList.print();
                    break;
                case "contains":
                    intList.contains(Integer.parseInt(inputArray[1]));
                    break;
                case "removeIndex":
                    intList.removeIndex(Integer.parseInt(inputArray[1]));
                    break;
                case "finish":
                    break label;
            }
        }
    }
}
