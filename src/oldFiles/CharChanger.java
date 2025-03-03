package oldFiles;/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Email: pouyamohammadyirbu@gmail.com

Question 7
 */

import java.util.ArrayList;
import java.util.Scanner;

class CoupleWordAnalysis{

    private int numOfSameChars;
    private char[] str1;
    private char[] str2;
    private int[] repeatedChars = new int[2];
    private ArrayList<Character> sameChars = new ArrayList<Character>();
    private ArrayList<Character> totalCharStr1 = new ArrayList<Character>();

    public int totalChar;
    public int contrast;
    public int diffInPlace;
    public int diffInChar;                                     // number of sameChars, Repitition is not counted. for str1
    public int sameInPlace;                                    // check Number of index that are the same in char and place. for str1
    public int differenceInLen;                                // abstract value of Length difference
    public int[] diffInCharsNum = new int[2];                  // number of different chars in each string
    public int[] Length = new int[2];



    public CoupleWordAnalysis(String input1, String input2){

        str1 = input1.toCharArray();
        str2 = input2.toCharArray();
        Length[0] = str1.length;
        Length[1] = str2.length;
        sameInPlace = 0;

        differenceInLen = Length[0] - Length[1];
        if(differenceInLen < 0){
            differenceInLen *= -1;
        }

        limitCharRepeat(str1, str2);
        checkSameInPlace(str1, str2);
        repeatedChars[0] = checkNumOfRepeated(str1, 0);
        repeatedChars[1] = checkNumOfRepeated(str2, 1);

        diffInCharsNum[0] = Length[0] - repeatedChars[0];
        diffInCharsNum[1] = Length[1] - repeatedChars[1];

        diffInPlace = Length[0] - sameInPlace;
        checkTotalChar(str1);
        diffInChar = totalChar - numOfSameChars;

        System.out.println("Total Char NO rep: " + totalChar);
        System.out.println("dif In plac: " + diffInPlace);
        System.out.println("Diff in char" + diffInChar);
        System.out.println("same In palce" + sameInPlace);
        System.out.println("dif In len" + differenceInLen);
        System.out.println(" dif in num char: " + diffInCharsNum[0] + " - " + diffInCharsNum[1]);
        System.out.println("Len: " + Length[0] + " - " + Length[1]);

        contrast = totalChar - diffInChar;
        if(contrast < 0)
            contrast *= -1;

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

    private void checkSameInPlace(char[] input1, char[] input2){

        int leastIndex = 0;

        leastIndex = Math.min(input1.length, input2.length);

        for(int i = 0; i < leastIndex; i++){
            if(input1[i] == input2[i]){
                sameInPlace++;
            }
        }
    }

    private void checkTotalChar(char[] input){
        int len = 0;
        boolean isRep = false;
        for(char c:input){
            for(int i = 0; i < len; i++){
                if(totalCharStr1.get(i) == c){
                    isRep = true;
                }
            }
            if(!isRep){
                totalCharStr1.add(c);
                len++;
            }
            isRep = false;
        }
        totalChar = len;
    }

}



public class CharChanger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        if(str1.compareTo(str2) == 0){
            System.out.println("false");
            return;
        }

        CoupleWordAnalysis analyser = new CoupleWordAnalysis(str1, str2);
//
//        if(analyser.contrast == 1 &&){
//            System.out.println("true");
//            return;
//        }

        if(analyser.differenceInLen >= 2){
            if(analyser.contrast > 1) {
                System.out.println("false");
                return;
            }
        }
        if(analyser.differenceInLen == 0){
            if(analyser.sameInPlace >=2 && analyser.diffInChar > 1){
                System.out.println("false");
                return;
            }
            if(analyser.diffInChar == 1 && (analyser.sameInPlace == 0 && analyser.totalChar > 1)){
                System.out.println("false");
                return;
            }
            if(analyser.diffInChar == 0 & analyser.diffInPlace > 0){
                System.out.println("false");
                return;
            }
        }
        if(analyser.differenceInLen == 1){
            if(analyser.Length[0] < analyser.Length[1] && analyser.contrast > 1){
                if(analyser.diffInCharsNum[0]>0 || (!str2.contains(str1))){
                    System.out.println("false");
                    return;
                }
            }
            else if(analyser.Length[0] > analyser.Length[1] && analyser.contrast > 1){
                if(analyser.diffInCharsNum[1] > 0 || (!str1.contains(str2))){
                    System.out.println("false");
                    return;
                }
            }
        }

        System.out.println("true");

        /*
       حقیقتا از یه جایی به بعد متوجه این که زیاد نوشتم شدم ولی حوصله ساده کردنشو نداشتم:)
         */

    }

}
