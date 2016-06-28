package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TriFunction {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int targetAscii = Integer.valueOf(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        BiFunction<String, Integer, Boolean> checkForAscii = new BiFunction<String, Integer, Boolean>() {
            @Override
            public Boolean apply(String s, Integer integer) {
                int totalSum = 0;

                for (int i = 0; i < s.length(); i++) {
                    totalSum += s.charAt(i);
                }

                if (totalSum >= integer) {
                    return true;
                }

                return false;
            }
        };


        TriFunctionI<Integer, BiFunction<String, Integer, Boolean>, List<String>, String> findFirstOccurency = new TriFunctionI<Integer, BiFunction<String, Integer, Boolean>, List<String>, String>() {
            @Override
            public String apply(Integer integer, BiFunction<String, Integer, Boolean> biFunction, List<String> strings) {

                for (String name : strings) {
                    if (biFunction.apply(name, integer)) {
                        return name;
                    }
                }

                return "";

            }
        };


        String result = findFirstOccurency.apply(targetAscii, checkForAscii, names);
        System.out.println(result);
    }
}


@FunctionalInterface
interface TriFunctionI<A, B, C, R> {

    R apply(A a, B b, C c);
}