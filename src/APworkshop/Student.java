/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh
 */
package APworkshop;


public class Student {
    private String firstName; // First Name of Student
    private String lastName;  // Last Name of Student
    private  String ID;  // University ID of Student
    private int grade;  //


// Setter methods:
    // Setter of First Name
    public void setFirstName(String input){
        firstName = input;
    }
    // Setter of Last Name
    public void setLasttName(String input){
        lastName = input;
    }
    // Setter of University ID
    public void setID(String input){
        ID = input;
    }
    // Setter of Grade
    public void setGrade(int input){
        grade = input;
    }



// Getter methods:
    // Getter of First Name
    public String setFirstName(){
        return firstName;
    }
    // Getter of Last Name
    public String setLasttName(){
        return lastName;
    }
    // Getter of University ID
    public String setID(){
        return ID;
    }
    // Getter of Grade
    public int setGrade(){
        return grade;
    }



}
