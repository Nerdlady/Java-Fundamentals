package com.company._02KingGambit.listeners;

import com.company._02KingGambit.events.UnderAttackEvent;

public class RoyalGuard extends AbstractSoldier {
    private static final int NUMBER_OF_HINTS = 3;
    public RoyalGuard(String name) {
        super(name,NUMBER_OF_HINTS);
    }

    @Override
    public void handleAttack(UnderAttackEvent event) {
        System.out.printf("Royal Guard %s is defending!%n",this.getName());
    }
}
