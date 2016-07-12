package com.company._10Mood3;

public class Demon extends Character<Double> {

    public Demon(String name, String password, int level, Double points) {
        super(name, password, level, points);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator()).append(String.format("%.1f",this.getPoints() * this.getLevel()));
        return builder.toString();
    }
}
