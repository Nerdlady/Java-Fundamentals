package com.company;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WeakStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,ArrayList<Integer>> student = new LinkedHashMap<>();

        while (true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }

            String[] name = line.split("\\s+");
            ArrayList<Integer> grades = new ArrayList<>();
            for (int i = 2; i < name.length; i++) {
                grades.add(Integer.parseInt(name[i]));
            }
            student.put(name[0]+" " +name[1],grades);
        }

        student.entrySet().stream().filter(a -> {
            int count = 0;
            for (int i = 0; i < a.getValue().size(); i++) {
                if (a.getValue().get(i) <= 3){
                    count++;
                }
            }

            if (count >= 2){
                return true;
            }
            return false;
        }).forEach(a -> System.out.println(a.getKey()));


    }
}
