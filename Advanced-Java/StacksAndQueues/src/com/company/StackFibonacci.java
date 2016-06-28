package com.company;

import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.Stack;

public class StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long num = scanner.nextLong();
        Stack<Long> fibonacci = new Stack<>();
        fibonacci.add(0L);
        fibonacci.add(1L);
        for (int i = 0; i < num ; i++) {
            long poped = fibonacci.pop();
           long sum =poped + fibonacci.pop();
            fibonacci.add(poped);
            fibonacci.add(sum);
        }

        System.out.println(fibonacci.pop());
    }
}
