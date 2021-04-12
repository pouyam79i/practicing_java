/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
This is my onw debugger class, which helps me debug the code
 */

public class Flag {

    //Debugging Mode, if true, it prints the Flag() inputs
    private boolean debugMode = true;

    /**
     * Debugging Flag
     * @param data is the data of debug
     * @param address is the address, like which line of the code or method name
     */
    public Flag(String data, String address){
        if(debugMode)
            System.out.println(data + "  ###at: " + address);
    }

    /**
     * Debugging Flag
     * @param data is the debugging data
     * @param flagNumber is the number of flag
     */
    public Flag(String data, int flagNumber){
        if(debugMode)
            System.out.println("Flag: " + flagNumber + "data:  " + data);
    }

    /**
     * Debugging Flag
     * @param flagNumber will be printed
     */
    public Flag(int flagNumber){
        if(debugMode)
            System.out.println("Flag: " + flagNumber);
    }

    /**
     * Debugging Flag
     * @param data of debugging will be printed
     */
    public Flag(String data){
        if(debugMode)
            System.out.println("Flag Data: " + data);
    }

}
