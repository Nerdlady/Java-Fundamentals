package com.company._06StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> byName = new TreeSet<>(new NameComparator());
        TreeSet<Person> byAge = new TreeSet<>(new AgeComparator());

        int numberOfLines= Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            String[] params = reader.readLine().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            Person person = new PersonImpl(name,age);
            byAge.add(person);
            byName.add(person);
        }

        for (Person person : byName) {
            System.out.println(person.toString());
        }
        
        for (Person person : byAge) {
            System.out.println(person.toString());
        }
    }
}
