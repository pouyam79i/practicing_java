/*
Coded by Pouya Mohamadi
Main class is coded to run the app
 */
package Music;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MusicCollection pop = new MusicCollection("pop");
        MusicCollection jazz = new MusicCollection("jazz");
        MusicCollection rock = new MusicCollection("rock");
        MusicCollection country = new MusicCollection("country");
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        String input = "";
//        String type = "";
        int index = 0;
        int time = 0;

        System.out.println(menu.mainMenu);

        while (true){
            input = scanner.nextLine();
            input = input.toLowerCase(Locale.ROOT);
            if(input.equals("1")){

            }
            else if(input.equals("2")){

            }
            else if(input.equals("3")){

            }
            else if(input.equals("4")){

            }
            else if(input.equals("5")){
                break;
            }
            else {
                System.out.println("\n\n\n");
                System.out.println("Wrong input");
                System.out.println(menu.mainMenu);
            }
        }


    }
}

/*

// This is created by my Idea

    public static void main(String[] args) {
        MusicCollection musicCollection = new MusicCollection();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        String input = "";
        int index = -1;
        System.out.println(menu.mainMenu);

        label:
        while(true){
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println(menu.playMenu);
                    input = scanner.nextLine();
                    index = Integer.parseInt(input);
                    musicCollection.startPlaying(index);
                    break;
                case "2":
                    System.out.println(menu.addMenu);
                    input = scanner.nextLine();
                    musicCollection.addFile(input);
                    break;
                case "3":
                    System.out.println(menu.removeMenu);
                    input = scanner.nextLine();
                    index = Integer.parseInt(input);
                    musicCollection.removeFile(index);
                    break;
                case "4":
                    System.out.println(menu.listMenu);
                    input = scanner.nextLine();
                    input = input.toUpperCase();
                    if (input.equals("ALL"))
                        musicCollection.listAllFiles();
                    else {
                        index = Integer.parseInt(input);
                        musicCollection.listFile(index);
                    }
                    break;
                case "5":
                    break label;
                default:
                    System.out.println("\nWrong Input\n");
                    break;
            }
            System.out.println(menu.mainMenu);
        }
    }

    */
