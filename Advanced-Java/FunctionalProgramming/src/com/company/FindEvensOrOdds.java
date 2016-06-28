package com.company;

import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] range = scanner.nextLine().split("\\s+");
        Integer start = Integer.parseInt(range[0]);
        Integer end = Integer.parseInt(range[1]);
        String command = scanner.nextLine();

        if (command.equals("odd")){
            findNums(start,end, n -> n % 2 !=0);
        } else {
            findNums(start,end, n -> n % 2 ==0);
        }


    }

    private static void findNums(Integer start,Integer end,Predicate<Integer> predicate){

        for (int i = start; i <= end; i++) {
            if (predicate.test(i)){
                System.out.printf("%s ",i);
            }
        }
    }
}
