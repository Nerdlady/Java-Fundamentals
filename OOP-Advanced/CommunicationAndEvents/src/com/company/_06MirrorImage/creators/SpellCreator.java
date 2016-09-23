package com.company._06MirrorImage.creators;

import com.company._06MirrorImage.enums.SpellType;
import com.company._06MirrorImage.interfaces.Spell;
import com.company._06MirrorImage.interfaces.Wizard;
import com.company._06MirrorImage.models.spells.FireballSpell;
import com.company._06MirrorImage.models.spells.ReflectionSpell;

public class SpellCreator {
    public Spell create(Wizard source, SpellType type) {
        switch (type) {
            case REFLECTION:
                return new ReflectionSpell(source, type);
            case FIREBALL:
                return new FireballSpell(source, type);
            default:
                throw new IllegalArgumentException("Illegal spell type");
        }
    }
}
