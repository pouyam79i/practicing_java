package APworkshop;

public class Lab {

    private Student[] students;
    private String day;
    private String department;
    private String labName = "My lab";
    private double avgGrade;
    private int labCapacity;
    private int currentSize;

    public Lab(int labCapacity, String department, String labName) {
        students = new Student[labCapacity];
        currentSize = 0;
        this.department = department;
        this.labCapacity = labCapacity;
        this.labName = labName;
    }

    public void enrollStudent(Student std) {
        if (currentSize < labCapacity)
        {
            students[currentSize + 1] = std;
            currentSize++;
            updateAvgGrades();
        }
        else {
            System.out.println("Lab is full!!!");
        }
    }

    private void updateAvgGrades(){
        double temp = 0;
        for (Student student : students) {
            temp += student.getGrade();
        }
        avgGrade = temp / students.length;
    }

public void printStudentsInfo() {
        int i = 0;
        for(Student student: students){
            i++;
            System.out.println("Student#" + i + " - Last name: " + student.getLastName() + ", ID: " + student.getID() + ", Grade: " + student.getGrade());
        }
}

public void printLabInfo(){
    updateAvgGrades();
    System.out.println("###Lab Info\nName: " + labName + "\nTotal Capacity: " + labCapacity);
    System.out.println("Department of " + department);
    System.out.println("###General look:");
    System.out.println("Participation: " + currentSize + "\n Avarage Grade: " + avgGrade);
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
