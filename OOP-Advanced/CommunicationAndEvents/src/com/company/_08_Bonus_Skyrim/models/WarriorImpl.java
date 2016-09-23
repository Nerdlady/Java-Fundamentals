package com.company._08_Bonus_Skyrim.models;

import com.company._08_Bonus_Skyrim.events.WarriorDeadEvent;
import com.company._08_Bonus_Skyrim.interfaces.Dragon;
import com.company._08_Bonus_Skyrim.interfaces.Warrior;
import com.company._08_Bonus_Skyrim.interfaces.WarriorDiedListener;

import java.util.ArrayList;
import java.util.List;

public class WarriorImpl implements Warrior {
    private String name;
    private int experiance;
    private int power;
    private int heathPoints;
    private String treasureWeapon;
    private List<WarriorDiedListener> listeners;

    public WarriorImpl(String name, int experiance, int power, int heathPoints) {
        this.setName(name);
        this.setExperiance(experiance);
        this.setPower(power);
        this.setHeathPoints(heathPoints);
        this.listeners = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setExperiance(int experiance) {
        this.experiance = experiance;
    }

    private void setPower(int power) {
        this.power = power;
    }

    private void setHeathPoints(int heathPoints) {
        this.heathPoints = heathPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getExperience() {
        return this.experiance;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public int getHeathPoints() {
        return this.heathPoints;
    }

    @Override
    public void makeDamage(int power) {
        this.heathPoints -= power;
        if (this.heathPoints <= 0){
            System.out.println(this.getName() + " died");
            this.fireListeners();
        }
    }

    @Override
    public void attackDragon(Dragon dragon) {
        System.out.printf("%s attacked %s for %s damage%n",this.getName(),dragon.getName(),this.getPower());
        dragon.makeDamage(this.power);
    }

    @Override
    public void givePower(int pointsOfPower) {
        this.power += pointsOfPower;
    }

    @Override
    public void giveTreasureWeapon(String name) {
        this.treasureWeapon = name;
    }

    @Override
    public String getTreasureWeapon() {
        return this.treasureWeapon;
    }

    @Override
    public void addWarriorDeadListener(WarriorDiedListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeWarriorDeadListener(WarriorDiedListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public int compareTo(Warrior o) {
        int result =Integer.compare(o.getExperience(),this.getExperience());
        if (result == 0){
            result = Integer.compare(o.getPower(),this.getPower());
        }
        if (result == 0){
            result = o.getName().compareTo(this.getName());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d",this.getName(),this.getExperience(),this.getPower(),this.getHeathPoints());
    }

    private void fireListeners(){
        WarriorDeadEvent event = new WarriorDeadEvent(this);
        for (WarriorDiedListener listener : listeners) {
            listener.handleWarriorDead(event);
        }
    }
}
