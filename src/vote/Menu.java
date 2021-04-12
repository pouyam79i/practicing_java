/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
Menu Class, contains menus texts
 */

public class Menu {

    /**
     * main menu
     */
    public final String mainMenu = """
            1 - Create voting
            2 - Add voter
            3 - Vote
            4 - Show list of voting
            5 - Show result
            6 - Exit
""";

    /**
     * create voting menu
     */
    public final String[] createVotingMenu = { """
            Write the question of your voting:
""",
            """
            Do you want to allow multiple choice? (Y/N)
""",
            """
            Please enter choices: (at least 2 option)
             - When your done enter '*#DONE'
"""
    };

    /**
     * add voter menu
     */
    public final String[] addVoterMenu = {
            """
            Please enter your first name:
""",
            """
            Please Enter your last name:
""",
            """
            Please Enter your ID: (It must be unique)
""",
    };

    /**
     * vote menu
     */
    public final String[] voteMenu = {
            """
            Enter the index of voting:
""",
            """
            Enter your ID: (You must have signed up before)
""",
            """
            Enter your choices: ( like 2#7#1 )
             - Remember: if the multiple choice is off, only your first vote will be accepted!
             - Only index of existing options will be assigned as a vote!
             
"""
    };

    /**
     * show result menu
     */
    public final String showResultMenu = """
            Enter the index of voting:
            """;

}
