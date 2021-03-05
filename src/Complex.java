/*
Coded by Pouya Mohamadi
Uni ID: 9829039
tel ID: @pouya_moh
 */

class ComplexNumber{
    public double Re;
    public double Im;
}

class ComplexOpration{

    private ComplexNumber result = new ComplexNumber();

    private void printComplex(ComplexNumber complex_number){
        System.out.print(complex_number.Re);
        if(complex_number.Im<0){
            System.out.println(complex_number.Im + "i");
        }
        else{
            System.out.println("+" + complex_number.Im + "i");
        }
    }

    public void plus(ComplexNumber complex_number1, ComplexNumber complex_number2){
        result.Re = complex_number1.Re + complex_number2.Re;
        result.Im = complex_number1.Im + complex_number2.Im;
        printComplex(result);
    }

    public void minus(ComplexNumber complex_number1, ComplexNumber complex_number2){
        result.Re = complex_number1.Re - complex_number2.Re;
        result.Im = complex_number1.Im - complex_number2.Im;
        printComplex(result);
    }

}

public class Complex {

}
