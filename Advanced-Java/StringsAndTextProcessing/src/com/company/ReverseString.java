package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = scanner.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new StringBuilder(line).reverse().toString());
    }
}
