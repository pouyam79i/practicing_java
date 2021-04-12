/*
Coded by Pouya Mohammadi
CE@AUT Uni ID: 9829039
This is the Transaction Class for our banking systems
 */

import java.util.Date;
import java.util.UUID;

public class Transaction {

    /**
     * the amount of transaction
     */
    private double amount;
    /**
     * storing date of transaction
     */
    private Date date;
    /**
     * the receiver UUID
     */
    private UUID otherAccountUUID;
    /**
     * If we have a UUID it is true, else false
     */
    private boolean isBetweenAccounts;
    /**
     * transactionID
     */
    private UUID transactionUUID;

    /**
     * Capture what has happened in the transaction
     * @param amount is done in this transaction
     */
    public Transaction(double amount){
        transactionUUID = UUID.randomUUID();
        this.amount = amount;
        date = new Date();
        isBetweenAccounts = false;
    }
    /**
     * Capture what has happened in the transaction
     * @param amount is done in this transaction
     * @param otherAccountUUID is the one we have transferred money to
     */
    public Transaction(double amount, UUID otherAccountUUID){
        transactionUUID = UUID.randomUUID();
        this.amount = amount;
        this.otherAccountUUID = otherAccountUUID;
        date = new Date();
        isBetweenAccounts = true;
    }

    /**
     * This method prints transaction information
     */
    public void printInfo(){
        if(isBetweenAccounts) {
            if (amount > 0) {
                System.out.println("########");
                System.out.println("Transaction ID: " + transactionUUID);
                System.out.println("Added Amount: " + amount);
                System.out.println("From account ID: " + otherAccountUUID.toString());
                System.out.println("Date: " + date.toString());
                System.out.println("########");
            }
            else {
                System.out.println("########");
                System.out.println("Transaction ID: " + transactionUUID);
                System.out.println("Taken amount: " + (amount * -1));
                System.out.println("Add to account ID: " + otherAccountUUID.toString());
                System.out.println("Date: " + date.toString());
                System.out.println("########");
            }
        }
        else {
            if (amount > 0) {
                System.out.println("########");
                System.out.println("Transaction ID: " + transactionUUID);
                System.out.println("Added Amount: " + amount);
                System.out.println("Date: " + date.toString());
                System.out.println("########");
            }
            else {
                System.out.println("########");
                System.out.println("Transaction ID: " + transactionUUID);
                System.out.println("Taken amount: " + (amount * -1));
                System.out.println("Date: " + date.toString());
                System.out.println("########");
            }
        }
    }

}
