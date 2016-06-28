package com.company;

import java.util.Scanner;

/**
 * Created by Nerd_lady on 06-Jun-16.
 */
public class KnightsofHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        java.util.function.Consumer<String> people = name -> System.out.println("Sir " +name);
        for (String name : names) {
            people.accept(name);
        }
    }
}
