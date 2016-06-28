package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String obName = "";
        TreeMap<String, Integer> map = new TreeMap<>();
        TreeMap<String, Integer> map2 = new TreeMap<>();
        map.put("shards", 0);
        map.put("fragments", 0);
        map.put("motes", 0);
        boolean isWin = false;

        while (!isWin) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            String[] params = line.split(" ");
            for (int i = 0; i < params.length; i += 2) {
                String name = params[i + 1].toLowerCase();
                if (map.containsKey(name)) {
                    int count = map.get(name) + Integer.parseInt(params[i]);
                    map.put(name, count);
                    if (map.get(name) >= 250) {
                        switch (name) {
                            case "shards":
                                obName = "Shadowmourne";
                                break;
                            case "fragments":
                                obName = "Valanyr";
                                break;
                            case "motes":
                                obName = "Dragonwrath";
                                break;
                        }
                        int c = map.get(name) - 250;
                        map.put(name, c);
                        isWin = true;
                        break;
                    }
                } else {
                    if (!map2.containsKey(name)) {
                        map2.put(name, 0);
                    }
                    int count = map2.get(name) + Integer.parseInt(params[i]);
                    map2.put(name, count);
                }

            }
        }
        System.out.println(obName + " obtained!");
        map.entrySet().stream().sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue())).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        map2.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));


    }
}
