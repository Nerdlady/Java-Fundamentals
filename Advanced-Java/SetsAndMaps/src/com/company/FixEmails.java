package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> map = new LinkedHashMap<>();

        while (true){
            String name = scanner.nextLine();
            if (name.equals("stop")){
                break;
            }

            String email = scanner.nextLine();

            if (email.toLowerCase().endsWith("uk") || email.toLowerCase().endsWith("us")){
                continue;
            }

            map.put(name,email);
        }

        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.printf("%s -> %s%n", stringStringEntry.getKey(),stringStringEntry.getValue());
        }
    }
}
