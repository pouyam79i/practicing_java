/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh

Student Class in oldFiles.APworkshop package
 */


package APworkshop;

// Initializing student object and setting important info. in Constructor
public class Student {

    private String firstName; // First Name of Student
    private String lastName;  // Last Name of Student
    private  String ID;  // University ID of Student
    private double grade;  // Student's Grade

    // Student Constructor
    public Student(String firstName, String lastName, String ID, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.grade = grade;
    }

    // Setter methods:
    public void setFirstName(String input){
        firstName = input;
    }
    public void setLasttName(String input){
        lastName = input;
    }
    public void setID(String input){
        ID = input;
    }
    public void setGrade(int input){
        grade = input;
    }

    // Getter Methods
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
