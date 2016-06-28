package com.company;


import java.io.BufferedReader;
import java.io.Reader;
import java.util.Scanner;

public class Consumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        java.util.function.Consumer<String> people = name -> System.out.println(name);
        for (String name : names) {
            people.accept(name);
        }
    }

}
