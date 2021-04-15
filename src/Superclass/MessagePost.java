package Superclass;

public class MessagePost extends Post{

    private String text;

    public MessagePost(String author, String text){
        super(author);
        this.text = text;
    }

}
