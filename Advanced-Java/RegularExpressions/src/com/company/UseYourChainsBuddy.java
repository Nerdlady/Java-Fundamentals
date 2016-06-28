package com.company;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChainsBuddy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String html = scanner.nextLine();
        Pattern tags = Pattern.compile("<p>(.*?)<\\/p>");

        Matcher matcher = tags.matcher(html);
        StringBuilder output = new StringBuilder();

        while (matcher.find()){
            String line = matcher.group(1);
            line = line.replaceAll("[^a-z0-9]", " ");
            line = line.replaceAll("\\s+", " ");
            char[] chars = line.toCharArray();
            for (int i = 0; i <chars.length; i++) {
                if (line.charAt(i) >= 'a' && line.charAt(i) <= 'm'){
                    int num = line.charAt(i) + 13;
                    chars[i] = (char) num;
                } else if (line.charAt(i) >= 'n' && line.charAt(i) <= 'z') {
                    int num = line.charAt(i) - 13;
                    chars[i] = (char) num;
                }
            }

            for (char aChar : chars) {
                output.append(aChar);
            }
        }

        System.out.println(output.toString());


    }
}
