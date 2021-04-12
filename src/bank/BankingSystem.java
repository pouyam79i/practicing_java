/*
Coded by Pouya Mohammadi
CE@AUT Uni ID: 9829039
This is the BankSystem Class for our banking system application
 */

import java.util.ArrayList;
import java.util.Iterator;

public class BankingSystem {

    /**
     * It contains all the user information registered in the bank
     */
    private ArrayList<User> users;
    /**
     * It contains all the accounts registered in the bank
     */
    private ArrayList<Account> accounts;
    /**
     * Admin User Name
     */
    private String adminUser = "sysadmin";
    /**
     * Admin Password
     */
    private String adminPassword = "1234";

    /**
     * BankingSystem constructor
     */
    public BankingSystem(){
        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();
    }

    /**
     * Check the user if it is not repeated it will be added.
     * @param user may be added
     */
    public void register(User user){
        boolean isRepeated = false;
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            if(it.next().getID().equals(user.getID())){
                isRepeated = true;
                break;
            }
        }
        if(isRepeated){
            System.out.println("This user is not added !!!");
            System.out.println("User already exists");
        }
        else{
            addUser(user);
            System.out.println("User created");
        }
    }

    /**
     * This function handles log-in process.
     * @param id checks the user id if it exist.
     * @param password checks if its correct according to the found user.
     * @return user if id and password is true, else it will return null.
     */
    public User login(String id, String password){
        User user = null;
        User temp = null;
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            temp = it.next();
            if(temp.getID().equals(id)){
                user = temp;
                break;
            }
        }
        if(user == null){
            System.out.println("This user ID does not exist");
            return null;
        }
        if(!user.getPassword().equals(password)){
            System.out.println("Wrong password");
            return null;
        }
        System.out.println("Hello " + user.getFirstName() + " " + user.getLastName() + ".");
        return user;
    }

    /**
     * Adds User to the array list
     * @param user will be added
     */
    private void addUser(User user){
        users.add(user);
    }

    /**
     * remover User
     * @param user will be removed
     */
    public void removeUser(User user){
        if(!users.contains(user)){
            System.out.println("This user does not exists!");
        }
        for (Account ac : user.getAccounts()){
            accounts.remove(ac);
        }
        users.remove(user);
        System.out.println("User and its belonging accounts are all deleted!");
    }

    /**
     * Displays all existing user
     */
    public void displayUsers(){
        User temp = null;
        int index = 0;
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            temp = it.next();
            String message = "";
            message = "User " + index + ":" + " Full name: " + temp.getFirstName() + " "
                + temp.getLastName() + " ID: " + temp.getID();
            System.out.println(message);
            System.out.println("\n");
            index++;
        }
    }

    /**
     * add the account to the arraylist of BankingSystem
     * @param account will be added
     */
    public void addAccount(Account account){
        accounts.add(account);
    }

    /**
     * remove an account
     * @param account will be removed
     */
    public void removeAccount(Account account){
        for (User user : users){
            if(user.getID().equals(account.getID())){
                user.removeAccount(account);
                accounts.remove(account);
                System.out.println("Account Removed!");
                break;
            }
        }
    }

    /**
     * Prints all existing accounts
     */
    public void displayAccounts(){
        Account temp = null;
        int index = 0;
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()){
            temp = it.next();
            String message = "";
            message = "Account " + index + ": " + "Serial: " + temp.getUUID().toString()
                    + " Type: " + temp.getAccountType() + " Balance: " + temp.getBalance();
            System.out.println(message);
            System.out.println("\n");
            index++;
        }
    }

    /**
     * search for a account
     * @param serial will be search between account UUIDs
     * @return account if found, else it is null to be returned
     */
    public Account findAccount(String serial){
        Account account = null;
        Account temp = null;
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()){
            temp = it.next();
            if(temp.getUUID().toString().equals(serial)){
                account = temp;
                break;
            }
        }
        if(account == null)
            System.out.println("Cannot find the account!");
        return account;
    }

    /**
     * Search for user
     * @param ID search for User with the same ID
     * @return User if it exists, else null
     */
    public User findUser(String ID){
        User account = null;
        User temp = null;
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            temp = it.next();
            if(temp.getID().equals(ID)){
                account = temp;
                break;
            }
        }
        if(account == null)
            System.out.println("Cannot find the user!");
        return account;
    }

    // Getters
    public String getAdminUser() {
        return adminUser;
    }
    public String getAdminPassword() {
        return adminPassword;
    }

}
