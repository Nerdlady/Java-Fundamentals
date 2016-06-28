package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Long> map = new LinkedHashMap<>();
        try {
            while (true){


                String resource = scanner.nextLine();
                String quantity = " ";
                if (resource.equals("stop")){
                    break;
                }
                quantity = scanner.nextLine();



                if (!map.containsKey(resource)){
                    map.put(resource,0l);
                }

                long num = map.get(resource) + Long.parseLong(quantity);
                map.put(resource,num);
            }

            for ( Map.Entry<String,Long> s : map.entrySet()) {
                System.out.printf("%s -> %d%n", s.getKey(),s.getValue());
            }
       } catch (Exception e){

       }

    }
}