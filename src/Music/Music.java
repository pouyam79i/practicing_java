/*
Coded by Pouya Mohammadi
CE@AUT Uni ID: 9829039
 */
package Music;

import java.util.ArrayList;

public class Music {

    // An ArrayList for storing the file names of music files.
    private String files;
    // Storing year of release date in times.
    private int times;
    // Storing artist name in artists.
    private String artists;
    // Storing favorite music
    private Boolean favorites = false;

    public Music(){
        files = "";
        times = 0;
        artists = "";
        favorites = false;
    }

    // setting music data
    public void setMusicData(String filename, String artist, int time, Boolean fav){
        files = filename;
        times = time;
        artists = artist;
        favorites = fav;
    }

// Getters
    public String getFiles() {
        return files;
    }
    public int getTimes() {
        return times;
    }
    public String getArtists() {
        return artists;
    }
    public Boolean getFavorites() {
        return favorites;
    }


// Setters
    public void setFiles(String files) {
        this.files = files;
    }
    public void setTimes(int times) {
        this.times = times;
    }
    public void setArtists(String artists) {
        this.artists = artists;
    }
    public void setFavorites(Boolean favorites) {
        this.favorites = favorites;
    }

}
