package APworkshop;

public class Lab {

    private Student[] students;
    private String day;
    private String department;
    private String labName = "My lab";
    private double avgGrade = 0;
    private int labCapacity;
    private int currentSize;

    public Lab(String department, String labName, int labCapacity) {
        students = new Student[labCapacity];
        currentSize = 0;
        this.department = department;
        this.labCapacity = labCapacity;
        this.labName = labName;
    }

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

    private void updateAvgGrades(){
        double temp = 0;
        for (int i = 0; i < currentSize; i++) {
            temp = temp + students[i].getGrade();
        }
        avgGrade = temp / currentSize;
    }

public void printStudentsInfo() {
        System.out.println("");
        for(int i = 0; i < currentSize; i++){
            System.out.println("Student#" + i + " - Last name: " + students[i].getLastName() + ", ID: " + students[i].getID() + ", Grade: " + students[i].getGrade());
        }
}

public void printLabInfo(){
    System.out.println("");
    System.out.println("###Lab Info\nName: " + labName + "\nDepartment of: " + department);
    System.out.println("Total Capacity: " + labCapacity);
    System.out.println("**General look");
    System.out.println("Participation: " + currentSize + "\nAvarage Grade: " + avgGrade);
    System.out.println("");
}
// Setter methods
    public void setStudents(Student[] students) {
        this.students = students;
    }
    public void setDay(String day) {
        this.day = day;
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
    public String getDay() {
        return day;
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
