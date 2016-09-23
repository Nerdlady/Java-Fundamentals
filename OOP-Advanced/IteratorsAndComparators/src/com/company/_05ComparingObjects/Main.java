package com.company._05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new LinkedList<>();
        while (true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }

            String[] params = line.split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            String town = params[2];
            Person person = new PersonImpl(name,age,town);
            people.add(person);
        }

        int numberOfPerson = Integer.parseInt(reader.readLine());
        int match = 0;
        if (numberOfPerson >= people.size()){
            System.out.println("No matches");
            return;
        }
        Person current = people.get(numberOfPerson);

        for (Person person : people) {
            if (current.compareTo(person) == 0){
                match++;
            }
        }

        int mismatch = people.size() - match;
        System.out.printf("%d %d %d",match,mismatch,people.size());
    }
}
