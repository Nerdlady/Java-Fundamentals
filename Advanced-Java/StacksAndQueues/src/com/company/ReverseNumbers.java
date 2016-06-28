package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(Integer.parseInt(nums[i]));
        }

        for (int i = numbers.size(); i > 1; i--) {
            System.out.print(numbers.pop() + " ");
        }
        System.out.println(numbers.pop());
    }
}
