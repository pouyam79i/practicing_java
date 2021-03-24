package Music;

import java.util.ArrayList;

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
    // A player for the music files.
    private MusicPlayer player;
    // Contains number of files.
    private int numberOfFiles;
    // Type of collection
    private String type;

    /**
     * Create a Music.MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<String>();
        times = new ArrayList<Integer>();
        artists = new ArrayList<String>();
        player = new MusicPlayer();
        type = "Unclassified";
        numberOfFiles = 0;
    }
    /**
     * Create a Music.MusicCollection
     * @param Type is the type of collection
     */
    public MusicCollection(String Type)
    {
        files = new ArrayList<String>();
        times = new ArrayList<Integer>();
        artists = new ArrayList<String>();
        player = new MusicPlayer();
        type = Type;
        numberOfFiles = 0;
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
        times.add(0);
        artists.add("Unknown");
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param time the year of release
     */
    public void addFile(String filename, int time)
    {
        files.add(filename);
        times.add(time);
        artists.add("Unknown");
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param artist The artist name
     */
    public void addFile(String filename, String artist)
    {
        files.add(filename);
        times.add(0);
        artists.add(artist);
        numberOfFiles++;
    }
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param artist The artist name
     * @param time the year of release
     */
    public void addFile(String filename, String artist, int time)
    {
        files.add(filename);
        times.add(time);
        artists.add(artist);
        numberOfFiles++;
    }


    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        numberOfFiles = files.size();            // checking to make sure :)
        return numberOfFiles;
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            System.out.println("Music Info: \n");
            System.out.println((index + 1) + " - " + files.get(index) + "\n");
        }
        else
            System.out.println("Wrong Index\n");
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        if(files.size() > 0){
            System.out.println("\nAll musics, total number: " + files.size());
            for (int i = 0; i < files.size(); i++) {
                System.out.print((i + 1) + " - " + files.get(i));
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
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
            times.remove(index);
            artists.remove(index);
        }
        else
            System.out.println("Wrong index");
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
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
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        int tempSize = files.size();
        return (index >= 0 && index < tempSize);
    }

    /**
     *
     * @return type of collection
     */
    public String getType() {
        return type;
    }
}
