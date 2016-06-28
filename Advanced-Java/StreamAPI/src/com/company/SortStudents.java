package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class SortStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String[]> names = new LinkedList<>();

        while (true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }

            String[] name = line.split("\\s+");
            names.add(new String[]{name[0],name[1]});
        }

        names.stream().sorted((a,b) ->{
            String first = a[1];
            String second = b[1];
            int result = first.compareTo(second);
            if (result == 0){
                first = a[0];
                second = b[0];
                result = second.compareTo(first);
            }
            return result;
        }).forEach(a -> System.out.println(a[0] + " " + a[1]));
    }
}
