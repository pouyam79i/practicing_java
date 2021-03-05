/*
Coded by Pouya Mohamadi
Uni ID: 9829039
tel ID: @pouya_moh
 */

import java.util.Scanner;
import java.lang.Math;

class ComplexNumber{
    public int Re;
    public int Im;
    Scanner scan = new Scanner(System.in);

    public void readComplex(){
        Re = scan.nextInt();
        Im = scan.nextInt();
    }

    public void printComplex(){
        System.out.print(Re);
        if(Im<0){
            System.out.println(Im + "i");
        }
        else{
            if(Im != 1) {
                System.out.println("+" + Im + "i");
            }
            else{
                System.out.println("+" + "i");
            }
        }
    }

}

class ComplexOpration{

    ComplexNumber result = new ComplexNumber();


    public void plus(ComplexNumber complex_number1, ComplexNumber complex_number2){
        result.Re = complex_number1.Re + complex_number2.Re;
        result.Im = complex_number1.Im + complex_number2.Im;
        result.printComplex();
    }

    public void minus(ComplexNumber complex_number1, ComplexNumber complex_number2){
        result.Re = complex_number1.Re - complex_number2.Re;
        result.Im = complex_number1.Im - complex_number2.Im;
        result.printComplex();
    }

    public void product(ComplexNumber complex_number1, ComplexNumber complex_number2){
        result.Re = (complex_number1.Re * complex_number2.Re) - (complex_number1.Im * complex_number2.Im);
        result.Im = (complex_number1.Re * complex_number2.Im) + (complex_number1.Im * complex_number2.Re);
        result.printComplex();
    }

    public void divide(ComplexNumber complex_number1, ComplexNumber complex_number2){
        result.Re = (complex_number1.Re * complex_number2.Re) + (complex_number1.Im * complex_number2.Im);
        result.Im = (complex_number1.Im * complex_number2.Re) - (complex_number1.Re * complex_number2.Im) ;
        int temp;
        temp = (int)Math.sqrt(Math.pow(complex_number2.Re, 2) + Math.pow(complex_number2.Im, 2));
        result.Re = result.Re / temp;
        result.Im = result.Im / temp;
        result.printComplex();
    }

}

public class Complex {
    public static void main(String[] args) {
        ComplexNumber CN1 = new ComplexNumber();
        ComplexNumber CN2 = new ComplexNumber();
        CN1.readComplex();
        CN2.readComplex();
        ComplexOpration complexOprator = new ComplexOpration();
        complexOprator.plus(CN1, CN2);
        complexOprator.minus(CN1, CN2);
        complexOprator.product(CN1, CN2);
        complexOprator.divide(CN1, CN2);
    }
}
