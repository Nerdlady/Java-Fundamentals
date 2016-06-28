package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String[]> studentsData = new ArrayList<>();
        while (true){

            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("END")){
                break;
            }
            studentsData.add(input);
        }

        studentsData.stream()
                .filter(s -> s[2].equals("2"))
                .sorted((s1, s2) -> s1[0].compareTo(s2[0]))
                .forEach(s -> System.out.printf("%s %s%n", s[0], s[1]));


    }
}
