package com.company;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] word = scanner.nextLine().split("\\s+");
        System.out.println(sum(word[0],word[1]));
    }
    private static long sum(String one,String two){
        int lenght = 0;
        long sum=0;
        int biggest = 0;
        if (one.length() > two.length()){
            lenght = two.length();
            biggest = one.length();
        } else {
            lenght = one.length();
            biggest = two.length();
        }

        for (int i = 0; i < lenght ; i++) {
            sum += one.charAt(i) * two.charAt(i);
        }
        if (one.length() > two.length()){
            for (int i = lenght; i < biggest; i++) {
                sum += one.charAt(i);
            }
        } else if(two.length() > one.length()){
            for (int i = lenght; i < biggest; i++) {
                sum += two.charAt(i);
            }
        }
        return sum;


    }
}
