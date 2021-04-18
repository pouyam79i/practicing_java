package oldFiles;/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh

in this class I will test and run my AP workshop packages
 */

import APworkshop.Student;
import APworkshop.Lab;

public class APworkshop {

    public static void main(String[] args) {

        // seting up student objecs
        Student student_1 = new Student("Ali" , "Mahabadi", "9831055", 18);
        Student student_2 = new Student("Reza" , "Jafari", "9521025", 16);
        Student student_3 = new Student("Sara" , "Mohammadi", "9733037", 13);

        // creating lab object
        Lab lab = new Lab("CEIT", "Electronic Circuit", 10);

        lab.setOffDay("Friday");        // chaing lab info

        lab.enrollStudent(student_1);       // enrolling std1
        lab.enrollStudent(student_2);       // enrolling std2
        lab.enrollStudent(student_3);       // enrolling std3

        lab.printLabInfo();                 // printing lab information
        lab.printStudentsInfo();            // printing all students information

    }
}

