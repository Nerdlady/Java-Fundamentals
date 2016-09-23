package com.company.infernoInfinity.core;

import com.company.infernoInfinity.enums.WeaponType;
import com.company.infernoInfinity.interfaces.Weapon;
import com.company.infernoInfinity.interfaces.WeaponCreator;
import com.company.infernoInfinity.models.WeaponImpl;

public class WeaponCreatorImpl implements WeaponCreator{

    public WeaponCreatorImpl() {
    }

    @Override
    public Weapon createWeapon(String type,String name) {
        WeaponType weaponType = Enum.valueOf(WeaponType.class, type);
        Weapon weapon = new WeaponImpl(name, weaponType);
        return weapon;
    }
}
