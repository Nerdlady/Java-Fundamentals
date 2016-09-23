package com.company._08_Bonus_Skyrim.interfaces;

public interface Warrior extends Comparable<Warrior>{
    String getName();
    int getExperience();
    int getPower();
    int getHeathPoints();
    void makeDamage(int power);
    void attackDragon(Dragon dragon);
    void givePower(int pointsOfPower);
    void giveTreasureWeapon(String name);
    String getTreasureWeapon();
    void addWarriorDeadListener(WarriorDiedListener listener);
    void removeWarriorDeadListener(WarriorDiedListener listener);

}
