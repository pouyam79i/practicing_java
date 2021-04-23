/*
  Coded by Pouya Mohammadi
  CE @ AUT - Uni ID: 9829039
  This Class Is created to debug the code
 */


public class Flag {

    // debug mode
    private boolean debugMode = false;

    /**
     * @param input will be printed if debug mode is enabled
     */
    public Flag(String input){
        if(debugMode)
            System.out.println(input);
    }

    /**
     * @param flagNumber will be printed if debug mode is enabled
     */
    public Flag(int flagNumber){
        if(debugMode)
            System.out.println(" ### Flag ID: " + flagNumber);
    }

}
