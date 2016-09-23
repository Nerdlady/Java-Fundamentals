package com.company._08_Bonus_Skyrim.models;

import com.company._08_Bonus_Skyrim.events.AllWarriorsDeadEvent;
import com.company._08_Bonus_Skyrim.events.AttackAllWarriorsEvent;
import com.company._08_Bonus_Skyrim.events.DragonDeadEvent;
import com.company._08_Bonus_Skyrim.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class DragonImpl implements Dragon,AllWarriorsDeadListener {
    private String name;
    private int power;
    private int heathPoints;
    private String treasureWeapon;
    private int usedAttacks;
    private List<MakeAllWarriorsDamageListener> listeners;
    private List<DragonDiedListener> deadListeners;

    public DragonImpl(String name, int power, int heathPoints, String treasureWeapon) {
        this.setName(name);
        this.setPower(power);
        this.setHeathPoints(heathPoints);
        this.setTreasureWeapon(treasureWeapon);
        this.listeners = new ArrayList<>();
        this.deadListeners = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPower(int power) {
        this.power = power;
    }

    private void setHeathPoints(int heathPoints) {
        this.heathPoints = heathPoints;
    }

    private void setTreasureWeapon(String treasureWeapon) {
        this.treasureWeapon = treasureWeapon;
    }

    @Override
    public String getName() {
        return this.name;
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
    public String getTreasureWeapon() {
        return this.treasureWeapon;
    }

    @Override
    public void attackWarrior(Warrior warrior) {
        System.out.printf("%s attacked %s for %s damage%n",this.getName(),warrior.getName(),this.getPower());
        warrior.makeDamage(this.power);
        this.usedAttacks++;
        if (this.usedAttacks == 3){
            this.usedAttacks = 0;
            this.fireListeners();
        }
    }

    @Override
    public void makeDamage(int power) {
        this.heathPoints -= power;
        if (this.heathPoints <= 0){
            System.out.println(this.getName() + " died");
            this.fireDeadListeners();
        }
    }

    @Override
    public void addAttackListener(MakeAllWarriorsDamageListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeAttackListener(MakeAllWarriorsDamageListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void addDragonDeadListener(DragonDiedListener listener) {
        this.deadListeners.add(listener);
    }

    @Override
    public void removeDragonDeadListener(DragonDiedListener listener) {
        this.deadListeners.remove(listener);
    }

    @Override
    public boolean isAlive() {
        return this.heathPoints > 0;
    }

    @Override
    public String toString() {
        return String.format("%s %d",this.getName(),this.getHeathPoints());
    }

    private void fireListeners(){
        AttackAllWarriorsEvent event = new AttackAllWarriorsEvent(this);
        for (MakeAllWarriorsDamageListener listener : listeners) {
            listener.handleAttackAllWarriors(event);
        }
    }

    private void fireDeadListeners(){
        DragonDeadEvent event = new DragonDeadEvent(this);
        for (DragonDiedListener deadListener : deadListeners) {
            deadListener.handleDragonDied(event);
        }
    }

    @Override
    public void handleAllWarriorsDead(AllWarriorsDeadEvent event) {
        System.out.println(this.toString());
    }
}
