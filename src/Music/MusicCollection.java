package Music;

import java.util.ArrayList;
import java.util.Iterator;

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
    // A player for the music files.
    private MusicPlayer player;
    // Contains number of files
    private int numberOfFiles;

    /**
     * Create a Music.MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
        numberOfFiles = 0;
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
        numberOfFiles++;
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        numberOfFiles = files.size();
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
        System.out.println("\nAll musics, total number: " + files.size());
        if(files.size() > 0){
            for (int i = 0; i < files.size(); i++)
                System.out.println((i + 1) + " - " + files.get(i));
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
            listAllFiles();
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
}
