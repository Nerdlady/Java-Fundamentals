package com.company;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StudentsEnrolledIn2014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,String> student = new LinkedHashMap<>();

        while (true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }
            String[] info = line.split("\\s+");
            String marks =  "";
            for (int i = 1; i < info.length; i++) {
                marks += info[i] + " ";
            }
            student.put(info[0],marks);

        }

        student.entrySet().stream()
                .filter(a -> a.getKey().endsWith("14") || a.getKey().endsWith("15"))
                .forEach(a -> System.out.println(a.getValue()));
    }
}
