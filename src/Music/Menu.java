package Music;

public class Menu {

    /**
     * Main Menu Text
     */
    public final String mainMenu = """
            Main Menu\s
            1 - Play music
            2 - Add music
            3 - Remove Music
            4 - List files
            5 - Exit
            
            Enter a number:\s
           
            """;

    /**
     * Play Music Menu Text
     */
    public final String playMenu = """
            Enter the 'index' of music:\s
            
            """;
    /**
     * Add Music Menu Text
     */
    public final String addMenu = """
            Enter the music 'name':\s
            
            """;

    /**
     * Remove Music Menu Text
     */
    public final String removeMenu = """
            Enter the music 'index' tp be removed:\s
            
            """;

    /**
     * List Music Menu Text
     */
    public final String listMenu = """
            1 - To print a list of all music enter 'All'
            2 - To print one file info enter its 'index'\s
            
            """;


    public Menu(){}
}
