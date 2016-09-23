package com.company._03DependencyInversionSkeleton;

import com.company._03DependencyInversionSkeleton.interfaces.CalculatorStrategy;
import com.company._03DependencyInversionSkeleton.strategies.AdditionStrategy;
import com.company._03DependencyInversionSkeleton.strategies.DividingStrategy;
import com.company._03DependencyInversionSkeleton.strategies.MultiplyingStrategy;
import com.company._03DependencyInversionSkeleton.strategies.SubtractionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrimitiveCalculator calculator = new PrimitiveCalculator();
        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }

            String[] params = line.split("\\s+");
            if (params[0].equals("mode")){
                switch (params[1]){
                    case "+":
                        CalculatorStrategy additionStrategy = new AdditionStrategy();
                        calculator.changeStrategy(additionStrategy);
                        break;
                    case  "-":
                        CalculatorStrategy subtractionStrategy = new SubtractionStrategy();
                        calculator.changeStrategy(subtractionStrategy);
                        break;
                    case "*" :
                        CalculatorStrategy multiplyingStrategu = new MultiplyingStrategy();
                        calculator.changeStrategy(multiplyingStrategu);
                        break;
                    case "/":
                        CalculatorStrategy dividingStrategy = new DividingStrategy();
                        calculator.changeStrategy(dividingStrategy);
                }
            } else {
                int firstNumber = Integer.parseInt(params[0]);
                int secondNumber = Integer.parseInt(params[1]);
                System.out.println(calculator.performCalculation(firstNumber,secondNumber));
            }
        }
    }
}
