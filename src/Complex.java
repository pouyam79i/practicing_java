/*
Coded by Pouya Mohammadi
Uni ID: 9829039
Email: pouyamohammadyirbu@gmail.com

Question 5
 */

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

class ComplexNumber{
    public double Re;
    public double Im;
    Scanner scan = new Scanner(System.in);

    public void readComplex(){
        Re = scan.nextDouble();
        Im = scan.nextDouble();
    }

    public void printComplex(){
        System.out.printf("%.2f", Re);
        if(Im<0){
            System.out.printf("%.2fi", Im);
        }
        else{
            if(Im != 1) {
                System.out.printf("+%.2fi", Im);
            }
            else{
                System.out.print("+" + "i");
            }
        }
        System.out.println("");
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
        double temp;
        temp = (Math.pow(complex_number2.Re, 2) + Math.pow(complex_number2.Im, 2));
        result.Re = result.Re / temp;
        result.Im = result.Im / temp;
        result.printComplex();
    }

}

public class Complex {
    public static void main(String[] args) {

        ComplexNumber CN1 = new ComplexNumber();
        ComplexNumber CN2 = new ComplexNumber();

        ComplexOpration oprator = new ComplexOpration();

        ArrayList<String> commands = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        CN1.readComplex();
        CN2.readComplex();

        int Length = 0;
        String temp = "";
        do{

            temp = sc.nextLine();
            if((temp.compareTo("+") == 0 || temp.compareTo("-") == 0) || (temp.compareTo("*") == 0 || temp.compareTo("/") == 0)) {
                commands.add(temp);
                Length++;
            }
        }while (temp.compareTo("#") != 0);

        for (int i = 0; i < Length; i++){
            temp = commands.get(i);

            if(temp.compareTo("+") == 0){
                oprator.plus(CN1, CN2);
            }
            else if(temp.compareTo("-") == 0){
                oprator.minus(CN1, CN2);
            }
            else if(temp.compareTo("*") == 0){
                oprator.product(CN1, CN2);
            }
            else if(temp.compareTo("/") == 0){
                oprator.divide(CN1, CN2);
            }
        }

    }
}
