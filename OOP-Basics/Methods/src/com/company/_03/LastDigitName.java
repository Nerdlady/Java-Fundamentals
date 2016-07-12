package com.company._03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        Number number = new Number(num);
        System.out.println(number.lastDigiName());
    }
}

class Number {
    String anInt;

    public Number(String anInt) {
        this.anInt = anInt;
    }

    public String lastDigiName() {
        int last = anInt.length() - 1;
        int num = Integer.parseInt(anInt.charAt(last) + "");
        switch (num) {
            case 0:
                return "zero";

            case 1:
                return "one";

            case 2:
                return "two";

            case 3:
                return "three";

            case 4:
                return "four";

            case 5:
                return "five";

            case 6:
                return "six";

            case 7:
                return "seven";

            case 8:
                return "eight";

            case 9:
                return "nine";

            default:
                return "";
        }
    }
}
