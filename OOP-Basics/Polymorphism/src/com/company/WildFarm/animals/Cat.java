package com.company.WildFarm.animals;

import com.company.WildFarm.food.Food;

public class Cat extends Felime {
    private String breed;
    public Cat(String name,  double weight, String livingRegion,String breed) {
        super(name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        StringBuilder num = new StringBuilder();
        num.append("").append(this.weight).append("");
        if (num.toString().endsWith(".0")){
            num =num.delete(num.length() -2,num.length());
        }
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName())
                .append("[").append(this.name).append(", ").append(this.breed)
                .append(", ").append(num)
                .append(", ").append(this.livingRegion)
                .append(", ").append(this.foodEaten).append("]");
        return builder.toString();
    }
}
