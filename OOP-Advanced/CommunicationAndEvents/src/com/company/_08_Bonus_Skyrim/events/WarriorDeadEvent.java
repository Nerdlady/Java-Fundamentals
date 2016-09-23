package com.company._08_Bonus_Skyrim.events;

import com.company._08_Bonus_Skyrim.interfaces.Warrior;

import java.util.EventObject;

public class WarriorDeadEvent extends EventObject {

    public WarriorDeadEvent(Warrior source) {
        super(source);
    }
}
