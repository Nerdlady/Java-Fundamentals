package com.company;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer lines = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (String s : input) {
                elements.add(s);
            }
        }

        for (String element : elements) {
            System.out.printf(element + " ");
        }
    }
}
