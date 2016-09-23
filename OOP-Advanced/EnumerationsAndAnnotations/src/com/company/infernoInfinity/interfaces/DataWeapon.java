package com.company.infernoInfinity.interfaces;

public interface DataWeapon {
    Weapon getWeaponByName(String name);
    void addWeapon(String name, Weapon weapon);
}
