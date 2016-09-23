package com.company._03DependencyInversionSkeleton.strategies;

import com.company._03DependencyInversionSkeleton.interfaces.CalculatorStrategy;

public class MultiplyingStrategy implements CalculatorStrategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
