package com.company.vehiles;

public abstract class Vehiles {
    protected double consumption;

    protected double fualQuantity;
    protected int tankCapacity;

    protected Vehiles(double fualQuantity, double consumption,int tankCapacity) {

        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
        setFualQuantity(fualQuantity);
    }

    public void setFualQuantity(double fualQuantity) {
        if (fualQuantity < 0){
           throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fualQuantity = fualQuantity;
    }

    public boolean isFuelEnought(double distanceTravel){
        if (this.fualQuantity / this.consumption>=distanceTravel ){
            return true;
        }
        return false;
    }

    public void driveDistance(double distnce){

        this.fualQuantity -= distnce*this.consumption;
    }

    public void refuel(double liters){
       this.fualQuantity += liters;
    }



    public double getFualQuantity() {
        return fualQuantity;
    }
}
