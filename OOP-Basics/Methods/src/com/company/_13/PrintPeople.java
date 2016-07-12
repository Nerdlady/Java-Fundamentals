package com.company._13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class PrintPeople {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Person> people = new LinkedList<>();
        while (true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }

            String[] info = line.split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            String ccupation = info[2];
            people.add(new Person(name,ccupation,age));

        }

        people.stream().sorted((a,b) -> Integer.compare(a.age,b.age)).forEach(System.out::println);
    }
}

class Person{
    String name;
    int age;
    String occupation;

    public Person(String name, String occupation, int age) {
        this.name = name;
        this.occupation = occupation;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s",this.name,this.age,this.occupation);
    }
}
