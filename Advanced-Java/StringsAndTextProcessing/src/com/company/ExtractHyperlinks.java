package com.company;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern regex = Pattern.compile("(?:<a)(?:[\\s\\n_0-9a-zA-Z=\"\"()]*?.*?)(?:href([\\s\\n]*)?=(?:['\"\"\\s\\n]*)?)([a-zA-Z:#\\/._\\-0-9!?=^+]*(\\([\"\"'a-zA-Z\\s.()0-9]*\\))?)(?:[\\s\\na-zA-Z=\"\"()0-9]*.*?)?(?:\\>)");

        StringBuilder input = new StringBuilder();
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            input.append(line);
            line = scanner.nextLine();
        }

        String text = input.toString();

        Matcher match = regex.matcher(text);
        while (match.find()) {


            if (!match.group(2).equals("fake")) {
                System.out.println(match.group(2));

            }


        }

    }

}

