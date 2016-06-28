package com.company;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StudentsByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,Integer> student = new LinkedHashMap<>();

        while (true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }
            String[] info = line.split("\\s+");

            String name = info[0] + " " + info[1];
            int age = Integer.parseInt(info[2]);
            student.put(name,age);
        }

        student.entrySet().stream()
                .filter(a -> a.getValue() <= 24 && a.getValue() >= 18)
                .forEach(a -> System.out.printf("%s %d%n",a.getKey(),a.getValue()));
    }
}
