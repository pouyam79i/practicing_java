package Music;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // Storing year of release date in times.
    private ArrayList<Integer> times;
    // Storing artist name in artists.
    private ArrayList<String> artists;
    // Storing favorite music
    private ArrayList<Boolean> favorites;
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
        files = new ArrayList<String>();
        times = new ArrayList<Integer>();
        artists = new ArrayList<String>();
        favorites = new ArrayList<Boolean>();
        player = new MusicPlayer();
        type = "Unclassified";
        numberOfFiles = 0;
    }
    /**
     * Create a Music.MusicCollection
     * @param Type is the type of collection
     */
    public MusicCollection(String Type) {
        files = new ArrayList<String>();
        times = new ArrayList<Integer>();
        artists = new ArrayList<String>();
        favorites = new ArrayList<Boolean>();
        player = new MusicPlayer();
        type = Type.toLowerCase(Locale.ROOT);
        numberOfFiles = 0;
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename) {
        files.add(filename);
        times.add(0);
        artists.add("Unknown");
        favorites.add(false);
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param time the year of release
     */
    public void addFile(String filename, int time) {
        files.add(filename);
        times.add(time);
        artists.add("Unknown");
        favorites.add(false);
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param artist The artist name
     */
    public void addFile(String filename, String artist) {
        files.add(filename);
        times.add(0);
        artists.add(artist);
        favorites.add(false);
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param artist The artist name
     * @param time the year of release
     */
    public void addFile(String filename, String artist, int time) {
        files.add(filename);
        times.add(time);
        artists.add(artist);
        favorites.add(false);
        numberOfFiles++;
    }

    /**
     * chaing music info
     * @param index get the index of file we want to change
     * @param artist new artist name
     */
    public void editFIle(int index, String artist){
        if(validIndex(index)) {
            artists.set(index, artist);
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
            times.set(index, time);
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
            times.set(index, time);
            artists.set(index, artist);
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
     */
    public void searchFilename(String filename){
        StringBuilder result = new StringBuilder();
        result.append("");
        for (String file : files) {
            if (file.toLowerCase(Locale.ROOT).contains(filename.toLowerCase(Locale.ROOT)))
                result.append("# ").append(file).append("\n");
        }
        if(!result.toString().equals(""))
            System.out.println("Result is: \n" + result);
        else
            System.out.println("No result");
    }
    /**
     * this search for artist names of file
     * this method is not case sensitive
     * @param artist artist name
     */
    public void searchArtist(String artist){
        StringBuilder result = new StringBuilder();
        result.append("");
        for(int i = 0; i < artists.size(); i++){
            if(artists.get(i).toLowerCase(Locale.ROOT).contains(artist.toLowerCase(Locale.ROOT))){
                if(validIndex(i))
                    result.append("# ").append(files.get(i)).append("\n");
            }
        }
        if(!result.toString().equals(""))
            System.out.println("Result is: \n" + result);
        else
            System.out.println("No result");
    }
    /**
     * search for equle release date
     * @param time release date
     */
    public void searchReleaseDate(int time){
        StringBuilder result = new StringBuilder();
        result.append("");
        for(int i = 0; i < times.size(); i++){
            if(times.get(i) == time){
                if(validIndex(i))
                    result.append("# ").append(files.get(i)).append("\n");
            }
        }
        if(!result.toString().equals(""))
            System.out.println("Result is: \n" + result);
        else
            System.out.println("No result");
    }
    /**
     * This method search according to a time domain
     * @param startPoint start of release date
     * @param endPoint  end of release date
     */
    public void searchReleaseDate(int startPoint, int endPoint){
        StringBuilder result = new StringBuilder();
        result.append("");
        if(endPoint<startPoint){
            int temp = startPoint;
            startPoint = endPoint;
            endPoint = temp;
        }
        for(int i = 0; i < times.size(); i++){
            if(times.get(i) <= endPoint && times.get(i) >= startPoint){
                if(validIndex(i))
                    result.append("# ").append(files.get(i)).append("\n");
            }
        }
        if(!result.toString().equals(""))
            System.out.println("Result is: \n" + result);
        else
            System.out.println("No result");
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        if(validIndex(index)) {
            System.out.print((index) + " - " + files.get(index));
            if(!artists.get(index).equals("Unknown")) {
                System.out.print(" - artist: " + artists.get(index));
            }
            if(times.get(index) != 0) {
                System.out.print(" - release date: " + times.get(index));
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
            System.out.println("\nAll musics, total number: " + files.size());
            for (int i = 0; i < files.size(); i++) {
                System.out.print(i + " - " + files.get(i));
                if(!artists.get(i).equals("Unknown")) {
                    System.out.print(" - artist: " + artists.get(i));
                }
                if(times.get(i) != 0) {
                    System.out.print(" - release date: " + times.get(i));
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
            times.remove(index);
            artists.remove(index);
        }
        else
            System.out.println("Wrong index");
    }

    /**
     * set the music we want as favorite
     * @param index to true
     */
    public void setFavorite(int index) {
        if(validIndex(index))
            favorites.set(index, true);
    }

    /**
     * remove the music we want from favorite
     * @param index to true
     */
    public void removeFavorite(int index) {
        if(validIndex(index))
            favorites.set(index, false);
    }

    /**
     * prints All favorite music information
     */
    public void listFavorite(){
        int i = 0;
        for(i = 0; i < files.size();i++){
            if(favorites.get(i))
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
            player.startPlaying(files.get(index));
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
        int tempSize = files.size();
        return (index >= 0 && index < tempSize);
    }

    /**
     * checks if the filename you have entered
     * between the existing files
     * @param filename is going to be searched
     */
    public void searchFile(String filename){
        int i;
        for (i = 0; i < files.size(); i++){
            if(files.get(i).toLowerCase(Locale.ROOT).contains(filename.toLowerCase(Locale.ROOT)))
                listFile(i);
        }
        if(i == 0){
            System.out.println("No result :(");
        }
    }

    /**
     *
     * @return type of collection
     */
    public String getType() {
        return type;
    }
}
