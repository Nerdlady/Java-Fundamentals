package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        // BigInteger a = new BigInteger(line[0]);
        double b = Double.parseDouble(line[1]);
        double c = Double.parseDouble(line[2]);

        String aH = new BigInteger(line[0]).toString(16);
        String aB = new BigInteger(line[0]).toString(2);

        if (aB.length() < 10) {
            int toAdd = 10 - aB.length();
            for (int i = 0; i < toAdd; i++) {
                aB = "0" + aB;
            }
        } else if (aB.length() > 10){
            aB = aB.substring(0, 10);
        }

        System.out.printf("|%-10s", aH.toUpperCase());
        System.out.printf("|%s|", aB);
        System.out.printf("%10.2f|", b);
        System.out.printf("%-10.3f|", c);

    }
}
