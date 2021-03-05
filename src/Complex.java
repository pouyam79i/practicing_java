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

    public void plus(ComplexNumber complex_number1, ComplexNumber complex_number2){
        ComplexNumber result = new ComplexNumber();
        result.Re = complex_number1.Re + complex_number1.Re;
        result.Im = complex_number1.Im + complex_number2.Im;
        System.out.print(result.Re);
        if(result.Im<0){
            System.out.println(result.Im + "i");
        }
        else{
            System.out.println("+" + result.Im + "i");
        }
    }

}

public class Complex {

}
