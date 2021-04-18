package oldFiles;

public class productCart {
    public static void main(String[] args) {
        int[] row = new int[10];
        int[] column = new int[10];

        for (int i = 0; i < 10; i++){
            row[i] = i + 1;
            column[i] = i + 1;
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(row[i] * column[j] + "  ");
                int temp = row[i] * column[j];
                if(temp < 10){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
