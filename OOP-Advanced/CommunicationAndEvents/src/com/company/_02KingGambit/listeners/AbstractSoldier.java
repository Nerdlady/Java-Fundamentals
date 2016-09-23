package com.company._02KingGambit.listeners;

import com.company._02KingGambit.events.DeathEvent;
import com.company._02KingGambit.interfaces.DeathListener;
import com.company._02KingGambit.interfaces.Soldier;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSoldier implements Soldier{
    private String name;
    private List<DeathListener> deathListeners;
    private int hintsLeft;

    public AbstractSoldier(String name,int numberOfHints) {
        this.setName(name);
        this.setHintsLeft(numberOfHints);
        this.deathListeners = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setHintsLeft(int hintsLeft) {
        this.hintsLeft = hintsLeft;
    }

    @Override
    public void addDeathListener(DeathListener deathListener) {
        this.deathListeners.add(deathListener);
    }

    @Override
    public void revomeDeathListener(DeathListener deathListener) {
        this.deathListeners.remove(deathListener);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public void respondToAttack() {
        this.hintsLeft--;
        if (hintsLeft <= 0){
            this.fireDeathListeners();
        }
    }

    private  void fireDeathListeners(){
        DeathEvent event = new DeathEvent(this);
        for (DeathListener deathListener : deathListeners) {
            deathListener.handleSoldierDeath(event);
        }
    }
}
