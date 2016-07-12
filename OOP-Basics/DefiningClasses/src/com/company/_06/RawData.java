package com.company._06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Car> cars = new LinkedList<>();
        int lines = Integer.parseInt(reader.readLine());
        for (int l = 0; l < lines; l++) {
            String[] info = reader.readLine().split("\\s+");
            String model = info[0];
            int speed = Integer.parseInt(info[1]);
            int power = Integer.parseInt(info[2]);
            int wight = Integer.parseInt(info[3]);
            String type= info[4];
            Car car = new Car(model,new Engine(speed,power),new Cargo(wight,type));
            int age1 = Integer.parseInt(info[6]);
            double pressure1 = Double.parseDouble(info[5]);
            int age2 = Integer.parseInt(info[8]);
            double pressure2 = Double.parseDouble(info[7]);
            int age3 = Integer.parseInt(info[10]);
            double pressure3 = Double.parseDouble(info[9]);
            int age4 = Integer.parseInt(info[12]);
            double pressure4 = Double.parseDouble(info[11]);
            car.addTire(new Tire(age1,pressure1));
            car.addTire(new Tire(age2,pressure2));
            car.addTire(new Tire(age3,pressure3));
            car.addTire(new Tire(age4,pressure4));

            cars.add(car);

        }

        String command = reader.readLine();

        switch (command){
            case "fragile":
                cars.stream().filter(a -> a.cargo.type.equals("fragile")).filter(a -> {
                    for (Tire tire : a.tires) {
                        if (tire.pressure < 1){
                            return true;
                        }
                    }
                    return false;
                }).forEach(a -> System.out.println(a.model));
                break;
            case "flamable":
                cars.stream().filter(a -> a.cargo.type.equals("flamable")).filter(a -> a.engine.power > 250).forEach(a -> System.out.println(a.model));
                break;
        }
    }
}

class Car{
    String model;
    Engine engine;
    Cargo cargo;
    Tire[] tires;
    private int index;

    public Car(String model, Engine engine, Cargo cargo) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new Tire[4];
        this.index = 0;
    }

    public void addTire(Tire tire){
        tires[index] = tire;
        index++;
    }
}

class Engine{
    int speed;
    int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }
}

class Cargo{
    int wight;
    String type;

    public Cargo(int wight, String type) {
        this.wight = wight;
        this.type = type;
    }
}

class Tire{
    double pressure;
    int age;

    public Tire(int age, double pressure) {
        this.age = age;
        this.pressure = pressure;
    }
}