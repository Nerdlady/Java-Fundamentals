package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer nums = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");
        names(names,n -> n <= nums);

    }

    private static void names(String[] names, Predicate<Integer> predicate){

        for (String name : names) {
            if (predicate.test(name.length())){
                System.out.println(name);
            }
        }

    }
}
