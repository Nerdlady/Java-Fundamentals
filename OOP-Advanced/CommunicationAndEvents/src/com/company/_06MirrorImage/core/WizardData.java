package com.company._06MirrorImage.core;

import com.company._06MirrorImage.interfaces.Data;
import com.company._06MirrorImage.interfaces.Wizard;

import java.util.HashMap;

public class WizardData implements Data {
    private static WizardData instance = new WizardData();
    private static HashMap<Integer, Wizard> wizardData;

    public static Data getInstance() {
        return instance;
    }

    private WizardData() {
        if (wizardData == null) {
            wizardData = new HashMap<>();
        }
    }

    @Override
    public Wizard getWizard(int id) {
        return wizardData.get(id);
    }

    @Override
    public void addWizard(Wizard wizard) {
        wizardData.put(wizard.getId(), wizard);
    }

    @Override
    public void removeWizard(Wizard wizard) {
        wizardData.remove(wizard.getId());
    }
}
