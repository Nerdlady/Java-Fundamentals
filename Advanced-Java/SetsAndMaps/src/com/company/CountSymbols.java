package com.company;


import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (Character character : line.toCharArray()) {
            if (!map.containsKey(character)){
                map.put(character,0);
            }
            int count = map.get(character) + 1;
            map.put(character,count);
        }

        map.entrySet().stream().forEach(a -> System.out.printf("%s: %d time/s%n", a.getKey(),a.getValue()));
    }
}
