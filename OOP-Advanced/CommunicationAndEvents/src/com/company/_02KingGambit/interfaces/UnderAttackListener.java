package com.company._02KingGambit.interfaces;

import com.company._02KingGambit.events.UnderAttackEvent;

public interface UnderAttackListener {
    void handleAttack(UnderAttackEvent event);
}
