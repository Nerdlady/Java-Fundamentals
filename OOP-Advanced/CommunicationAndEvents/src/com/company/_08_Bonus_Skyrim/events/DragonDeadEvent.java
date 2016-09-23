package com.company._08_Bonus_Skyrim.events;

import com.company._08_Bonus_Skyrim.interfaces.Dragon;

import java.util.EventObject;

public class DragonDeadEvent extends EventObject {
   private Dragon dragon;

    public DragonDeadEvent(Dragon source) {
        super(source);
        this.dragon = source;

    }

    public String getTreasureWeaponName(){
        return this.dragon.getTreasureWeapon();
    }

    public String getDragonName(){
        return this.dragon.getName();
    }
}
