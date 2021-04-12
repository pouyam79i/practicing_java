/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
Person Class
 */

public class Person {

    /**
     * First name of person
     */
    private String firstName;
    /**
     * Last name of person
     */
    private String lastName;
    /**
     * ID is a unique property for each person
     */
    private final String ID;

    /**
     * Setup a person property, name and ID
     * @param firstName of the person
     * @param lastName of the person
     * @param ID of the person, It is unique.
     */
    public Person(String firstName, String lastName, String ID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }

    // Getters;
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getID() {
        return ID;
    }

}

