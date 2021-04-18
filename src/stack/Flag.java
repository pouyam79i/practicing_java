/*
  Coded by Pouya Mohammadi
  CE @ AUT - Uni ID: 9829039
  This Class Is created to debug the code
 */

package stack;

public class Flag {

    private boolean debugMode = true;

    public Flag(String input){
        if(debugMode)
            System.out.println(input);
    }

    public Flag(int flagNumber){
        if(debugMode)
            System.out.println(" ### Flag ID: " + flagNumber);
    }

}
