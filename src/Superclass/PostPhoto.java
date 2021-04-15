package Superclass;

public class PostPhoto extends Post{

    private String fileID;

    public PostPhoto(String author, String fileID){
        super(author);
        this.fileID = fileID;
    }

}
