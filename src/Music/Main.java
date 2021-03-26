/*
Coded by Pouya Mohamadi
Main class is coded to run the app
 */
package Music;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private MusicCollection pop = new MusicCollection("pop");
    private MusicCollection jazz = new MusicCollection("jazz");
    private MusicCollection rock = new MusicCollection("rock");
    private MusicCollection country = new MusicCollection("country");
    private MusicCollection unclassified = new MusicCollection("unclassified");

    private MusicCollection getCollection(String type){
        type = type.toLowerCase(Locale.ROOT);
        return switch (type) {
            case "pop" -> pop;
            case "jazz" -> jazz;
            case "rock" -> rock;
            case "country" -> country;
            default -> unclassified;
        };
    }

    private void setCollection(String type, MusicCollection musicCollection){
        type = type.toLowerCase(Locale.ROOT);
        switch (type) {
            case "pop" -> pop = musicCollection;
            case "jazz" -> jazz = musicCollection;
            case "rock" -> rock = musicCollection;
            case "country" -> country = musicCollection;
            default -> unclassified = musicCollection;
        }
    }

    public static void main(String[] args) {


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
