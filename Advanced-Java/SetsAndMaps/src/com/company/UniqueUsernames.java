package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> names = new LinkedHashSet<>();
        Integer lines = Integer.parseInt(scanner.nextLine());
        StringBuilder bilder = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            if (!names.contains(line)) {
                names.add(line);
            }
        }

        for (String name : names) {
           bilder.append(name).append("\n");
        }
        System.out.println(bilder.toString().trim());
    }
}
