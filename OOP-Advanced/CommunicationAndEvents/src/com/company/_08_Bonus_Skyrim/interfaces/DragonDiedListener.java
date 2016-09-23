package com.company._08_Bonus_Skyrim.interfaces;

import com.company._08_Bonus_Skyrim.events.DragonDeadEvent;

public interface DragonDiedListener {
    void handleDragonDied(DragonDeadEvent event);
}
