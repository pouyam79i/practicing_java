/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh

Lab Class in APworkshop package
 */

package APworkshop;

public class Lab {

    // Lab fields
    private Student[] students;         // students array
    private String offDay;                 // day
    private String department;          // Lab department
    private String labName;             // Lab Name
    private double avgGrade;            // Average Grade
    private int labCapacity;            // Capacity of Lab
    private int currentSize;            // Current Number of Lab Participants

    // Lab Constructor
    public Lab(String department, String labName, int labCapacity) {
        students = new Student[labCapacity];
        currentSize = 0;
        this.department = department;
        this.labCapacity = labCapacity;
        this.labName = labName;
        avgGrade = 0;
        offDay = "Sunday";
    }

    // enroll one new student
    public void enrollStudent(Student std) {
        if (currentSize < labCapacity)
        {
            students[currentSize] = std;
            currentSize++;
            updateAvgGrades();
        }
        else {
            System.out.println("Lab is full!!!");
        }
    }

    // update grades
    private void updateAvgGrades(){
        double temp = 0;
        for (int i = 0; i < currentSize; i++) {
            temp = temp + students[i].getGrade();
        }
        avgGrade = temp / currentSize;
    }

    // prints Students Information
    public void printStudentsInfo() {
            System.out.println("");
            for(int i = 0; i < currentSize; i++){
                System.out.println("Student#" + i + " - Last name: " + students[i].getLastName() + ", ID: " + students[i].getID() + ", Grade: " + students[i].getGrade());
            }
    }

    // prints Lab Information
    public void printLabInfo(){
        System.out.println("");
        System.out.println("###Lab Info\nName: " + labName + "\nDepartment of " + department);
        System.out.println("Total Capacity: " + labCapacity);
        System.out.println("Lab off Day: " + offDay);
        System.out.println("**General look");
        System.out.println("Participation: " + currentSize);
        System.out.printf("Avarage Grade: %.2f\n", avgGrade);
        System.out.println("");
    }


    // Setter methods
    public void setStudents(Student[] students) {
        this.students = students;
    }
    public void setOffDay(String offDay) {
        this.offDay = offDay;
    }
    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setLabName(String labName) {
        this.labName = labName;
    }
    public void setLabCapacity(int labCapacity) {
        this.labCapacity = labCapacity;
    }
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    // getter methods
    public Student[] getStudents() {
        return students;
    }
    public String getOffDay() {
        return offDay;
    }
    public String getLabName() {
        return labName;
    }
    public String getDepartment() {
        return department;
    }
    public double getAvgGrade() {
        return avgGrade;
    }
    public int getLabCapacity() {
        return labCapacity;
    }
    public int getCurrentSize() {
        return currentSize;
    }

}
