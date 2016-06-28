package com.company;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long num = scanner.nextLong();
        ArrayDeque<Long> nums = new ArrayDeque<>();
        ArrayList<Long> all = new ArrayList<>();
        nums.add(num);
        all.add(num);
        while (all.size() <50){
            long n = nums.poll();
            long second = n + 1;
            long third = n * 2 + 1;
            long fourth = n + 2;
            nums.add(second);
            nums.add(third);
            nums.add(fourth);
            all.add(second);
            all.add(third);
            all.add(fourth);
        }

       all.stream().limit(50).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }
}
