package com.company._01;

import java.lang.reflect.Field;

class Person {
    String name;
    int age;

}

public class Main {

    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}



