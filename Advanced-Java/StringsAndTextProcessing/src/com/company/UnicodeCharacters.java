package com.company;

import java.nio.charset.Charset;
import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String output = "";
        for (int i = 0; i < line.length(); i++) {
           output += unicodeEscaped(line.charAt(i));
        }
        System.out.println(output);

    }

    public static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }
}
