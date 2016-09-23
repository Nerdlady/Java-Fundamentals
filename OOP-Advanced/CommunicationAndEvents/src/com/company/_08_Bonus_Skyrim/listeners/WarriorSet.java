package com.company._08_Bonus_Skyrim.listeners;

import com.company._08_Bonus_Skyrim.events.*;
import com.company._08_Bonus_Skyrim.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WarriorSet extends TreeSet<Warrior> implements MakeAllWarriorsDamageListener, GivePowerListener, DragonDiedListener, WarriorDiedListener {
    private List<AllWarriorsDeadListener> listeners;

    public WarriorSet() {
        this.listeners = new ArrayList<>();
    }

    public void addAllWarriorsDeadListener(AllWarriorsDeadListener listener){
        this.listeners.add(listener);
    }

    public void removeAllWarriorsDeadListener(AllWarriorsDeadListener listener){
        this.listeners.remove(listener);
    }
    @Override
    public void handleAttackAllWarriors(AttackAllWarriorsEvent events) {
        for (Warrior warrior : this) {
            System.out.printf("%s attacked %s for %s damage", events.getDragonName(), warrior.getName(), events.getDragonDamege());
            warrior.makeDamage(events.getDragonDamege());
        }
    }

    @Override
    public void handleGivePower(GiveAuraEvent event) {
        Warrior warrior = event.getWarrior();
        int numberOfPoints = warrior.getExperience() / 10;
        for (Warrior warriorToGivePoints : this) {
            if (warrior.compareTo(warriorToGivePoints) != 0) {
                warriorToGivePoints.givePower(numberOfPoints);
            }
        }
    }

    @Override
    public void handleDragonDied(DragonDeadEvent event) {
        for (Warrior warrior : this) {
            warrior.giveTreasureWeapon(event.getTreasureWeaponName());
            System.out.printf("%s received %s from %s%n", warrior.getName(), warrior.getTreasureWeapon(), event.getDragonName());
        }

        for (Warrior warrior : this) {
            System.out.println(warrior.toString());
        }
    }

    @Override
    public void handleWarriorDead(WarriorDeadEvent event) {
        this.remove(event.getSource());
        if (this.size() > 0){
            GiveAuraEvent event1 = new GiveAuraEvent(this.first());
            this.handleGivePower(event1);
        } else {
            this.fireListeners();
        }
    }

    private void fireListeners(){
        AllWarriorsDeadEvent event = new AllWarriorsDeadEvent(this);
        for (AllWarriorsDeadListener listener : listeners) {
            listener.handleAllWarriorsDead(event);
        }
    }
}
