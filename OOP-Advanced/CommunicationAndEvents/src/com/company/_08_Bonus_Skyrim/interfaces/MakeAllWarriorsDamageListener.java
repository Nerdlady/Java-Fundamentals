package com.company._08_Bonus_Skyrim.interfaces;

import com.company._08_Bonus_Skyrim.events.AttackAllWarriorsEvent;

public interface MakeAllWarriorsDamageListener {
    void handleAttackAllWarriors(AttackAllWarriorsEvent events);
}
