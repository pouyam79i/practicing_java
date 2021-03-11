/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Email: pouyamohammadyirbu@gmail.com

Question 7
 */


import java.util.ArrayList;
import java.util.Scanner;

class wordAnalysis {

    private String myString;

    public int usedCharNum;                                                    //number of chars No Rep
    public int length;
    public char[] wordInCharArray;
    public ArrayList<Character> usedChar = new ArrayList<Character>();      //chars ussed. No Rep

    public wordAnalysis(String input){
        myString = input;
        wordInCharArray = myString.toCharArray();
        length = myString.length();

        checkAnalyseChar(wordInCharArray);
    }

    private void checkAnalyseChar(char[] input){
        int len = 0;
        for(char c:input){
            if(!usedChar.contains(c)){
                usedChar.add(c);
                len++;
            }
        }
        usedCharNum = len;
    }

}

class wordOprators{

    public ArrayList<Character> diffChars = new ArrayList<Character>();
    public int diffCharNum;

    public wordOprators(wordAnalysis input_1, wordAnalysis input_2){
        checkDiffChar(input_1, input_2);
    }

    private void checkDiffChar(wordAnalysis input_1, wordAnalysis input_2){

        diffCharNum = 0;
        boolean isRep = false;

        for(int i = 0; i < input_1.usedCharNum; i++){
            for(int j = 0; j < input_2.usedCharNum; j++){
                if(input_1.usedChar.get(i) == input_2.usedChar.get(j)){
                    isRep = true;
                }
            }
            if(!isRep){
                diffChars.add(input_1.usedChar.get(i));
                diffCharNum ++;
            }
            isRep = false;
        }

        for(int i = 0; i < input_2.usedCharNum; i++){
            for(int j = 0; j < input_1.usedCharNum; j++){
                if(input_2.usedChar.get(i) == input_1.usedChar.get(j)){
                    isRep = true;
                }
            }
            if(!isRep){
                diffChars.add(input_2.usedChar.get(i));
                diffCharNum ++;
            }
            isRep = false;
        }

    }



}

public class charCode2 {

    private static String removeUnusedChar(wordAnalysis input, char unusedChar, int len){
        char[] str = new char[len];
        int step = 0;
        for(int i = 0; i < input.length; i++){
            if(!(input.wordInCharArray[i] == unusedChar)){
                str[step] = input.wordInCharArray[i];
                step++;
            }
        }

        String output = new String(str);
        return output;
    }

    private static String removeOne(wordAnalysis input_1, wordAnalysis input_2){
        char[] newWord = new char[input_2.length];
        int index = 0;
        boolean isFound = false;
        for(int i = 0; i < input_1.length; i++){
            if(input_1.wordInCharArray[i] != input_2.wordInCharArray[index] && (!isFound)){
                isFound = true;
                continue;
            }
            newWord[index] = input_1.wordInCharArray[i];
            index++;
        }
        String output = new String(newWord);
        return output;
    }

    private static char checkDiffChar(wordAnalysis input_1, wordAnalysis input_2){
        char diffChar = '\0';
        boolean isUsed = false;
        for(int i = 0; i < input_1.usedCharNum; i++){
            for(int j = 0; j < input_2.usedCharNum; j++){
                if(input_1.usedChar.get(i) == input_2.usedChar.get(j)){
                    isUsed = true;
                    break;
                }
            }
            if(!isUsed){
                diffChar = input_1.usedChar.get(i);
                break;
            }
            isUsed = false;
        }
        return diffChar;
    }

    private static String replaceChar(wordAnalysis input_1,wordAnalysis input_2, char diifChar){
        char equalChar = '\0';
        char[] newWord = new char[input_2.length];
        int index = 0;
        for(char c:input_1.wordInCharArray){
            if(c == diifChar){
                equalChar = input_2.wordInCharArray[index];
                break;
            }
            index++;
        }
        for(int i = 0; i < input_1.length; i++){
            if(input_1.wordInCharArray[i] == diifChar){
                newWord[i] = equalChar;
            }else {
                newWord[i] = input_1.wordInCharArray[i];
            }
        }
        String output = new String(newWord);
        return output;
    }

    private static String replaceOneChar(wordAnalysis input_1, wordAnalysis input_2){
        char[] newWord;
        newWord = input_1.wordInCharArray;
        boolean isFound = false;
        int index = 0;
        for(int i = 0; i < input_1.length; i++){
                if(input_1.wordInCharArray[i] != input_2.wordInCharArray[i]){
                    newWord[i] = input_2.wordInCharArray[i];
                    break;
                }
            }

        String output = new String(newWord);
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word_1 = sc.nextLine();
        String word_2 = sc.nextLine();

        if(word_1.compareTo(word_2) == 0){
            System.out.println("False");
            return;
        }

        wordAnalysis analyser_1 = new wordAnalysis(word_1);
        wordAnalysis analyser_2 = new wordAnalysis(word_2);

        wordOprators oprator = new wordOprators(analyser_1, analyser_2);

        if(oprator.diffCharNum == 1 && analyser_1.length >= analyser_2.length){
            char diffChar = checkDiffChar(analyser_1, analyser_2);
            if(analyser_1.length > analyser_2.length){
                String newWord_1 = removeUnusedChar(analyser_1, diffChar, analyser_2.length);
                if(newWord_1.compareTo(word_2) == 0){
                    System.out.println("True");
                    return;
                }
            }
            else if(analyser_1.length == analyser_2.length){
                if(analyser_1.usedCharNum > analyser_2.usedCharNum){
                    String newWord_1 = replaceChar(analyser_1, analyser_2, diffChar);
                    if(newWord_1.compareTo(word_2) == 0){
                        System.out.println("True");
                        return;
                    }
                }
                else {
                    String newWord_1 = replaceOneChar(analyser_1, analyser_2);
                    if(newWord_1.compareTo(word_2) == 0){
                        System.out.println("True");
                        return;
                    }
                }
            }
        }
        if(oprator.diffCharNum == 2 && analyser_1.length == analyser_2.length){
            if(analyser_1.usedCharNum == analyser_2.usedCharNum){
                char diifChar = checkDiffChar(analyser_1, analyser_2);
                String newWord = replaceChar(analyser_1, analyser_2, diifChar);
                if(newWord.equals(word_2)){
                    System.out.println("True");
                    return;
                }
            }
        }
        if(analyser_1.length == analyser_2.length){
            String newWord = replaceOneChar(analyser_1, analyser_2);
            if(newWord.equals(word_2)){
                System.out.println("True");
                return;
            }
        }
        if((analyser_2.length - analyser_1.length) == 1){
            String newWord = removeOne(analyser_2, analyser_1);
            if(newWord.equals(word_1)){
                System.out.println("True");
                return;
            }
        }
        if((analyser_1.length - analyser_2.length) == 1){
            String newWord = removeOne(analyser_1, analyser_2);
            if(newWord.equals(word_2)){
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
}
