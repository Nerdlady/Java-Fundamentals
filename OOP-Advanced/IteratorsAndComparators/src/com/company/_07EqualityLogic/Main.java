package com.company._07EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> peopleSet = new TreeSet<>();
        HashSet<Person> peopleHash = new HashSet<>();

        int numberOfLines= Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            String[] params = reader.readLine().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
           Person person = new PersonImpl(name,age);
            peopleSet.add(person);
            peopleHash.add(person);
        }

        System.out.println(peopleSet.size());
        System.out.println(peopleHash.size());
    }
}
