package com.company._02KingGambit.interfaces;

import com.company._02KingGambit.events.DeathEvent;

public interface DeathListener {
    void handleSoldierDeath(DeathEvent event);
}
