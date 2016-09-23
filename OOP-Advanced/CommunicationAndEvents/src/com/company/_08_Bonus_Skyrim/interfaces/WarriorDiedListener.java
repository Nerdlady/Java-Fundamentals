package com.company._08_Bonus_Skyrim.interfaces;

import com.company._08_Bonus_Skyrim.events.WarriorDeadEvent;

public interface WarriorDiedListener {
    void handleWarriorDead(WarriorDeadEvent event);
}
