package com.company._06MirrorImage.models;

import com.company._06MirrorImage.creators.SpellCreator;
import com.company._06MirrorImage.events.WizardEvent;
import com.company._06MirrorImage.interfaces.WizardListener;
import com.company._06MirrorImage.interfaces.Spell;
import com.company._06MirrorImage.interfaces.Wizard;

import java.util.ArrayList;
import java.util.List;

public class WizardImpl implements Wizard {
    private String name;
    private int id;
    private int power;
    private List<WizardListener> listeners;
    private SpellCreator spellCreator;

    public WizardImpl(String name, int id, int power) {
        this.setName(name);
        this.setId(id);
        this.setPower(power);
        this.listeners = new ArrayList<>();
        this.spellCreator = new SpellCreator();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setPower(int power) {
        this.power = power;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public int getNumberOfMiirorImages() {
        return this.listeners.size();
    }

    @Override
    public void addWizardListener(WizardListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeWizardListener(WizardListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getId());
    }

    @Override
    public void handleReflectionEvent(WizardEvent event) {
        Spell spell = this.spellCreator.create(this, event.getSpell().getSpellType());
        this.cast(spell);
    }

    public void cast(Spell spell) {
        List<WizardListener> listenersCopy = new ArrayList<>();
        listenersCopy.addAll(this.listeners);
        spell.cast();
        this.fireListeners(spell, listenersCopy);
    }

    private void fireListeners(Spell spell, List<WizardListener> listeners) {
        WizardEvent event = new WizardEvent(this, spell);
        for (WizardListener listener : listeners) {
            listener.handleReflectionEvent(event);
        }
    }

}
