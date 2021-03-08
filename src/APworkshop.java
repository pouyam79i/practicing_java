/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Tel ID: @Pouya_Moh

in this class I will test my AP workshop packages
 */

import APworkshop.Student;


public class APworkshop {
    public static void main(String[] args) {
        Student student_1 = new Student("Ali" , "Mohammadi", "9831055");
        Student student_2 = new Student("Reza" , "Jafari", "9521025");
        Student student_3 = new Student("Sara" , "Mohammadi", "9733037");

        student_2.setGrade(15);
        student_2.printStudentInfo();

    }
}
