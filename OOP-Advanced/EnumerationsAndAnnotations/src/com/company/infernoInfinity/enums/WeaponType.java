package com.company.infernoInfinity.enums;

public enum WeaponType {
    AXE(5,10,4),
    SWORD(4,6,3),
    KNIFE(3,4,2);

    private int minDamage;
    private int maxDamage;
    private int numberOfStats;

    WeaponType(int minDamage, int maxDamage, int numberOfStats) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numberOfStats = numberOfStats;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getNumberOfStats() {
        return numberOfStats;
    }
}
