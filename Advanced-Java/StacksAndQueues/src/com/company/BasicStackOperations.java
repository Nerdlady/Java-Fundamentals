package com.company;

import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] demontions = scanner.nextLine().split("\\s+");
        int lenght = Integer.parseInt(demontions[0]);
        int toPop = Integer.parseInt(demontions[1]);
        int toCheck = Integer.parseInt(demontions[2]);
        
        String[] nums = scanner.nextLine().split("\\s+");
        Stack<Integer> numbers = new Stack<>();
        for (int n = 0; n < lenght; n++) {
            numbers.add(Integer.parseInt(nums[n]));
        }

        for (int i = 0; i < toPop; i++) {
            numbers.pop();
        }

        if (numbers.contains(toCheck)){
            System.out.println("true");
        } else {
            if (numbers.size() == 0){
                System.out.println(0);
                return;
            }
            int min = Integer.MAX_VALUE;
            for (Integer num: numbers) {
                if (num < min){
                    min = num;
                }
            }
            System.out.println(min);
        }
    }
}
