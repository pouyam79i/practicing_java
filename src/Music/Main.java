/*
Coded by Pouya Mohamadi
Main class is coded to run the app
 */
package Music;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static MusicCollection pop = new MusicCollection("pop");
    private static MusicCollection jazz = new MusicCollection("jazz");
    private static MusicCollection rock = new MusicCollection("rock");
    private static MusicCollection country = new MusicCollection("country");
    private static MusicCollection unclassified = new MusicCollection("unclassified");

    private static MusicCollection getCollection(String type){
        type = type.toLowerCase(Locale.ROOT);
        return switch (type) {
            case "pop" -> pop;
            case "jazz" -> jazz;
            case "rock" -> rock;
            case "country" -> country;
            default -> unclassified;
        };
    }

    private static void setCollection(String type, MusicCollection musicCollection){
        type = type.toLowerCase(Locale.ROOT);
        switch (type) {
            case "pop" -> pop = musicCollection;
            case "jazz" -> jazz = musicCollection;
            case "rock" -> rock = musicCollection;
            case "country" -> country = musicCollection;
            default -> unclassified = musicCollection;
        }
    }

    /**
     * Create a String of Inputs
     * @param input raw input
     * @return this String contains index as 0 Index and type of collection as 1
     */
    private static String[] inputAnalyzer(String input){
        String[] result;
        result = input.split("#");
        if (result.length == 1){
            return new String[]{result[0], "unclassified"};
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        String input = "";
        String type = "";
        int index = 0;
        int time = 0;

        label:
        while (true){
            System.out.println(menu.mainMenu);
            input = scanner.nextLine();
            input = input.toLowerCase(Locale.ROOT);
            switch (input) {
                case "1": {
                    System.out.println("\n\n" + menu.playMenu);
                    input = scanner.nextLine();
                    String[] arrayInput = inputAnalyzer(input);
                    index = Integer.parseInt(arrayInput[1]);
                    MusicCollection musicCollection = getCollection(arrayInput[0]);
                    musicCollection.startPlaying(index);
                    if (musicCollection.playingState()) {
                        System.out.println("\nIf you want to another thing you have to stop the player");
                        System.out.println("To stop the player Enter");
                        scanner.nextLine();
                        musicCollection.stopPlaying();
                    }
                    break;
                }
                case "2": {
                    System.out.println("\n\n" + menu.addMenu);
                    input = scanner.nextLine();
                    String[] arrayInput = inputAnalyzer(input);
                    MusicCollection musicCollection = getCollection(arrayInput[0]);
                    if (arrayInput.length == 2)
                        musicCollection.addFile(arrayInput[1]);
                    else if (arrayInput.length == 3) {
                        if (arrayInput[2].startsWith("time")) {
                            String[] tempArr = arrayInput[2].split("-");
                            time = Integer.parseInt(tempArr[1]);
                            musicCollection.addFile(arrayInput[1], time);

                        } else
                            musicCollection.addFile(arrayInput[1], arrayInput[2]);
                    } else if (arrayInput.length == 4) {
                        musicCollection.addFile(arrayInput[1], arrayInput[2], Integer.parseInt(arrayInput[3]));
                    } else {
                        System.out.println("\n\nWrong Input\n\n");
                        continue;
                    }
                    setCollection(arrayInput[0], musicCollection);
                    break;
                }
                case "3": {
                    System.out.println("\n\n" + menu.favoriteMenu);
                    input = scanner.nextLine();
                    String[] arrayInput = inputAnalyzer(input);
                    index = Integer.parseInt(arrayInput[1]);
                    MusicCollection musicCollection = getCollection(arrayInput[0]);
                    musicCollection.setFavorite(index);
                    setCollection(arrayInput[0], musicCollection);
                    break;
                }
                case "4": {
                    System.out.println("\n\n" + menu.removeFavoriteMenu);
                    input = scanner.nextLine();
                    String[] arrayInput = inputAnalyzer(input);
                    index = Integer.parseInt(arrayInput[1]);
                    MusicCollection musicCollection = getCollection(arrayInput[0]);
                    musicCollection.removeFavorite(index);
                    setCollection(arrayInput[0], musicCollection);
                    break;
                }
                case "5": {
                    System.out.println("\n\n" + menu.removeMenu);
                    input = scanner.nextLine();
                    String[] arrayInput = inputAnalyzer(input);
                    index = Integer.parseInt(arrayInput[1]);
                    MusicCollection musicCollection = getCollection(arrayInput[0]);
                    musicCollection.removeFile(index);
                    setCollection(arrayInput[0], musicCollection);
                    break;
                }
                case "6": {
                    System.out.println("\n\n" + menu.listMenu);
                    input = scanner.nextLine();
                    String[] arrayInput = inputAnalyzer(input);
                    MusicCollection musicCollection = getCollection(arrayInput[0]);
                    if (arrayInput[1].toLowerCase(Locale.ROOT).equals("all"))
                        musicCollection.listAllFiles();
                    else if (arrayInput[1].toLowerCase(Locale.ROOT).equals("fav"))
                        musicCollection.listFavorite();
                    else
                        musicCollection.listFile(Integer.parseInt(arrayInput[1]));
                    break;
                }
                case "7": {
                    System.out.println("\n\n" + menu.searchMenu);
                    input = scanner.nextLine();
                    String[] arrayInput = inputAnalyzer(input);
                    MusicCollection musicCollection = getCollection(arrayInput[0]);
                    if (arrayInput.length == 2) {
                        String[] operation = arrayInput[1].split("-");
                        operation[0] = operation[0].toLowerCase(Locale.ROOT);
                        switch (operation[0]) {
                            case "file" -> musicCollection.searchFile(operation[1]);
                            case "art" -> musicCollection.searchArtist(operation[1]);
                            case "time" -> musicCollection.searchReleaseDate(Integer.parseInt(operation[1]));
                            default -> System.out.println("\n\nWrong Input\n\n");
                        }
                    } else if (arrayInput.length == 3)
                        musicCollection.searchReleaseDate(Integer.parseInt(arrayInput[1]), Integer.parseInt(arrayInput[2]));
                    else
                        System.out.println("Wrong Input");
                    break;
                }
                case "8":
                    break label;
                default:
                    System.out.println("\n\n\n");
                    System.out.println("Wrong input");
                    break;
            }
        }


    }
}

