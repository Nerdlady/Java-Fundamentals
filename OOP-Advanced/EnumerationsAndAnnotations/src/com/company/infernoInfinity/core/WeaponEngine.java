package com.company.infernoInfinity.core;

import com.company.infernoInfinity.annotations.CustomAnnotation;
import com.company.infernoInfinity.enums.Stat;
import com.company.infernoInfinity.interfaces.*;

public class WeaponEngine implements Engine {
    private WeaponCreator weaponCreator;
    private DataWeapon dataWeapon;
    private Reader reader;
    private Writter writter;

    public WeaponEngine(WeaponCreator weaponCreator, DataWeapon dataWeapon, Reader reader, Writter writter) {
        this.weaponCreator = weaponCreator;
        this.dataWeapon = dataWeapon;
        this.reader = reader;
        this.writter = writter;
    }

    @Override
    public void run() {
        while (true) {
            String line = this.reader.readLine();
            if (line.equals("END")) {
                break;
            }

            String[] params = line.split(";");
            String command = params[0];
            switch (command) {
                case "Create":
                    this.createWeapon(params[1], params[2]);
                    break;
                case "Add":
                    this.addStatToWeapon(params[1], Integer.parseInt(params[2]), params[3]);
                    break;
                case "Remove":
                    this.removeStatFromWeapon(params[1], Integer.parseInt(params[2]));
                    break;
                case "Print":
                    this.printWeaponInfo(params[1]);
                    break;
                case "Compare":
                    this.printCompare(params[1],params[2]);
                    break;
                case "Author":
                case "Revision":
                case "Description":
                case "Reviewers":
                    this.printAnnotation(command);
                    break;
            }
        }

    }

    private void printAnnotation(String type) {
        Class<Weapon> weaponClass = Weapon.class;
        CustomAnnotation weaponAnnotation = weaponClass.getAnnotation(CustomAnnotation.class);
        switch (type) {
            case "Author":
                this.writter.writeOnNewLine("Author: " + weaponAnnotation.author());
                break;
            case "Revision":
                this.writter.writeOnNewLine("Revision: " + weaponAnnotation.revision());
                break;
            case "Description":
                this.writter.writeOnNewLine("Class description: " + weaponAnnotation.description());
                break;
            case "Reviewers": {
                this.writter.writeOnNewLine("Reviewers: " + String.join(", ", weaponAnnotation.reviewers()));
                break;
            }
        }

    }

    private void printCompare(String firstWeaponName, String secondWeaponName) {
        Weapon first = this.dataWeapon.getWeaponByName(firstWeaponName);
        Weapon second = this.dataWeapon.getWeaponByName(secondWeaponName);
        if (first.compareTo(second) > 0) {
            this.writter.writeOnNewLine(first.toString() + String.format(" (Item Level: %.1f)", first.getItemLeve()));
        } else {
            this.writter.writeOnNewLine(second.toString() + String.format(" (Item Level: %.1f)", second.getItemLeve()));
        }
    }

    private void printWeaponInfo(String weaponName) {
        Weapon current = this.dataWeapon.getWeaponByName(weaponName);
        this.writter.writeOnNewLine(current.toString());
    }

    private void removeStatFromWeapon(String weaponName, int indexToRemove) {
        Weapon current = this.dataWeapon.getWeaponByName(weaponName);
        try {
            current.removeAtIndex(indexToRemove);
            this.dataWeapon.addWeapon(weaponName, current);
        } catch (IndexOutOfBoundsException e) {

        }
    }

    private void addStatToWeapon(String weaponName, int index, String statType) {
        Stat stat = Enum.valueOf(Stat.class, statType);
        Weapon currentWeapon = this.dataWeapon.getWeaponByName(weaponName);
        try {
            currentWeapon.addStatAtIndex(stat, index);
            this.dataWeapon.addWeapon(weaponName, currentWeapon);
        } catch (IndexOutOfBoundsException e) {
        }
    }


    private void createWeapon(String type, String name) {
        Weapon weapon = this.weaponCreator.createWeapon(type, name);
        this.dataWeapon.addWeapon(name, weapon);
    }
}
