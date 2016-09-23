package com.company._03DependencyInversionSkeleton;


import com.company._03DependencyInversionSkeleton.interfaces.CalculatorStrategy;
import com.company._03DependencyInversionSkeleton.strategies.AdditionStrategy;

public class PrimitiveCalculator {

    private boolean isAddition;
    private CalculatorStrategy strategy;

    public PrimitiveCalculator(){
       this.strategy = new AdditionStrategy();
    }

    public void changeStrategy(CalculatorStrategy strategy){
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand,int secondOperand){
       return this.strategy.calculate(firstOperand,secondOperand);
    }
}
