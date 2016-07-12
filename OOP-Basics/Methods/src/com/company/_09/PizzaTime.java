package com.company._09;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PizzaTime {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pizzas = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();


        Map<Integer,List<String>> pizzaDataa =pizzaData(pizzas.split("\\s+"));
        pizzaDataa.entrySet().stream().forEach(a -> {
            System.out.printf("%d - %s%n",a.getKey(),String.join(", ",a.getValue()));
        });


    }

    public static Map<Integer,List<String>> pizzaData(String... args){
        Map<Integer,List<String>> all = new HashMap<>();
        List<Pizza> pizzas = new LinkedList<>();
        Pattern pattern = Pattern.compile("\\d+");
        for (String arg : args) {
            Matcher matcher = pattern.matcher(arg);

            if (matcher.find()){
                int num = Integer.parseInt(matcher.group());
                String name = arg.replaceFirst("\\d+", "");
                if (!all.containsKey(num)){
                    all.put(num,new LinkedList<>());
                }
                all.get(num).add(name);
                pizzas.add(new Pizza(num,name));
            }

        }
        return all;
    }
}

class Pizza{
    int group;
    String name;

    public Pizza(int group, String name) {
        this.group = group;
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
}