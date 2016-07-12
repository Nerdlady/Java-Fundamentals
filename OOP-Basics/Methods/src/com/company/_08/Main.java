package com.company._08;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split("\\s+");
        Car car = new Car(Double.parseDouble(info[1]), Double.parseDouble(info[0]), Double.parseDouble(info[2]));

        while (true) {
            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }
            String[] command = line.split("\\s+");
            switch (command[0]) {
                case "Travel":

                    car.travel(Double.parseDouble(command[1]));
                    break;
                case "Distance":
                    System.out.printf("Total distance: %.1f kilometers%n", car.getDistance());
                    break;
                case "Time":
                    System.out.printf("Total time: %s%n", car.time());
                    break;
                case "Fuel":
                    System.out.printf("Fuel left: %.1f liters%n", car.getFuel());
                    break;
                case "Refuel":
                    car.reFuel(Integer.parseInt(command[1]));
            }
        }
    }
}

class Car {
    private double fuel;
    private double speed;
    private double fuelPerKm;
    private double distance;
    private double fuelKm;


    public Car(double fuel, double speed, double fuelPerKm) {
        this.fuel = fuel;
        this.speed = speed;
        this.fuelPerKm = fuelPerKm;
        this.distance = 0;


    }

    void travel(double km) {
        double a = fuelPerKm / 100;
        double b = km / a;
        if (fuel < b){
          km = b;

        }

        this.distance += km;
        fuel -= fuelPerKm * (km / 100);
    }

    public void reFuel(int refuel) {
        this.fuel += refuel;
    }

    public double getFuel() {
        return fuel;
    }

    public double getDistance() {
        return distance;
    }

    public String time() {
        double time = distance / speed;
        String a = time + "";
        String[] timee = a.split("\\.");
        int hours = Integer.parseInt(timee[0]);
        int minutes = 0;
        if (timee.length > 1) {
            minutes = Integer.parseInt(timee[1]);
            while (minutes > 60){
                minutes -= 60;
                hours++;
            }
        }

        return String.format("%s hours and %s minutes", hours, minutes);
    }

}
