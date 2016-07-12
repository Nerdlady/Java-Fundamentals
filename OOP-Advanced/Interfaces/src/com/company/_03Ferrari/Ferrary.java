package com.company._03Ferrari;

public class Ferrary implements Car {
    private String model;
    private Driver driver;

    public Ferrary(String model, Driver driver) {
        this.model = model;
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public Driver getDriver() {
        return this.driver;
    }
}
