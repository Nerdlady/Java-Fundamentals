package com.company._07;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesOne = Integer.parseInt(reader.readLine());
        LinkedList<Car> cars = new LinkedList<>();
        HashMap<String,Engine> engines = new HashMap<>();
        for (int i = 0; i < linesOne; i++) {
            String[] info = reader.readLine().split("\\s+");
            String model = info[0];
            double power= Double.parseDouble(info[1]);
            int displacement  = -1;
            String efficiency = "n/a";
            if (info.length ==3){
                try {
                    displacement = Integer.parseInt(info[2]);
                }catch (Exception e){
                    efficiency = info[2];
                }
            }

            if (info.length == 4){
                displacement = Integer.parseInt(info[2]);
                efficiency = info[3];
            }
            engines.put(model,new Engine(model,power,displacement,efficiency));

        }

        int linesTwo = Integer.parseInt(reader.readLine());
        for (int i = 0; i < linesTwo; i++) {
            String[] info = reader.readLine().split("\\s+");
            String model = info[0];
            String engineName = info[1];
            int weight  = -1;
            String color = "n/a";
            if (info.length ==3){
                try {
                    weight = Integer.parseInt(info[2]);
                }catch (Exception e){
                    color = info[2];
                }
            }

            if (info.length == 4){
                weight = Integer.parseInt(info[2]);
                color   = info[3];
            }
            Engine engine = engines.get(engineName);
            cars.add(new Car(model,engine,weight,color));

        }
        StringBuilder builder = new StringBuilder();
        for (Car car : cars) {
            builder.append(String.format("%s:%n",car.model));
            builder.append(String.format("  %s:%n",car.engine.model));
            builder.append(String.format("    Power: %.0f%n",car.engine.power));
            builder.append(String.format("    Displacement: %s%n",(car.engine.displacement > -1 ? car.engine.displacement : "n/a")));
            builder.append(String.format("    Efficiency: %s%n",car.engine.efficiency));
            builder.append("  Weight: " + (car.wioght > -1 ? car.wioght : "n/a")).append(System.lineSeparator());
            builder.append(String.format("  Color: %s%n",car.colar));
        }
        System.out.println(builder.toString());
    }


}

class Car{
    String model;
    int wioght;
    String colar;


    Engine engine;

    public Car(String model, Engine engine, int wioght, String colar) {
        this.model = model;
        this.wioght = wioght;
        this.colar = colar;
        this.engine = engine;
    }



    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }
}

class Engine{
    String model;
    double power;
    int displacement;
    String efficiency;

    public Engine(String model, double power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, double power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }




}
