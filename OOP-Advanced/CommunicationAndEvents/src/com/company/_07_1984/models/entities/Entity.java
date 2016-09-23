package com.company._07_1984.models.entities;

import com.company._07_1984.interfaces.Event;
import com.company._07_1984.interfaces.Observable;
import com.company._07_1984.interfaces.Observer;
import com.company._07_1984.events.ChangeEvent;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public abstract class Entity implements Observable {
    private List<Observer> observers;
    private String id;

    public Entity(String id) {
        this.id = id;
        this.observers = new LinkedList<>();
    }

    @Override
    public <T> void fireEvent(Field field, T oldValue, T newValue) {
        Event<T> event = new ChangeEvent<T>(this, field, oldValue, newValue);
        for (Observer observer : observers) {
            observer.handleChange(event);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public abstract String getName();

    protected <T> void fieldChanged(Class<?> fieldClass, String filedName, T oldValue, T newValue) {
        try {
            Field field = fieldClass.getDeclaredField(filedName);
            this.fireEvent(field, oldValue, newValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
