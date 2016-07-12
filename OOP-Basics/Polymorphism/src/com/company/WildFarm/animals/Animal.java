package com.company.WildFarm.animals;

import com.company.WildFarm.food.Food;

public abstract class Animal {
    protected String name;
    protected double weight;
    protected int foodEaten;

    protected Animal(String name,double weight) {
        this.name = name;
        this.weight = weight;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);


}
