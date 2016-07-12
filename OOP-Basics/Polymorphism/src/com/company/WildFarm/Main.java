package com.company.WildFarm;

import com.company.WildFarm.animals.*;
import com.company.WildFarm.food.Food;
import com.company.WildFarm.food.Meat;
import com.company.WildFarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }

            String[] info = line.split("\\s+");
            Animal animal = createAnimal(info);
            String[] foodInfo = reader.readLine().split("\\s+");
            Food food  = createFood(foodInfo);
            animal.makeSound();
            animal.eat(food);
            System.out.println(animal.toString());


        }
    }

    private static Food createFood( String[] foodInfo) {
        switch (foodInfo[0]){
            case "Meat":
                return new Meat(Integer.parseInt(foodInfo[1]));
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodInfo[1]));
            default:
                return null;

        }
    }

    private static Animal createAnimal(String[] info) {
        String name = info[1];
        double weigh = Double.parseDouble(info[2]);
        String livingPlace = info[3];

        switch (info[0]){
            case "Mouse":
                return new Mouse(name,weigh,livingPlace);
            case "Zebra":
                return new Zebra(name,weigh,livingPlace);
            case "Cat":
                String breed = info[4];
                return new Cat(name,weigh,livingPlace,breed);
            case "Tiger":
                return new Tiger(name,weigh,livingPlace);
            default:
                return null;
        }

    }
}
