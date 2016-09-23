package com.company._08_Bonus_Skyrim.interfaces;

public interface Dragon extends AllWarriorsDeadListener {
    String getName();
    int getPower();
    int getHeathPoints();
    String getTreasureWeapon();
    void attackWarrior(Warrior warrior);
    void makeDamage(int power);
    void addAttackListener(MakeAllWarriorsDamageListener listener);
    void removeAttackListener(MakeAllWarriorsDamageListener listener);
    void addDragonDeadListener(DragonDiedListener listener);
    void removeDragonDeadListener(DragonDiedListener listener);
    boolean isAlive();
}
