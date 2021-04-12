/*
Coded by Pouya Mohammadi
CE@AUT Uni ID: 9829039
This is the Account Class for our banking systems
 */

import java.util.ArrayList;
import java.util.UUID;

public class Account {

    /**
     * User Unique
     */
    private final UUID uuid;
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
     * Account Type, like: Seporde, Jari.
     */
    private String accountType;
//    /**
//     * Account password
//     */
//    private String password;
    /**
     * The Remaining money
     */
    private double balance;
    /**
     * Transaction Array List
     */
    private ArrayList<Transaction> transactions;


    /**
     * Setting up an account in the constructor
     * @param firstName of user
     * @param lastName of user
     * @param ID of user
     * @param accountType will be set as accountType
     * @param balance will be set as initial balance
     */
    public Account(String firstName, String lastName, String ID,String accountType, double balance){
        uuid = UUID.randomUUID();                  // Setting a random UUID for new user
        transactions = new ArrayList<Transaction>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;                    // Setting first charge at 0
        this.accountType = accountType;
        this.ID = ID;
//        password = "1234";                         // Setting default password as '1234'
    }


    /**
     *  updates the balance
     * @param amount will be added to the balance of account or removed
     * @return true if balance is updated
     */
    public boolean updateBalance(double amount){
        if(balance >= Math.abs(amount) && amount < 0)
            balance += amount;
        else if(amount > 0)
            balance += amount;
        else
            return false;
        return true;
    }

    /**
     * adds transaction and update balance
     * @param transaction will be added as new transaction to the account tansactions list
     */
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    /**
     * Prints all recent transactions
     */
    public void printTransactions(){
        System.out.println("** All transactions **");
        System.out.println("Belongs to the account ID: " + uuid.toString());
        System.out.println("............................................................");
        for(Transaction transaction : transactions){
            transaction.printInfo();
        }
    }

    /**
     * Prints account information
     * first name and last name of its owner
     * Account UUID
     * Balance of Account
     */
    public void printAccountData(){
        System.out.println();
        System.out.println("*** Account info:");
        System.out.println("This account belongs to " + firstName + " " + lastName);
        System.out.println("Account ID: " + uuid.toString());
        System.out.println("Account type: " + accountType);
        System.out.println("Balance: " + balance);
        System.out.println("***");
        System.out.println();
    }

    // Getters
    public UUID getUUID() {
        return uuid;
    }
    public String getID() {
        return ID;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getBalance() {
        return balance;
    }

}

