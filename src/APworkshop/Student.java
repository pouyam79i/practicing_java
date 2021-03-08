/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh
 */
package APworkshop;

// Initializing student object and setting important info. in Constructor
public class Student {

    private String firstName; // First Name of Student
    private String lastName;  // Last Name of Student
    private  String ID;  // University ID of Student
    private double grade;  //

    public Student(String fName, String lName, String id){
        setFirstName(fName);
        setLasttName(lName);
        setID(id);
        grade = 0;
    }

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


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getID() {
        return ID;
    }
    public double getGrade() {
        return grade;
    }



    // printing full information of student
    public void printStudentInfo() {
        System.out.println("Full Name of Student: " + firstName + " " + lastName + "\nStudent ID: " + ID + "\nGrade: " + grade);
    }

}
