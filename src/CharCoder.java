/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @pouya_moh
 */

import java.util.Scanner;

public class CharCoder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String codeFormatStr = scan.nextLine();
        String myText = scan.nextLine();

        int codeFormater = Integer.parseInt(codeFormatStr, 2);    // converting str to int assuming that we are reading binary value
        char[] charArray = myText.toCharArray();                       // spliting our text to char array

        char temp;
        String str;
        for(int i = 0; i < charArray.length; i++){
            temp =(char)(charArray[i] ^ codeFormater);                  // XOR opration on each char
            str = Integer.toString(temp, 2);
            if(str.length() < 8){                                       // making our string in 8-bit format
                int difference = 8 - str.length();
                for (int j = 0; j < difference; j++){
                    str = "0" + str;
                }
            }
            System.out.print(str);                                      // printing process
            if((i+1) != charArray.length)
                System.out.print(" ");
        }
    }

}
