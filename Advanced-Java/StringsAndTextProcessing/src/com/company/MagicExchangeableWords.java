package com.company;


import java.util.HashMap;
import java.util.Scanner;

public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        System.out.println(areEquel(line[0], line[1]));


    }

    private static boolean areEquel(String a, String b) {

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        int length = 0;
        if (a.length() > b.length()) {
            length = b.length();
        } else {
            length = a.length();
        }

        for (int i = 0; i < length; i++) {
            char one = a.charAt(i);
            char two = b.charAt(i);
            if (!map.containsKey(one) && !map2.containsKey(two)) {
                map.put(one, two);
                map2.put(two, one);
            } else {
                if (map.containsKey(one)) {
                    if (!map.get(one).equals(two)) {
                        return false;

                    }

                }

                if (map2.containsKey(two)) {
                    if (!map2.get(two).equals(one)) {
                        return false;

                    }

                }

            }

        }
        if (a.length() > b.length()) {

            for (int i = b.length() -1; i < a.length(); i++) {
                char one = a.charAt(i);
                if (!map.containsKey(one)){
                    return false;
                }
            }
        } else if (b.length() > a.length()){
            for (int i = a.length()-1; i < b.length(); i++) {
                char one = b.charAt(i);
                if (!map2.containsKey(one)){
                    return false;
                }
            }
        }
        return true;
    }

}
