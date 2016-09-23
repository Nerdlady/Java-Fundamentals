package com.company._07_1984.interfaces;

import java.lang.reflect.Field;

public interface Event<T> {
    public Observable getSource();
    public Field getChangedField();
    public T getOldValue();
    public T getNewValue();
}
