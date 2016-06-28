package com.company;


import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.length() == 0){
            return;
        }
        int[] nums = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> smallest = new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] ints) {
                Integer smallest = Integer.MAX_VALUE;
                int index = 0;

                for (int i = 0; i < ints.length; i++) {
                    if (ints[i] <= smallest){
                        smallest = ints[i];
                        index = i;
                    }
                }
                return index;
            }
        };

        System.out.println( smallest.apply(nums));
    }


}
