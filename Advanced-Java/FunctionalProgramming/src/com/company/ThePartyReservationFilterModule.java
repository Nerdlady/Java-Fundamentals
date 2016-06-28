package com.company;

import java.util.*;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {
    public static List<String> people = new ArrayList<>();

    private  static HashMap<String,HashMap<String,Predicate>> data= new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] invited = scanner.nextLine().split("\\s+");
        for (String s : invited) {
            people.add(s);
        }
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Print")) {
                break;
            }

            String[] commands = line.split(";");
            String command = commands[0];
            String modifier = commands[1];
            String variable = commands[2];

            Predicate<String> filter = createPredicate(modifier, variable);
            if (command.equals("Add filter")) {
                if (!data.containsKey(modifier)) {
                    data.put(modifier, new HashMap<>());
                }

                data.get(modifier).put(variable, filter);
            } else if (command.equals("Remove filter")) {
                if (data.containsKey(modifier)) {
                    if (data.get(modifier).containsKey(variable)) {
                        data.get(modifier).remove(variable);
                    }
                }
            }


        }

        filter();

        for (String s : people) {
            System.out.printf("%s ", s);
        }
    }

    private static Predicate<String> createPredicate(String command, String variable) {
        Predicate<String> toReturn;
        switch (command) {
            case "Starts with":
                toReturn = a -> a.startsWith(variable);
                break;
            case "Ends with":
                toReturn = a -> a.endsWith(variable);
                break;
            case "Length":
                toReturn = a -> a.length() == Integer.parseInt(variable);
                break;
            case "Contains":
                toReturn = a -> a.contains(variable);
                break;
            default:
                toReturn=null;
        }
        return toReturn;
    }

    private static void filter() {
        List<String> result = new ArrayList<>();
        for (String currentString : people) {
            boolean filtered = false;
            for (Map.Entry<String, HashMap<String, Predicate>> entry : data.entrySet()) {
                for (Map.Entry<String, Predicate> innerEntry : entry.getValue().entrySet()) {
                    Predicate<String> filter = innerEntry.getValue();
                    if (filter.test(currentString)) {
                        filtered = true;
                        break;
                    }
                }
            }

            if (!filtered) {
                result.add(currentString);
            }
        }

        people = result;
    }


}
