package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> messages = new LinkedList<>();

        while (true) {
            String lin = reader.readLine();
            if (lin.equals("Over!")) {
                break;
            }

            Integer num = Integer.parseInt(reader.readLine());
            Pattern pattern = Pattern.compile(String.format("^(\\d+)([a-zA-Z]{%d})", num));
            Matcher matcher = pattern.matcher(lin);
            if (matcher.find()) {
                String message = matcher.group(2);
                lin = lin.substring(lin.indexOf(message) + num);
                Pattern pattern1 = Pattern.compile("[a-zA-Z]");
                Matcher matcher1 = pattern1.matcher(lin);
                if (matcher1.find()) {
                    continue;

                } else {
                    String numbers = matcher.group(1);
                    System.out.printf("%s == ",message);

                    for (int i = 0; i < numbers.length(); i++) {
                        String charr = numbers.charAt(i) + "";
                        int index = Integer.parseInt(charr);
                        if (index >= message.length()) {
                            System.out.printf(" ");
                        } else {
                            System.out.print(message.charAt(index));
                        }
                    }

                    for (int i = 0; i < lin.length(); i++) {
                        if (Character.isDigit(lin.charAt(i))) {
                            String charr = lin.charAt(i) + "";
                            int index = Integer.parseInt(charr);
                            if (index >= message.length()) {
                                System.out.printf(" ");
                            } else {
                                System.out.print(message.charAt(index));
                            }
                        }
                    }

                    System.out.println();
                }
            }
        }


    }

}
