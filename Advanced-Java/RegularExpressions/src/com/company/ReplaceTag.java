package com.company;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();
        while (true){
            String line =scanner.nextLine();
            if (line.equals("end")){
                break;
            }

            builder.append(line);
        }
        String result = builder.toString().replaceAll("<\\/a>", "[/URL]");
        result = result.replaceAll("<a\\s", "[URL ");

        System.out.println(result);
    }
}
