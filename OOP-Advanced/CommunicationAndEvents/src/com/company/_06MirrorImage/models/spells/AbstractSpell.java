package com.company._06MirrorImage.models.spells;

import com.company._06MirrorImage.enums.SpellType;
import com.company._06MirrorImage.interfaces.Spell;
import com.company._06MirrorImage.interfaces.Wizard;

public abstract class AbstractSpell implements Spell {
    private Wizard wizard;
    private SpellType spellType;

    public AbstractSpell(Wizard wizard, SpellType spellType) {
        this.setWizard(wizard);
        this.setSpellType(spellType);
    }

    @Override
    public abstract void cast();

    public Wizard getWizard() {
        return wizard;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    private void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    private void setSpellType(SpellType spellType) {
        this.spellType = spellType;
    }
}
