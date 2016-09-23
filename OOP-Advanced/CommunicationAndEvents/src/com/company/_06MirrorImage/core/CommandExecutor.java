package com.company._06MirrorImage.core;

import com.company._06MirrorImage.creators.SpellCreator;
import com.company._06MirrorImage.enums.SpellType;
import com.company._06MirrorImage.interfaces.Executor;
import com.company._06MirrorImage.interfaces.Spell;
import com.company._06MirrorImage.interfaces.Wizard;

public class CommandExecutor implements Executor{
    private SpellCreator spellCreator;

    public CommandExecutor(SpellCreator spellCreator) {
        this.spellCreator = spellCreator;

    }

    @Override
    public void execute(String[] commandTokens) {

        int wizardId = Integer.valueOf(commandTokens[0]);
        SpellType spellType = SpellType.valueOf(commandTokens[1]);

        Wizard wizard = WizardData.getInstance().getWizard(wizardId);
        Spell spellToCast = spellCreator.create(wizard, spellType);

         wizard.cast(spellToCast);

    }
}
