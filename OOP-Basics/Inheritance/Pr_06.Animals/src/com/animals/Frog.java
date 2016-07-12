package com.animals;

import com.InvalidInputExaption;

public class Frog extends Animal {
    public Frog(String name, int age, String gender) throws InvalidInputExaption {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Frogggg");
    }
}
