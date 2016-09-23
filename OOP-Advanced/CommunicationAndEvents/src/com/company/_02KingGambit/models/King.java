package com.company._02KingGambit.models;

import com.company._02KingGambit.events.DeathEvent;
import com.company._02KingGambit.events.UnderAttackEvent;
import com.company._02KingGambit.interfaces.Attackable;
import com.company._02KingGambit.interfaces.DeathListener;
import com.company._02KingGambit.interfaces.UnderAttackListener;

import java.util.ArrayList;
import java.util.List;

public class King implements Attackable,DeathListener {
    private String name;
    private List<UnderAttackListener> listeners;

    public King(String name) {
        this.setName(name);
        this.listeners = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void addUnderAttackListener(UnderAttackListener underAttackListener){
        this.listeners.add(underAttackListener);
    }

    public void removeUnderAttackListener(UnderAttackListener underAttackListener){
        this.listeners.remove(underAttackListener);
    }

    @Override
    public void respondToAttack() {
        System.out.printf("King %s is under attack!%n",this.getName());
        this.fireUnderAttackListeners();
    }

    private void fireUnderAttackListeners(){
        UnderAttackEvent event = new UnderAttackEvent(this);
        for (UnderAttackListener listener : listeners) {
            listener.handleAttack(event);
        }
    }

    @Override
    public void handleSoldierDeath(DeathEvent event) {
        this.listeners.remove(event.getSource());
    }
}
