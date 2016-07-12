package com.company._04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberinReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        DecimalNumber decimalNumber = new DecimalNumber(num);
        System.out.println(decimalNumber.reverseNumber());
    }
}

class DecimalNumber{
    String numer;

    public DecimalNumber(String numer) {
        this.numer = numer;
    }

    public String reverseNumber(){
        return new StringBuilder(numer).reverse().toString();
    }
}
