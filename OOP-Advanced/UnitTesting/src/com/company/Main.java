package com.company;

import com.company._02PeopleDatabase.Person;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person[] persons = new Person[2];
        persons[0] = new Person("Ivan",1234);
        System.out.println(Arrays.toString(persons));
    }
}
