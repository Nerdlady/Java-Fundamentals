package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class OfficeStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        TreeMap<String,LinkedHashMap<String,Integer>> data = new TreeMap<>();

        for (int n = 0; n < num; n++) {
            String[] line = scanner.nextLine().split("\\s+-\\s+");
            String company = line[0].substring(1,line[0].length());
            String product = line[2].substring(0,line[2].length() - 1);
            Integer amount = Integer.parseInt(line[1]);

            if (!data.containsKey(company)){
                data.put(company,new LinkedHashMap<>());
            }

            if (!data.get(company).containsKey(product)){
                data.get(company).put(product,0);
            }

            Integer total = data.get(company).get(product) + amount;
            data.get(company).put(product,total);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> company : data.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(company.getKey() + ": ");
            for (Map.Entry<String, Integer> product : company.getValue().entrySet()) {
                sb.append(product.getKey() + "-" + product.getValue() + ", ");
            }

            System.out.println(sb.substring(0,sb.length() -2));
        }
    }
}
