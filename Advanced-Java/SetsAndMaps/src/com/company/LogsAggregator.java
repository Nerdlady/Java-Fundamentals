package com.company;


import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedMap<String, Long> hoursData = new TreeMap<>();
        SortedMap<String, Set<String>> ipData = new TreeMap<>();

        Integer lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[1];
            String ip = info[0];
            Long hours = Long.parseLong(info[2]);
            if (!hoursData.containsKey(name)){
                hoursData.put(name,0l);
                ipData.put(name,new TreeSet<>());
            }
            if (!ipData.get(name).contains(ip)){
                ipData.get(name).add(ip);
            }

            hours += hoursData.get(name);
            hoursData.put(name,hours);
        }
        hoursData.entrySet().stream().forEach(a -> {
            System.out.printf("%s: %d %s%n",a.getKey(),a.getValue(),ipData.get(a.getKey()).toString());
        });
    }


}
