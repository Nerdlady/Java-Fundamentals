package com.company;


import java.util.*;
import java.util.function.Predicate;

public class PredicateParty {
    public static List<String> people = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] invited = scanner.nextLine().split("\\s+");
        for (String s : invited) {
            people.add(s);
        }

        while (true){
            String commnant = scanner.nextLine();
            if (commnant.equals("Party!")){
                break;
            }

            String[] commants = commnant.split("\\s+");
            switch (commants[0]){
                case "Double":
                    switch (commants[1]){
                        case "StartsWith":
                            doublePerson(a -> a.startsWith(commants[2]));
                            break;
                        case "EndsWith":
                            doublePerson(a -> a.endsWith(commants[2]));
                            break;
                        case "Length":
                            doublePerson(a -> a.length() == Integer.parseInt(commants[2]));
                            break;
                    }
                    break;
                case "Remove":
                    switch (commants[1]){
                        case "StartsWith":
                            removePerson(a -> a.startsWith(commants[2]));
                            break;
                        case "EndsWith":
                            removePerson(a -> a.endsWith(commants[2]));
                            break;
                        case "Length":
                            removePerson(a -> a.length() == Integer.parseInt(commants[2]));
                            break;
                    }
                    break;
            }
        }

        if (people.size() > 0){
            for (int i = 0; i < people.size(); i++) {
                if ( i < people.size() - 1){
                    System.out.printf("%s, ", people.get(i));
                } else {
                    System.out.printf("%s ", people.get(i));
                }
            }
            System.out.println("are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static void doublePerson(Predicate<String> predicate){
        ArrayList<String> toAdd = new ArrayList<>();

        for (String s : people) {
            if (predicate.test(s)){
                toAdd.add(s);
            }
            toAdd.add(s);
        }
        people = toAdd;
    }

    private static void removePerson(Predicate<String> predicate){

        for (int i = people.size() - 1; i >=0; i--) {
            if (predicate.test(people.get(i))){
                people.remove(people.get(i));
            }
        }

    }
}
