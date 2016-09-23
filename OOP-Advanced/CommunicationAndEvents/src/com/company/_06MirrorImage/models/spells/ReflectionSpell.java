package com.company._06MirrorImage.models.spells;

import com.company._06MirrorImage.core.WizardData;
import com.company._06MirrorImage.creators.WizardCreator;
import com.company._06MirrorImage.enums.SpellType;
import com.company._06MirrorImage.interfaces.Data;
import com.company._06MirrorImage.interfaces.Wizard;

public class ReflectionSpell extends AbstractSpell {
    private WizardCreator wizardCreator;

    public ReflectionSpell(Wizard wizard, SpellType spellType) {
        super(wizard, spellType);
        this.wizardCreator = new WizardCreator();
    }

    @Override
    public void cast() {
        Wizard wizard = this.getWizard();
        System.out.printf("%s casts Reflection%n",wizard.toString());

        for (int i = 0; i < 2; i++) {
            if (this.getWizard().getNumberOfMiirorImages() < 2){
                Wizard mirrorWizard = this.wizardCreator.createReflection(wizard);
                wizard.addWizardListener(mirrorWizard);
                Data data = WizardData.getInstance();
                data.addWizard(mirrorWizard);
            }
        }
    }
}
