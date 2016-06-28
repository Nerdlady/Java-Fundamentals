package com.company;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        Integer[] numbers = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }

        while (true){
            String commnand = scanner.nextLine();
            if (commnand.equals("end")){
                break;
            }

            switch (commnand){
                case "add":
                   numbers = apply(numbers, n -> n +1);
                    System.out.println();
                    break;
                case "multiply":
                    numbers = apply(numbers, n -> n * 2);
                    break;
                case "subtract":
                    numbers =  apply(numbers, n-> n -1);
                    break;
                case "print":
                    applyC(numbers, n -> System.out.printf("%s ", n));
                    break;
            }
        }
    }

    private static Integer[] apply(Integer[] nums, Function<Integer,Integer> function){
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = function.apply(nums[i]);
        }
        return numbers;
    }

    public static void applyC(Integer[] nums, Consumer<Integer> printer) {
        for (Integer e : nums) {
            printer.accept(e);
        }
    }
}
