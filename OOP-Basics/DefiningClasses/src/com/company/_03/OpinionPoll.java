package com.company._03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class OpinionPoll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Person> people = new LinkedList<>();

        int  lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] person = reader.readLine().split("\\s+");
            people.add(new Person(person[0], Integer.parseInt(person[1])));
        }

        people.stream().filter(a-> a.age > 30).sorted((a,b) -> a.name.compareTo(b.name)).forEach(a -> System.out.printf("%s - %d%n",a.name,a.age));
    }
}

class Person {
    String name;
    int age;

    public  Person(){
        this.name = "No name";
        this.age = 1;
    }

    public  Person(int age){
        this.name = "No name";
        this.age = age;
    }

    public  Person(String name,int age){
        this.name = name;
        this.age =age;
    }
}