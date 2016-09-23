package com.company._06MirrorImage.creators;

import com.company._06MirrorImage.interfaces.Wizard;
import com.company._06MirrorImage.models.WizardImpl;

public class WizardCreator {
    public Wizard createReflection(Wizard wizard) {
        String wizardName = wizard.getName();
        int wizardPower = wizard.getPower();

        return new WizardImpl(wizardName, IdCreator.nextId(), wizardPower / 2);
    }
}
