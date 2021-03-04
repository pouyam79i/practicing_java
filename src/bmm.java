import java.util.*;

//
//class Dividers{
//    public int[] dividers;
//    private int input;
//
//    public Dividers(int classInput){
//        input = classInput;
//        if(input < 1){
//            System.out.println("Wrong Input");
//        }else{
//            dividers = new int[(input / 2) + 1];
//        }
//    }
//
//    private void analyser(){
//        if(0 < input && input <= 3){
//            dividers[0] = 0;
//        }
//        else if(input > 3){
//            int index = 0;
//            for (int i = 2; i < ((input/2) + 1); i++){
//                if(input % i == 0){
//
//                }
//            }
//        }
//
//    }
//
//}
//


public class bmm {

    public static void main(String[] args) {
        int input1, input2, least;

        Scanner scan = new Scanner(System.in);
        input1 = scan.nextInt();
        input2 = scan.nextInt();

        if(input1 < 1 || input2 < 1){
            System.out.println("Wrong input");
            return;
        }
        else if(input1 == 1 || input2 == 1){
            System.out.println("They are not prime compaired to each other");
            return;
        }

        if(input1 < input2){
            least = input1;
        }
        else{
            least = input2;
        }

        for(int i = 2; i<= least; i++){
            if(input1 % i == 0){
                if(input2 % i ==0){
                    System.out.println("They are not prime compaired to each other");
                    return;
                }
            }
        }

        System.out.println("They ARRRRE prime compaired to each other :)))");
    }
}
