package Music;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A class to hold details of audio files.
 * Edited by Pouya Mohammadi - CE@AUT - Uni ID:9829039 
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the music data. like filename, artist name
    private ArrayList<Music> files;
    // A player for the music files.
    private MusicPlayer player;
    // Contains number of files.
    private int numberOfFiles;
    // Type of collection
    private String type;

    /**
     * Create a Music.MusicCollection
     */
    public MusicCollection() {
        files = new ArrayList<Music>();
        player = new MusicPlayer();
        type = "Unclassified";
        numberOfFiles = 0;
    }
    /**
     * Create a Music.MusicCollection
     * @param Type is the type of collection
     */
    public MusicCollection(String Type) {
        files = new ArrayList<Music>();
        player = new MusicPlayer();
        type = Type.toLowerCase(Locale.ROOT);
        numberOfFiles = 0;
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename) {
        Music temp = new Music();
        temp.setMusicData(filename, "Unknown", 0, false);
        files.add(temp);
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param time the year of release
     */
    public void addFile(String filename, int time) {
        Music temp = new Music();
        temp.setMusicData(filename, "Unknown", time, false);
        files.add(temp);
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param artist The artist name
     */
    public void addFile(String filename, String artist) {
        Music temp = new Music();
        temp.setMusicData(filename, artist, 0, false);
        files.add(temp);
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param artist The artist name
     * @param time the year of release
     */
    public void addFile(String filename, String artist, int time) {
        Music temp = new Music();
        temp.setMusicData(filename, artist, time, false);
        files.add(temp);
        numberOfFiles++;
    }

    /**
     * chaing music info
     * @param index get the index of file we want to change
     * @param artist new artist name
     */
    public void editFIle(int index, String artist){
        if(validIndex(index)) {
            Music temp = files.get(index);
            temp.setArtists(artist);
            files.set(index, temp);
            System.out.println("Done");
            System.out.println("The edited music is: ");
            listFile(index);
        }else
            System.out.println("Invalid index");
    }
    /**
     * chaing music info
     * @param index get the index of file we want to change
     * @param time new release year
     */
    public void editFIle(int index, int time){
        if(validIndex(index)) {
            Music temp = files.get(index);
            temp.setTimes(time);
            files.set(index, temp);
            System.out.println("Done");
            System.out.println("The edited music is: ");
            listFile(index);
        }else
            System.out.println("Invalid index");
    }
    /**
     * chaing music info
     * @param index get the index of file we want to change
     * @param artist new artist name
     * @param time new release year
     */
    public void editFIle(int index, String artist, int time){
        if(validIndex(index)) {
            Music temp = files.get(index);
            temp.setArtists(artist);
            temp.setArtists(artist);
            files.set(index, temp);
            System.out.println("Done");
            System.out.println("The edited music is: ");
            listFile(index);
        }else
            System.out.println("Invalid index");
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        numberOfFiles = files.size();            // checking to make sure :)
        return numberOfFiles;
    }

    /**
     * this file search file which contains filename
     * @param filename filename to be searched
     * @return the search result
     */
    private String searchFilename(String filename){
        StringBuilder result = new StringBuilder();
        result.append("");
        for (Music file : files) {
            if (file.getFiles().toLowerCase(Locale.ROOT).contains(filename.toLowerCase(Locale.ROOT)))
                result.append(files.indexOf(file)).append(" - ").append(file.getFiles()).append("\n");
        }
        if(!result.toString().equals(""))
            return result.toString();
        else
            return "";
    }
    /**
     * this search for artist names of file
     * this method is not case sensitive
     * @param artist artist name
     * @return the search result
     */
    private String searchArtist(String artist){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < files.size(); i++){
            if(files.get(i).getFiles().toLowerCase(Locale.ROOT).contains(artist.toLowerCase(Locale.ROOT))){
                if(validIndex(i))
                    result.append(i).append(" - ").append(files.get(i).getFiles()).append("\n");
            }
        }
        if(!result.toString().equals(""))
            return result.toString();
        else
            return "";
    }
    /**
     * search for equle release date
     * @param time release date
     * @return the search result
     */
    private String searchReleaseDate(int time){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < files.size(); i++){
            if(files.get(i).getTimes() == time){
                if(validIndex(i))
                    result.append(i).append(" - ").append(files.get(i).getFiles()).append("\n");
            }
        }
        if(!result.toString().equals(""))
            return result.toString();
        else
            return "";
    }
    /**
     * This method search according to a time domain
     * @param startPoint start of release date
     * @param endPoint  end of release date
     * @return the search result
     */
    private String searchReleaseDate(int startPoint, int endPoint){
        StringBuilder result = new StringBuilder();
        result.append("");
        if(endPoint<startPoint){
            int temp = startPoint;
            startPoint = endPoint;
            endPoint = temp;
        }
        for(int i = 0; i < files.size(); i++){
            if(files.get(i).getTimes() <= endPoint && files.get(i).getTimes() >= startPoint){
                if(validIndex(i))
                    result.append(i).append(" - ").append(files.get(i).getFiles()).append("\n");
            }
        }
        if(!result.toString().equals(""))
            return result.toString();
        else
            return "";
    }
    /**
     *
     * @param input the string which contains staff to be searched
     */
    public void searchMusic(String input){
        String[] inputArray = input.split("#");
        StringBuilder result = new StringBuilder();
        for (String str:inputArray){
            String[] tempArray = str.split("-");
            switch (tempArray[0].toLowerCase(Locale.ROOT)) {
                case "file" -> result.append("\nby file name:\n").append(searchFilename(tempArray[1]));
                case "art" -> result.append("\nby artist name:\n").append(searchArtist(tempArray[1]));
                case "time" -> result.append("\nby date release:\n").append(searchReleaseDate(Integer.parseInt(tempArray[1])));
                case "td" -> result.append("\nby time domain:\n").append(searchReleaseDate(Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2])));
            }
        }
        if(result.toString().equals(""))
            System.out.println("\nNo result\n");
        else
            System.out.println(result);
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        if(validIndex(index)) {
            System.out.print((index) + " - " + files.get(index).getFiles());
            if(!files.get(index).getArtists().equals("Unknown")) {
                System.out.print(" - artist: " + files.get(index).getArtists());
            }
            if(files.get(index).getTimes() != 0) {
                System.out.print(" - release date: " + files.get(index).getTimes());
            }
            System.out.println();
        }
        else
            System.out.println("Wrong Index\n");
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles() {
        if(files.size() > 0){
            System.out.println("\nAll musics, total number: " + files.size() + "\n");
            for (int i = 0; i < files.size(); i++) {
                System.out.print(i + " - " + files.get(i).getFiles());
                if(!files.get(i).getArtists().equals("Unknown")) {
                    System.out.print(" - artist: " + files.get(i).getArtists());
                }
                if(files.get(i).getTimes() != 0) {
                    System.out.print(" - release date: " + files.get(i).getTimes());
                }
                    System.out.println();
            }
        }else {
            System.out.println("\n\nNo Music :)");
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        if(validIndex(index)) {
            files.remove(index);
        }
        else
            System.out.println("Wrong index");
    }

    /**
     * set the music we want as favorite
     * @param index to true
     */
    public void setFavorite(int index) {
        if(validIndex(index)){
            Music temp = files.get(index);
            temp.setFavorites(true);
            files.set(index, temp);
        }
        else
            System.out.println("Invalid index");
    }

    /**
     * remove the music we want from favorite
     * @param index to true
     */
    public void removeFavorite(int index) {
        if(validIndex(index)){
            Music temp = files.get(index);
            temp.setFavorites(false);
            files.set(index, temp);
        }
        else
            System.out.println("Invalid index");
    }

    /**
     * prints All favorite music information
     */
    public void listFavorite(){
        int i = 0;
        for(i = 0; i < files.size();i++){
            if(files.get(i).getFavorites())
                listFile(i);
        }
        if(i == 0)
            System.out.println("No favorite music");
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index) {
        if(validIndex(index))
            player.startPlaying(files.get(index).getFiles());
        else
            System.out.println("This file does not exist");
    }

    /**
     * @return player state
     */
    public boolean playingState(){
        return player.getPlayState();
    }

    /**
     * Stop the player.
     */
    public void stopPlaying(){
        player.stop();
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        return (index >= 0 && index < files.size());
    }

    /**
     *
     * @return type of collection
     */
    public String getType() {
        return type;
    }
}
