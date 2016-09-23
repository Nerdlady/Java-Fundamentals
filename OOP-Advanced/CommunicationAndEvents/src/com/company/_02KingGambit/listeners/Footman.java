package com.company._02KingGambit.listeners;

import com.company._02KingGambit.events.UnderAttackEvent;

public class Footman extends AbstractSoldier {
    private static final int NUMBER_OF_HINTS = 2;
    public Footman(String name) {
        super(name,NUMBER_OF_HINTS);
    }

    @Override
    public void handleAttack(UnderAttackEvent event) {
        System.out.printf("Footman %s is panicking!%n", this.getName());
    }
}
