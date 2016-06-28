package com.company;


import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] demontions = scanner.nextLine().split("\\s+");
        int lenght = Integer.parseInt(demontions[0]);
        int toPop = Integer.parseInt(demontions[1]);
        int toCheck = Integer.parseInt(demontions[2]);

        String[] nums = scanner.nextLine().split("\\s+");
        Queue<Integer> numbers = new ConcurrentLinkedQueue<>();
        for (int n = 0; n < lenght; n++) {
            numbers.add(Integer.parseInt(nums[n]));
        }

        for (int i = 0; i < toPop; i++) {
            numbers.poll();
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
