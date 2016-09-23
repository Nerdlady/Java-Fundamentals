package com.company._01EventImplementation.interfaces;

import com.company._01EventImplementation.events.NameChange;

public interface NameChangeListener {
    void handleChangedName(NameChange event);
}
