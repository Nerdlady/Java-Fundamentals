package com.company;

import java.util.*;

public class HandsOfCards {


    static ArrayList<Character> powers = new ArrayList<Character>() {{
        add('2');
        add('3');
        add('4');
        add('5');
        add('6');
        add('7');
        add('8');
        add('9');
        add('1');
        add('J');
        add('Q');
        add('K');
        add('A');
    }};
    static ArrayList<Character> suits = new ArrayList<Character>() {{
        add('C');
        add('D');
        add('H');
        add('S');
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> map = new LinkedHashMap<>();
        Map<String,Set<String>> cardsHave= new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("JOKER")) {
                break;
            }
            String[] info = line.split(":");

            if (!map.containsKey(info[0])) {
                map.put(info[0], 0L);
                cardsHave.put(info[0], new HashSet<>());
            }

            String[] cards = info[1].split(", ");
           // Set<String> sumedCards = new HashSet<>();
            Long sum = 0L;

            for (String card : cards) {
                if (!cardsHave.get(info[0]).contains(card.trim())) {
                    sum += getPower(card.trim());
                    cardsHave.get(info[0]).add(card.trim());
                }
            }

            Long sumAll = map.get(info[0]) + sum;
            map.put(info[0], sumAll);
        }

        for (Map.Entry<String, Long> stringLongEntry : map.entrySet()) {
            System.out.printf("%s: %d%n", stringLongEntry.getKey(), stringLongEntry.getValue());
        }

    }

    static Integer getPower(String card) {
        char[] one = card.toCharArray();
        char suit = one[1];
        int sum = 0;

        sum += powers.indexOf(one[0]) + 2;
        if (sum == 10) {
            suit = one[2];
        }
        sum *= suits.indexOf(suit) + 1;

        return sum;

    }
}
