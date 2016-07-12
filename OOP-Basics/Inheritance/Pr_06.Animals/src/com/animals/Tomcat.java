package com.animals;

import com.InvalidInputExaption;

public class Tomcat extends Cat {
    public Tomcat(String name, int age) throws InvalidInputExaption {
        super(name, age, "Male");
    }

    @Override
    public void produceSound() {
        System.out.println("Give me one million b***h");
    }
}
