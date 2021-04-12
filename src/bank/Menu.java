/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
Saving all menu string data here;
 */

public class Menu {

    /**
     * Main Menu String
     */
    public final String mainMenu = """
            1. Sing up
            2. Log in 
            3. System Admin
            4. Exit
             
            """;

    /**
     * This is string array fo sing-up menu
     * 0 for sigup
     * 1 for ID
     * 2 for first name
     * 3 for last name
     * 4 for password
     */
    public final String[] singUpMenu = {
            """
Sign Up:

""",
            """
Enter Your ID: 
* Remember that your ID is your unique identity.

""",
            """
Enter your first name:

""",
            """
Enter your last name:

""",
            """
Enter your new password:
* try to pick a strong password 

"""
    };

    /**
     * This is string array fo log-in menu
     * 0 for 'Log in'
     * 1 for ID
     * 2 for password
     * 3 for Logged-in menu
     */
    public final String[] logInMenu = {
            """
    Log in:
    
""",
            """
Enter your ID:

""",
            """
Enter your password:

""",
            """
    1. Select account
    2. Add account
    3. User info
    4. Log out
"""
    };

    /**
     * Account Options Menu
     */
    public final String accountOptionsMenu = """
            1. Withdrawal
            2. Deposit
            3. Transfer
            4. Check balance
            5. Print All transactions
            6. Back
            
            """;

    /**
     * System admin menu
     */
    public final String sysAdminMenu = """
System Admin Access Menu:
    1. Display all user
    2. Display accounts
    3. Remove user
    4. Remove accounts
    5. Log out
""";


}
