package com.company;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        String two = scanner.nextLine();

        BigDecimal out = new BigDecimal(one).add(new BigDecimal(two));
        System.out.println(sum(one, two));
    }

    private static String sum(String one, String two) {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        StringBuilder builder = new StringBuilder();


        if (one.length() > two.length()) {
            for (int i = two.length(); i < one.length(); i++) {
                two = "0" + two;
            }
        }
        if (one.length() < two.length()) {
            for (int i = one.length(); i < two.length(); i++) {
                one = "0" + one;
            }
        }
        char[] charOne = one.toCharArray();
        char[] charTwo = two.toCharArray();

        for (int i = 0; i < charOne.length; i++) {
            first.add(Character.getNumericValue(charOne[i]));
            second.add(Character.getNumericValue(charTwo[i]));
        }

        int remainder = 0;

        while (first.size() != 0) {

            int sum = first.pop() + second.pop();
            sum += remainder;
            if (sum > 9 && first.size() != 0) {
                remainder = sum / 10;
                sum %= 10;
            } else {
                remainder = 0;
            }
            if (first.size() == 0) {
                StringBuilder b = new StringBuilder();
                b.append(sum);
                b.reverse();
                builder.append(b);
            } else {
                builder.append(sum);
            }


        }
        builder.reverse();
        while (builder.toString().startsWith("0")) {
            builder = builder.delete(0, 1);
        }
        return builder.toString();
    }
}
