package com.company.infernoInfinity.core;


import com.company.infernoInfinity.interfaces.DataWeapon;
import com.company.infernoInfinity.interfaces.Weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponData implements DataWeapon {
    Map<String,Weapon> weapons;

    public WeaponData() {
        this.weapons = new HashMap<>();
    }

    @Override
    public Weapon getWeaponByName(String name) {
        return this.weapons.get(name);
    }

    @Override
    public void addWeapon(String name, Weapon weapon) {
        this.weapons.put(name,weapon);
    }
}
