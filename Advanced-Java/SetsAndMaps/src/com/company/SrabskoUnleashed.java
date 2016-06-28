package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nerd_lady on 18-May-16.
 */
public class SrabskoUnleashed {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        Pattern rgx = Pattern.compile("(\\D+)\\s@(\\D+)\\s(\\d+)\\s(\\d+)");

        HashMap<String, HashMap<String, Integer>> eventsInfo = new LinkedHashMap<>();


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")){
                break;
            }
            Matcher match = rgx.matcher(input);
            if (match.find()) {
                String singer = match.group(1).trim();
                String town = match.group(2).trim();
                Integer ticketPrice = Integer.parseInt(match.group(3));
                Integer ticketsCount = Integer.parseInt(match.group(4));

                if (!eventsInfo.containsKey(town)) {
                    eventsInfo.put(town, new LinkedHashMap<>());

                }
                if (!eventsInfo.get(town).containsKey(singer)) {
                    eventsInfo.get(town).put(singer, 0);

                }

                int price = ticketPrice * ticketsCount + (eventsInfo.get(town).get(singer));

                eventsInfo.get(town).put(singer, price);
            }
        }

        for (Map.Entry<String, HashMap<String, Integer>> stringHashMapEntry : eventsInfo.entrySet()) {
            System.out.println(stringHashMapEntry.getKey());
            stringHashMapEntry.getValue().entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).forEach(a -> System.out.printf("#  %s -> %d%n", a.getKey(), a.getValue()));
        }

    }
}
