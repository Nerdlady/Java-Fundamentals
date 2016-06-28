package com.company;


        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Problem01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // LinkedHashMap<String, LinkedList<Integer>> bunkers = new LinkedHashMap<>();
        LinkedList<Long> bunkers = new LinkedList<>();
        LinkedList<String> names = new LinkedList<>();

        long capacity = Long.parseLong(reader.readLine());
        long currentCapacity = 0;
        while (true) {
            String line = reader.readLine();
            if (line.equals("Bunker Revision")) {
                break;
            }

            String[] info = line.split("\\s+");

            for (String current : info) {
                if (Character.isLetter(current.charAt(0))) {

                    names.add(current);
                } else {
                    if (names.size() > 0) {
                        long currentGivenNum = Long.parseLong(current);

                        int count = 0;
                        while (count < names.size()) {


                            if (currentCapacity + currentGivenNum <= capacity) {
                                bunkers.add(currentGivenNum);
                                currentCapacity += currentGivenNum;
                                break;
                            } else if (names.size() > 1) {

                                print(bunkers, names.poll());

                                currentCapacity = 0;
                                bunkers.clear();
                            } else if (names.size() == 1) {
                                if (capacity >= currentGivenNum) {
                                    while (true) {

                                        if (bunkers.size() >0 ){
                                            currentCapacity -= bunkers.pop();
                                        }

                                        if (currentCapacity + currentGivenNum <= capacity) {
                                            bunkers.add(currentGivenNum);
                                            currentCapacity += currentGivenNum;
                                            break;
                                        }

                                    }


                                }
                                break;

                            }


                            count++;
                        }

                    }
                }


            }

        }


    }

    private static void print(LinkedList<Long> bunker, String name) {
        StringBuilder builder = new StringBuilder();
        String toPrint = "";
        if (bunker.size() > 0) {
            for (Long weapon : bunker) {
                builder.append(weapon).append(", ");

                toPrint = builder.substring(0, builder.length() - 2);
            }
        } else {
            builder.append("Empty");
            toPrint = builder.toString();
        }

        System.out.printf("%s -> %s%n", name, toPrint);
    }

    private static Long sumCurrentCapacity(LinkedList<Long> bunkers) {
        long currentCapacity = 0L;
        for (Long bunker : bunkers) {
            currentCapacity += bunker;
        }
        return currentCapacity;
    }
}