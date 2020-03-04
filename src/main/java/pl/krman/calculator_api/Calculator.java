package pl.krman.calculator_api;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public double add (double firstNumber, double secondNumber){
        return firstNumber + secondNumber;
    }

    public double subtract (double firstNumber, double secondNumber){
        return firstNumber - secondNumber;
    }

    public double multiply (double firstNumber, double secondNumber){
        return firstNumber * secondNumber;
    }

    public double divide (double firstNumber, double secondNumber) throws ArithmeticException {
        if (secondNumber == 0){
            throw new ArithmeticException();
        }
        return firstNumber / secondNumber;
    }
}
