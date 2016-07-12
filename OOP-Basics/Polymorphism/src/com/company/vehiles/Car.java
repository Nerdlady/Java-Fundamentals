package com.company.vehiles;

public class Car extends Vehiles {

    public Car(double fualQuantity, double consumption, int tankCapacity) {
        super(fualQuantity, consumption +0.9, tankCapacity);
    }

    @Override
    public void setFualQuantity(double fualQuantity) {
        if (fualQuantity > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFualQuantity(fualQuantity);
    }

    @Override
    public void refuel(double liters) {
        if (liters > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.refuel(liters);
    }
}
