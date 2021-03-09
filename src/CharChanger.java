/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Email: pouyamohammadyirbu@gmail.com

Question 7
 */


import java.util.ArrayList;

class CoupleWordAnalysis{

    private char[] str1;
    private char[] str2;
    private int[] Length = new int[2];
    private ArrayList<Character> sameChars = new ArrayList<Character>();

    public int numOfSameChars;                                 // number of sameChars, Repitition is not counted.
    public int[] repeatedChars = new int[2];                   // number of same chars in each string
    public int differenceInLen;                                // abstract value of Length difference

    public CoupleWordAnalysis(String input1, String input2){

        str1 = input1.toCharArray();
        str2 = input2.toCharArray();
        Length[0] = str1.length;
        Length[1] = str2.length;

        differenceInLen = Length[0] - Length[1];
        if(differenceInLen < 0){
            differenceInLen *= -1;
        }

        limitCharRepeat(str1, str2);
        repeatedChars[0] = checkNumOfRepeated(str1, 0);
        repeatedChars[1] = checkNumOfRepeated(str2, 1);
    }

    private void limitCharRepeat(char[] input1 , char[] input2){

        int len = 0;
        boolean isRepeated = false;

        for(int i = 0; i < Length[0]; i++){
            for (int j = 0; j < Length[1]; j++) {
                if(input1[i] == input2[j]){
                    for(int t = 0; t < len; t++){
                        if(sameChars.get(t) == input1[i]){
                            isRepeated = true;
                        }
                    }
                    if(!isRepeated){
                        sameChars.add(input1[i]);
                        len++;
                    }
                    isRepeated = false;
                }
            }
        }
        numOfSameChars = len;
    }

    private int checkNumOfRepeated(char[] input, int index){

        int repeat = 0;

        for(int i = 0; i < Length[index]; i++){
            for(int t = 0; t < numOfSameChars; t++){
                if(sameChars.get(t) == input[i]){
                    repeat++;
                }
            }
        }
        return repeat;
    }

}



public class CharChanger {
    public static void main(String[] args) {

    }
}
