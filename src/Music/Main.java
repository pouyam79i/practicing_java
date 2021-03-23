/*
Coded by Pouya Mohamadi
Main class is coded to run the app
 */
package Music;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
}


//    public static void main(String[] args) {
//        MusicCollection musicCollection = new MusicCollection();
//        Scanner scanner = new Scanner(System.in);
//        Menu menu = new Menu();
//        String input = "";
//        int index = -1;
//        System.out.println(menu.mainMenu);
//
//        label:
//        while(true){
//            input = scanner.nextLine();
//            switch (input) {
//                case "1":
//                    System.out.println(menu.playMenu);
//                    input = scanner.nextLine();
//                    index = Integer.parseInt(input);
//                    musicCollection.startPlaying(index);
//                    break;
//                case "2":
//                    System.out.println(menu.addMenu);
//                    input = scanner.nextLine();
//                    musicCollection.addFile(input);
//                    break;
//                case "3":
//                    System.out.println(menu.removeMenu);
//                    input = scanner.nextLine();
//                    index = Integer.parseInt(input);
//                    musicCollection.removeFile(index);
//                    break;
//                case "4":
//                    System.out.println(menu.listMenu);
//                    input = scanner.nextLine();
//                    input = input.toUpperCase();
//                    if (input.equals("ALL"))
//                        musicCollection.listAllFiles();
//                    else {
//                        index = Integer.parseInt(input);
//                        musicCollection.listFile(index);
//                    }
//                    break;
//                case "5":
//                    break label;
//                default:
//                    System.out.println("\nWrong Input\n");
//                    break;
//            }
//            System.out.println(menu.mainMenu);
//        }
//    }