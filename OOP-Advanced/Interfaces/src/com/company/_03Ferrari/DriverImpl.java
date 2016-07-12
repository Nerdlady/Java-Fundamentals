package com.company._03Ferrari;

public class DriverImpl implements Driver {
    private String name;

    public DriverImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
