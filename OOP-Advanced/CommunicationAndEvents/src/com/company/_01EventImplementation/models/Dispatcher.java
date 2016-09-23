package com.company._01EventImplementation.models;

import com.company._01EventImplementation.events.NameChange;
import com.company._01EventImplementation.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListeners;
    private NameChange nameChanger;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        NameChange nameChange = new NameChange(this,name);
        this.fireNameChangeEvent(nameChange);
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener){
        this.nameChangeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener){
        this.nameChangeListeners.remove(nameChangeListener);
    }

    private void fireNameChangeEvent(NameChange nameChange){
        for (NameChangeListener nameChangeListener : nameChangeListeners) {
          nameChangeListener.handleChangedName(nameChange);
        }
    }
}
