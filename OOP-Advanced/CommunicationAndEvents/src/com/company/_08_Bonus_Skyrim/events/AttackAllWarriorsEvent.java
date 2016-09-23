package com.company._08_Bonus_Skyrim.events;

import com.company._08_Bonus_Skyrim.interfaces.Dragon;

import java.util.EventObject;

public class AttackAllWarriorsEvent extends EventObject {
    private Dragon dragon;
    public AttackAllWarriorsEvent(Dragon source) {
        super(source);
        this.dragon = source;
    }

    public int getDragonDamege() {
        return this.dragon.getPower();

    }

    public String getDragonName(){
        return this.dragon.getName();
    }
}
