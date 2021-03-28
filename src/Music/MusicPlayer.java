package Music;

/**
 * Provide basic playing of MP3 files via the javazoom library.
 * See http://www.javazoom.net/
 * edited by  Pouya Mohammadi CE@AUT uni ID: 9829039
 * @author David J. Barnes and Michael K�lling.
 * @version 2011.07.31
 */
public class MusicPlayer
{
    // The current player. It might be null.
    private boolean isPlaying;
    private String filename;
    /**
     * Constructor for objects of class MusicFilePlayer
     */
    public MusicPlayer()
    {
        isPlaying = false;
        filename = "No file";
    }
    

    /**
     * Start playing the given audio file.
     * The method returns once the playing has been started.
     * @param filename The file to be played.
     */
    public void startPlaying(String filename)
    {
        this.filename = filename;
        System.out.println(this.filename + " is playing...");
		isPlaying = true;
    }

    /**
     * It stops the player
     */
    public void stop()
    {
        System.out.println("player is stopped!");
        filename = "No file";
		isPlaying = false;
    }

    /**
     * returns the state of playing
     * @return isPlaying
     */
    public boolean getPlayState() {
        return isPlaying;
    }

    /**
     * To check the filename which is being played
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

}