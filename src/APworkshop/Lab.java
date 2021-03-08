package APworkshop;

public class Lab {

    private Student[] students;
    private int avg; private String day;
    private int capacity;
    private int currentSize;
    public Lab(int cap, String d) {}
    public void enrollStudent(Student std) {
        if (currentSize < capacity)
    {
        students[currentSize] = std;
    currentSize++;
    }
    else {
        System.out.println("Lab is full!!!");
    }
    }
    public void print() {}
    public Student[] getStudents() {}
    public void setStudents(Student[] students) {}
    public int getAvg() {}
    public void calculateAvg() {}
    public String getDay() {}
    public void setDay(String day) {}
    public int getCapacity() {}
    public void setCapacity(int capacity) {}

}
