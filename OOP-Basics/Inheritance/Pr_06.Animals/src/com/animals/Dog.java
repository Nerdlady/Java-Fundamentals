package com.animals;

import com.InvalidInputExaption;

public class Dog extends Animal {
    public Dog(String name, int age, String gender) throws InvalidInputExaption {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("BauBau");
    }
}
