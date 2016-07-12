package com.company.WildFarm.animals;

import com.company.WildFarm.food.Food;
import com.company.WildFarm.food.Meat;

public class Tiger extends Felime {
    public Tiger(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
   public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public  void eat(Food food) {
        if (!food.getClass().getSimpleName().equals(Meat.class.getSimpleName())){
            System.out.printf("%ss are not eating that type of food!%n",this.getClass().getSimpleName());
            return;
        }

        this.foodEaten += food.getQuantity();
    }
}
