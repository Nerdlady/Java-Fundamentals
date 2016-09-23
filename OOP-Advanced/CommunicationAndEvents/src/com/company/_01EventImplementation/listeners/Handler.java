package com.company._01EventImplementation.listeners;

import com.company._01EventImplementation.events.NameChange;
import com.company._01EventImplementation.interfaces.NameChangeListener;

public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(NameChange event) {
        System.out.printf("Dispatcher's name changed to %s.%n",event.getChangedName());
    }
}
