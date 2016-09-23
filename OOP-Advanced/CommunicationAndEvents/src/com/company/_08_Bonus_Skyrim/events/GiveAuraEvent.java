package com.company._08_Bonus_Skyrim.events;

import com.company._08_Bonus_Skyrim.interfaces.Warrior;

import java.util.EventObject;

public class GiveAuraEvent extends EventObject {
   private Warrior warrior;
    public GiveAuraEvent(Warrior source) {
        super(source);
        this.warrior =  source;
    }

    public Warrior getWarrior(){
        return this.warrior;
    }
}
