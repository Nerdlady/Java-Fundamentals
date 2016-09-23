package com.company._02KingGambit.interfaces;

public interface Soldier extends Attackable,UnderAttackListener {
    String getName();
    void addDeathListener(DeathListener deathListener);
    void revomeDeathListener(DeathListener deathListener);
}
