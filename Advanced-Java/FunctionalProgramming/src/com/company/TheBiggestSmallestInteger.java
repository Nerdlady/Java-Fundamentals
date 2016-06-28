package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class TheBiggestSmallestInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        String command = scanner.nextLine();

        Function<Integer[],Integer> min = new Function<Integer[], Integer>() {
            @Override
            public Integer apply(Integer[] integers) {
                Integer min = Integer.MAX_VALUE;

                for (Integer integer : integers) {
                    if (integer < min){
                        min = integer;
                    }
                }
                return min;
            }
        };

        Function<Integer[],Integer> max = new Function<Integer[], Integer>() {
            @Override
            public Integer apply(Integer[] integers) {
                Integer max = Integer.MIN_VALUE;

                for (Integer integer : integers) {
                    if (integer > max){
                        max = integer;
                    }
                }
                return max;
            }
        };

        TriFunctionI<Function<Integer[],Integer>,Integer[],Integer,Integer> triFunctionI = new TriFunctionI<Function<Integer[], Integer>, Integer[], Integer, Integer>() {
            @Override
            public Integer apply(Function<Integer[], Integer> integerFunction, Integer[] integers, Integer integer) {
                List<Integer> buffer = new ArrayList<>();

                for (Integer i : integers) {
                    if (Math.abs(i % 2) == integer) {
                        buffer.add(i);
                    }
                }


                if (buffer.size() > 0) {
                    Integer[] result = new Integer[buffer.size()];
                    result = buffer.toArray(result);
                    return integerFunction.apply(result);
                }

                return null;
            }
        };

        switch (command) {
            case "minEven":
                System.out.println(triFunctionI.apply(min, numbers, 0) == null ? "" : triFunctionI.apply(min, numbers, 0));
                break;
            case "maxEven":
                System.out.println(triFunctionI.apply(max, numbers, 0) == null ? "" : triFunctionI.apply(max, numbers, 0));
                break;
            case "minOdd":
                System.out.println(triFunctionI.apply(min, numbers, 1) == null ? "" : triFunctionI.apply(min, numbers, 1));
                break;
            case "maxOdd":
                System.out.println(triFunctionI.apply(max, numbers, 1) == null ? "" : triFunctionI.apply(min, numbers, 1));
                break;
        }
    }


    @FunctionalInterface
    interface TriFunctionI<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
