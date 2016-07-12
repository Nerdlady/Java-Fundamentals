package com.animals;

import com.InvalidInputExaption;

public class Cat extends Animal {
    public Cat(String name, int age, String gender) throws InvalidInputExaption {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("MiauMiau");
    }
}
