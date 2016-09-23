package com.company.infernoInfinity;

import com.company.infernoInfinity.core.WeaponCreatorImpl;
import com.company.infernoInfinity.core.WeaponData;
import com.company.infernoInfinity.core.WeaponEngine;
import com.company.infernoInfinity.interfaces.*;
import com.company.infernoInfinity.io.ConsoleReader;
import com.company.infernoInfinity.io.ConsoleWritter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataWeapon dataWeapon = new WeaponData();
        Reader reader = new ConsoleReader();
        Writter writter = new ConsoleWritter();
        WeaponCreator weaponCreator = new WeaponCreatorImpl();
        Engine engine = new WeaponEngine(weaponCreator,dataWeapon,reader,writter);
        engine.run();
    }
}
