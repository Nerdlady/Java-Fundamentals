package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {
        String regex = "(?:(?<=\\s)|^)([a-z1-9]+[\\-\\._]?[a-z1-9]+)@(?:[a-z]+[\\-]?[a-z]+)(:?\\.[a-z]+[\\-]?[a-z]+){1,}";
        Pattern pattern = Pattern.compile(regex);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Matcher matcher =pattern.matcher(line);

        while (matcher.find()){

                System.out.println(matcher.group());


        }
    }
}
