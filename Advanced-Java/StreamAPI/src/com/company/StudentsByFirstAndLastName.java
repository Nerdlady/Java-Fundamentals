package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentsByFirstAndLastName {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String[]> studentsData = new ArrayList<>();
        String line = scan.nextLine();

        while (!line.equals("END")) {
            studentsData.add(line.split("\\s+"));
            line = scan.nextLine();
        }

        studentsData.stream()
                .filter(s -> s[0].compareTo(s[1]) < 0)
                .forEach(s -> System.out.printf("%s %s%n", s[0], s[1]));
    }
}
