package com.company._07_1984.events;

import com.company._07_1984.interfaces.Event;
import com.company._07_1984.interfaces.Observable;

import java.lang.reflect.Field;

public class ChangeEvent<T> implements Event<T> {
    private Observable eventStarter;
    private Field changedField;
    private T oldValue;
    private T newValue;

    public ChangeEvent(Observable eventStarter, Field field, T oldValue, T newValue) {
        this.eventStarter = eventStarter;
        this.changedField = field;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public Observable getSource() {
        return this.eventStarter;
    }

    @Override
    public Field getChangedField() {
        return this.changedField;
    }

    @Override
    public T getOldValue() {
        return this.oldValue;
    }

    @Override
    public T getNewValue() {
        return this.newValue;
    }
}
