package com.company._10Mood3;

public class Archangel extends Character<Integer> {

    public Archangel(String name, String password, int level, Integer points) {
        super(name, password, level, points);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator()).append(String.format("%d",this.getPoints() * this.getLevel()));
        return builder.toString();
    }
}
