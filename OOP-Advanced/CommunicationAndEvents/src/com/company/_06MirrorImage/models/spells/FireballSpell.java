package com.company._06MirrorImage.models.spells;

import com.company._06MirrorImage.enums.SpellType;
import com.company._06MirrorImage.interfaces.Wizard;

public class FireballSpell extends AbstractSpell {
    public FireballSpell(Wizard wizard, SpellType spellType) {
        super(wizard, spellType);
    }

    @Override
    public void cast() {
        int damage = this.getWizard().getPower();
        String wizardToString = this.getWizard().toString();
        System.out.printf("%s casts Fireball for %s damage%n",wizardToString,damage);
    }
}
