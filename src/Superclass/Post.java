package Superclass;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Post {

    private String username;
    private Date postingDate;
    private ArrayList<String> likes;
    private HashMap<String, HashMap<Integer, String>> comments;

    public Post(String author){
        username = author;
        postingDate = new Date();
    }

}
