package com.company._06MirrorImage.events;

import com.company._06MirrorImage.interfaces.Spell;

import java.util.EventObject;

public class WizardEvent extends EventObject {
    private Spell spellType;

    public WizardEvent(Object source,Spell spell) {
        super(source);
        this.spellType = spell;
    }

    public Spell getSpell(){
        return this.spellType;
    }
}
