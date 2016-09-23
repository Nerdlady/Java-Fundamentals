package com.company._06MirrorImage.interfaces;

public interface Wizard extends WizardListener {
    String getName();
    int getId();
    int getPower();
    int getNumberOfMiirorImages();
    void addWizardListener(WizardListener listener);
    void removeWizardListener(WizardListener listener);
    void cast(Spell spell);
}
