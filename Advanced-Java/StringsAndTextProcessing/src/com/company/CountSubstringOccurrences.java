package com.company;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().toLowerCase();
        String word = scanner.nextLine().toLowerCase();



        Pattern pattern = Pattern.compile(word);
        Matcher matcher =pattern.matcher(line);
        int count = 0;
        int pos = 0;
        while (matcher.find(pos)) {
            count++;
            pos = matcher.start() + 1;
        }
        System.out.println(count);
    }
}
