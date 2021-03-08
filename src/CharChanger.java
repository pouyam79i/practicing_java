/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh
 */

class CoupleWordAnalysis{

    private String str1 = "";
    private String str2 = "";
    private int[] Length = {0, 0};
    private int[] sameCharsInEachWords = {0, 0};
    private int sameCharsIntotalNoRepeat = 0;
    private int diffranceInCharNumber = 0;

    public int totalDiffrance = 0;

    public CoupleWordAnalysis(String word1, String word2){
        str1 = word1;
        str2 = word2;
        Length[0] = str1.length();
        Length[1] = str2.length();
    }

    public void CharAnalysis(void){
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        for(int i = 0; i < charArray1.length; i++){
            char temp = charArray1[i];
            for(int j = 0; j < charArray1.length; j++){

            }
            for(int j = 0; j < charArray2; j++)
        }
     }


}

public class CharChanger {
    public static void main(String[] args) {

    }
}
