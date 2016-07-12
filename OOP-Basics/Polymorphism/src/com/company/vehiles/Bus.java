package com.company.vehiles;

public class Bus extends Vehiles {
    private double consumpWithotPeople;
    public Bus(double fualQuantity, double consumption, int tankCapacity) {
        super(fualQuantity, consumption, tankCapacity);
        this.consumpWithotPeople = consumption;
    }

    public void peopleInsite(){
        this.consumption += 1.4;
    }

    public void alone(){
        this.consumption = consumpWithotPeople;
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
