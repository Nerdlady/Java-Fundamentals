package com.company._05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SpeedRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int carCount = Integer.parseInt(reader.readLine());
        LinkedHashMap<String,Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < carCount; i++) {
            String[] info = reader.readLine().split("\\s+");
            cars.put(info[0],new Car(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2])));
        }

        while (true){
            String line = reader.readLine();
            if ( line.equals("End")){
                break;
            }

            String[] info = line.split("\\s+");
            String model = info[1];
            double km = Double.parseDouble(info[2]);
            boolean can =cars.get(model).drive(km);
            if (!can){
                System.out.println("Insufficient fuel for the drive");
            }
        }

        for (Map.Entry<String, Car> carEntry : cars.entrySet()) {
            System.out.printf("%s %.2f %.0f%n",carEntry.getValue().model,carEntry.getValue().fuelmount,carEntry.getValue().distance);
        }
    }
}

class Car {
    String model;
    double fuelmount;
    double fuelCostFor1km;
    double distance;


    public Car(String model, double fuelmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelmount = fuelmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distance = 0;

    }

    public boolean drive(double km){
        double money = km * fuelCostFor1km;
        if ( money <=fuelmount ){
           fuelmount -= money;
            this.distance += km;
            return true;
        }
        return false;
    }
}