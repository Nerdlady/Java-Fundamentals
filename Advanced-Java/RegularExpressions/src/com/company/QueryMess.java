package com.company;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,LinkedList<String>> data = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(.*)=(.*)");
        while (true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }

            line = line.replaceAll("\\+", " ");
            line = line.replaceAll("%20"," ");
            line = line.replaceAll("\\s+"," ");

            String[] info = line.split("[\\?&]+");

            for (String str : info) {
                Matcher matcher = pattern.matcher(str);
                while (matcher.find()){
                    String key = matcher.group(1).trim();
                    String value = matcher.group(2).trim();

                    if (!data.containsKey(key)){
                        data.put(key, new LinkedList<>());
                    }

                    data.get(key).add(value);
                }
            }

            for (Map.Entry<String, LinkedList<String>> key : data.entrySet()) {
                System.out.printf("%s=%s", key.getKey(),key.getValue());
            }
            System.out.println();
            data.clear();
        }


    }
}
