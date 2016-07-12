package com.animals;

import com.InvalidInputExaption;

public class Kitten extends Cat {
    public Kitten(String name, int age) throws InvalidInputExaption {
        super(name, age, "Female");
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }
}
