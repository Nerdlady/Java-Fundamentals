package com.company;


import java.util.Scanner;

public class StringLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.length() >=20){
            System.out.println(line.substring(0,20));
        } else {
            int last = 20 - line.length() ;
            for (int i = 0; i < last; i++) {
                line += "*";
            }
            System.out.println(line);
        }
    }
}
