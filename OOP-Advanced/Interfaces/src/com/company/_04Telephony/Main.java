package com.company._04Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers= reader.readLine().split("\\s+");
        String[] sites = reader.readLine().split("\\s+");

        Smartphone phone = new SmartphoneImpl();
        phone.call(numbers);
        phone.browingWeb(sites);
    }
}
