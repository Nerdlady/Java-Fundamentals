package com.company._07_1984.interfaces;

import java.lang.reflect.Field;

public interface Observable extends Nameable,Identifiable {
    public <T> void fireEvent(Field field, T oldValue, T newValue);
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
}
