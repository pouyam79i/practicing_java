package Music;

public class Music {
    private MusicCollection pop;
    private MusicCollection jazz;
    private MusicCollection rock;
    private MusicCollection country;
    private MusicCollection unclassified;

    public Music(){
        pop = new MusicCollection();
        jazz = new MusicCollection();
        rock = new MusicCollection();
        country = new MusicCollection();
        unclassified = new MusicCollection();
    }

    public void addMusic(String name){
        unclassified.addFile(name);
    }

    public void addMusic(String name, String type){
        type = type.toUpperCase();
        switch (type) {
            case "POP" -> pop.addFile(name);
            case "JAZZ" -> jazz.addFile(name);
            case "ROCK" -> rock.addFile(name);
            case "COUNTRY" -> country.addFile(name);
            default -> {
                System.out.println("We Don't have this type");
                unclassified.addFile(name);
            }
        }

    }
}
