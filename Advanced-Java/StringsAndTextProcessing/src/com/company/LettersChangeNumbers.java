package com.company;


import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input =scanner.nextLine().split("\\s+");

        double result = 0;
        for(String combination : input)
        {
            char left = combination.toCharArray()[0];
            char right = combination.toCharArray()[combination.length()-1];
            double number = Double.parseDouble(combination.substring(1, combination.length() - 1));

            number = applyFirstLetterCalculations(left, number);

            number = applySecondLetterCalculations(right, number);

            result += number;
        }
        System.out.printf("%.2f%n",result);

    }

    private static double applySecondLetterCalculations(char lastLetter, double number)
    {
        if (Character.isUpperCase(lastLetter))
        {
            number -= lastLetter - 'A' + 1;
        }
        else if (Character.isLowerCase(lastLetter))
        {
            number += lastLetter - 'a' + 1;
        }
        return number;
    }

    private static double applyFirstLetterCalculations(char firstLetter, double number)
    {
        if (Character.isUpperCase(firstLetter))
        {
            number /= firstLetter - 'A' + 1;
        }
        else if (Character.isLowerCase(firstLetter))
        {
            number *= firstLetter - 'a' + 1;
        }
        return number;
    }
}


