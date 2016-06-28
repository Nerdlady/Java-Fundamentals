package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("[\\s+\\/\\\\(\\\\)\\\\]");
        LinkedList<String> valids = new LinkedList<>();

        for (String str : line) {
            Pattern pattern = Pattern.compile("^[A-Za-z][\\w]{2,25}$");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                valids.add(str);
            }
        }

        int maxLenght = 0;
        int firstIndex = 0;

        for (int i = 0; i < valids.size() - 1; i++) {
            int sum = valids.get(i).length() + valids.get(i + 1).length();
            if (sum > maxLenght){
                maxLenght = sum;
                firstIndex = i;
            }
        }

        System.out.println(valids.get(firstIndex));
        System.out.println(valids.get(firstIndex + 1));


    }
}
