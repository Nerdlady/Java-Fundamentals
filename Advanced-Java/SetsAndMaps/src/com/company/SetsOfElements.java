package com.company;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> one = new HashSet<>();
        Set<Integer> two = new HashSet<>();
         int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            one.add(scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            two.add(scanner.nextInt());
        }

        for (Integer b : one) {
            if (two.contains(b)){
                System.out.printf(b +" ");
            }
        }

    }
}
