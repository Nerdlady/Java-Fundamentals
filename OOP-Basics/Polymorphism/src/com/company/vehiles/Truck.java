package com.company.vehiles;

public class Truck extends Vehiles {


    protected Truck(double fualQuantity, double consumption, int tankCapacity) {
        super(fualQuantity, consumption+ 1.6, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters *0.95);
    }

}
