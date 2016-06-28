package com.company;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();

        for (int i = 0; i < words.length; i++) {
            String replacement ="";
            for (int j = 0; j < words[i].length(); j++) {
                replacement += "*";
            }
            text =text.replaceAll(words[i],replacement);
        }
        System.out.println(text);

    }
}
