/*
Coded by Pouya Mohammadi
CE@AUT uni id: 9829039
 */

package Music;

public class Menu {

    /**
     * oldFiles.Main Menu Text
     */
    public final String mainMenu = """
            Main Menu\s
            1 - Play music
            2 - Add music
            3 - Set Favorite
            4 - Remove Favorite
            5 - Remove Music
            6 - List files
            7 - Search Music
            8 - Exit
            
            Enter a number:\s
           
            """;

    /**
     * Play Music Menu Text
     */
    public final String playMenu = """
            Enter the 'type#index' of music:\s
            
            """;
    /**
     * Add Music Menu Text
     */
    public final String addMenu = """
            Enter the music 'type#musicInfo':\s
                importing styles:
                 - type#filename
                 - type#filename#TIME-'integer number' like: pop#Monster#TIME-2015
                 - type#filename#artist
                 - type#filename#artist#'integer number'
            """;

    /**
     * Remove Music Menu Text
     */
    public final String removeMenu = """
            Enter the music 'type#index' to be removed:\s
            
            """;

    public final String favoriteMenu = """
            Enter the music 'type#index' tp be set as favorite:\s
            
            """;

    public final String removeFavoriteMenu = """
            Enter the music 'type#index' tp be removed from favorite:\s
            
            """;

    public final String searchMenu = """
            Enter the music info to be searched\s
            your input must be like:
             - type#FILE-filename
             - type#ART-artist
             - tpye#TIME-'integer number'   like: pop#TIME-1389
             - type#TD-'integer number-'integer number'
             - a combination like: type#FILE-filename#TIME-2015#ART-artist
            """;

    /**
     * List Music Menu Text
     */
    public final String listMenu = """
            1 - To print a list of all music enter type#ALL
            2 - To print one file info enter type#index\s
            3 - To print favorite list enter tpye#FAV
            
            """;


    public Menu(){}
}
