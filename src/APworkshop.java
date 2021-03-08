/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh

in this class I will test my AP workshop packages
 */

import APworkshop.Student;
import APworkshop.Lab;

public class APworkshop {
    public static void main(String[] args) {
        Student student_1 = new Student("Ali" , "Mahabadi", "9831055", 18);
        Student student_2 = new Student("Reza" , "Jafari", "9521025", 16);
        Student student_3 = new Student("Sara" , "Mohammadi", "9733037", 13);


        Lab lab = new Lab("CEIT", "Electronic Circuit", 10);
        lab.enrollStudent(student_1);
        lab.enrollStudent(student_2);
        lab.enrollStudent(student_3);

        lab.printLabInfo();
        lab.printStudentsInfo();

    }
}
