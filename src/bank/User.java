/*
Coded by Pouya Mohammadi
CE@AUT Uni ID: 9829039
This is the User Class for our banking systems
 */

import java.util.ArrayList;

public class User {

    /**
     * User personal ID. National Code
     */
    private final String ID;
    /**
     * User First Name
     */
    private String firstName;
    /**
     * User Last Name
     */
    private String lastName;
    /**
     * Account password
     */
    private String password;
    /**
     * All the bank accounts that a user have
     */
    private ArrayList<Account> accounts;

    /**
     * This is the constructor for Sser
     * @param firstName setting user first name
     * @param lastName setting user last name
     * @param ID setting user ID
     * @param password setting user password;
     */
    public User(String firstName, String lastName, String ID, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password  = password;
        accounts = new ArrayList<Account>();
    }

    /**
     * adds an account
     * @param account will be added to the accounts list
     */
    public void addAccount(Account account){
        accounts.add(account);
    }

    /**
     * remove an account
     * @param account will be removed from list
     * @return true if it could remove the account else it will return false
     */
    public boolean removeAccount(Account account){
        int index = accounts.indexOf(account);
        if(index < 0)
            return false;
        accounts.remove(index);
        return true;
    }

    /**
     * @param account's balance will be updated with amount
     * @param amount  will update the balance
     */
    public void deposit(Account account, double amount){
        amount = Math.abs(amount);
        if(account.updateBalance(amount * -1)){
            Transaction transaction = new Transaction(amount * -1);
            account.addTransaction(transaction);
            transaction.printInfo();
        }else {
            System.out.println("Failed to deposit !");
            System.out.println("Your balance is not enough !");
        }
    }

    /**
     * @param account's balance will be updated with amount
     * @param amount  will update the balance
     */
    public void withdrawal(Account account, double amount){
        amount = Math.abs(amount);
        if(account.updateBalance(Math.abs(amount))){
            Transaction transaction = new Transaction(amount);
            account.addTransaction(transaction);
            System.out.println("Completed!");
            transaction.printInfo();
        }else {
            System.out.println("Fail to withdrawal !");
        }
    }

    /**
     * transfer money between accounts
     * @param srcAccount is the account we are taking money from it.
     * @param destAccount is the account we are adding money to.
     * @param amount is the size of money
     */
    public void transfer(Account srcAccount, Account destAccount, double amount){
        amount = Math.abs(amount);
        if(srcAccount.updateBalance(amount * -1)){
            destAccount.updateBalance(amount);
            Transaction transactionSrc = new Transaction(amount * -1, destAccount.getUUID());
            Transaction transactionDest = new Transaction(amount, srcAccount.getUUID());
            srcAccount.addTransaction(transactionSrc);
            destAccount.addTransaction(transactionDest);
            System.out.println("Completed.");
            transactionSrc.printInfo();
        }else {
            System.out.println("Failed to Transfer money !");
            System.out.println("Your balance is not enough !");
        }
    }

    /**
     * Prints account balance
     * @param account's balance will be checked
     */
    public void checkBalance(Account account){
        account.printAccountData();
    }

    /**
     * Prints all accounts information
     */
    public void printAllAvailableAccounts(){
        for(Account account : accounts){
            account.printAccountData();
        }
    }

    /**
     * Prints user information
     */
    public void printUserData(){
        System.out.println();
        System.out.println("*** User info:");
        System.out.println("User full name: " + firstName + " " + lastName);
        System.out.println("User ID: " + ID);
        System.out.println("Number of available accounts: " + accounts.size());
        System.out.println("***");
        System.out.println();
    }

    /**
     * @param account will be checked if it exist.
     * @return if it exists it will return true, else false.
     */
    public boolean accountExist(Account account){
        int index = accounts.indexOf(account);
        if (index < 0)
            System.out.println("This account is not among your accounts");
        return index >= 0;
    }

    // Getters
    public String getID() {
        return ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
