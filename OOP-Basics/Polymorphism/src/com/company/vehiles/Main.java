package com.company.vehiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Car car;
    static Truck truck;
    static Bus bus;
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        String[] truckInfo = reader.readLine().split("\\s+");
        String[] busInfo = reader.readLine().split("\\s+");
         car = new Car(Double.parseDouble(carInfo[1]),Double.parseDouble(carInfo[2]),Integer.parseInt(carInfo[3]));
        truck = new Truck(Double.parseDouble(truckInfo[1]),Double.parseDouble(truckInfo[2]),Integer.parseInt(truckInfo[3]));

        bus = new Bus(Double.parseDouble(busInfo[1]),Double.parseDouble(busInfo[2]),Integer.parseInt(busInfo[3]));
        bus.peopleInsite();
        int numberaOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberaOfLines; i++) {
            String[] command = reader.readLine().split("\\s+");
            try{
                switch (command[0]){
                    case "Drive":
                        driveVehiles(command);
                        break;
                    case "Refuel":
                        refuelVehiles(command);
                        break;
                    case "DriveEmpty":
                        driveEmpty(command);


                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        System.out.printf("Car: %.2f%n",car.getFualQuantity());
        System.out.printf("Truck: %.2f%n",truck.getFualQuantity());
        System.out.printf("Bus: %.2f%n",bus.getFualQuantity());
    }

    private static void driveEmpty(String[] command) {
        switch (command[1]){
            case "Bus":
                bus.alone();
                double distance3 = Double.parseDouble(command[2]);
                String sss = command[2].indexOf(".") < 0 ?  command[2] :  command[2].replaceAll("0*$", "").replaceAll("\\.$", "");
                if (bus.isFuelEnought(distance3)){
                    bus.driveDistance(distance3);

                    System.out.printf("Bus travelled %s km%n",sss);
                } else {
                    System.out.println("Bus needs refueling");
                }
                bus.peopleInsite();
                break;
        }
    }

    private static void refuelVehiles(String[] command) {

        switch (command[1]){

            case "Car":
                double fuel = Double.parseDouble(command[2]);
                car.refuel(fuel);
                break;
            case "Truck":
                double fuel2 = Double.parseDouble(command[2]);
                truck.refuel(fuel2);
             break;
            case "Bus":
                double fuel3 = Double.parseDouble(command[2]);
                bus.refuel(fuel3);
        }
    }

    private static void driveVehiles(String[] command) {
        switch (command[1]){
            case "Car":
                double distance = Double.parseDouble(command[2]);
                String s = command[2].indexOf(".") < 0 ?  command[2] :  command[2].replaceAll("0*$", "").replaceAll("\\.$", "");
                if (car.isFuelEnought(distance)){
                    car.driveDistance(distance);

                    System.out.printf("Car travelled %s km%n",s);
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                String ss = command[2].indexOf(".") < 0 ?  command[2] :  command[2].replaceAll("0*$", "").replaceAll("\\.$", "");
                double distance2 = Double.parseDouble(command[2]);
                if (truck.isFuelEnought(distance2)){
                    truck.driveDistance(distance2);
                    System.out.printf("Truck travelled %s km%n",ss);
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
            case "Bus":
                double distance3 = Double.parseDouble(command[2]);
                String sss = command[2].indexOf(".") < 0 ?  command[2] :  command[2].replaceAll("0*$", "").replaceAll("\\.$", "");
                if (bus.isFuelEnought(distance3)){
                    bus.driveDistance(distance3);

                    System.out.printf("Bus travelled %s km%n",sss);
                } else {
                    System.out.println("Bus needs refueling");
                }
                break;
        }
    }
}
