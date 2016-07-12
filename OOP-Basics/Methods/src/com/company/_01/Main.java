package com.company._01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Person.class.getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

        Person person = new Person(name);
        System.out.println(person.sayHello());
    }
}

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String sayHello(){
        return String.format("%s says \"Hello\"!",name);
    }
}
