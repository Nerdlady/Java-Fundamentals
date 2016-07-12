package com.company._02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

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

public class CreatingConstructors {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age =  Integer.parseInt(reader.readLine());

        Person one = new Person();
        Person two = new Person(age);
        Person three = new Person(name,age);

        System.out.printf("%s %d%n",one.name,one.age);
        System.out.printf("%s %d%n",two.name,two.age);
        System.out.printf("%s %d%n",three.name,three.age);
    }
}



