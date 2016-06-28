package com.company;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern rgx = Pattern.compile("(>>>----->>)|(>>----->)|(>----->)");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(" " +sc.nextLine());
        }
        Matcher matcher = rgx.matcher(sb.toString());
        int smallCount = 0;
        int mediumCount = 0;
        int largeCount = 0;
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                largeCount++;
            }
            else if (matcher.group(2) != null) {
                mediumCount++;
            }
            else {
                smallCount++;
            }
        }
        String concatenate =smallCount+""+mediumCount+""+largeCount;
        int num = Integer.parseInt(concatenate);
        String binary = Integer.toString(num, 2);
        String reversed = new StringBuilder(binary).reverse().toString();
        String all = binary + reversed;
        long result = Long.parseLong(all, 2);
        System.out.println(result);

    }
}
