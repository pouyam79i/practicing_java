/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
Vote Class
 */

import ir.huri.jcal.JalaliCalendar;
import java.util.Date;

public class Vote {

    /**
     * person is the voter
     */
    private Person person;
    /**
     * the date and time of vote
     */
    private final String date;

    /**
     * Vote property
     * @param person who voted
     */
    public Vote(Person person){
        Date currentDate = new Date();
        JalaliCalendar jalaliCurrentDate = new JalaliCalendar();
        date = "Date: " + jalaliCurrentDate.toString() + " Time: " + currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();
        this.person = person;
    }

    /**
     * Voting info
     */
    public void printVoteInfo(){
        String message = "Voter ID: " + person.getID() + " - Voter name: " + person.getFirstName() + " " + person.getLastName()
                + " - " + date;
        System.out.println(message);
    }

    // Getters
    public Person getPerson() {
        return person;
    }
    public String getDate() {
        return date;
    }

}
