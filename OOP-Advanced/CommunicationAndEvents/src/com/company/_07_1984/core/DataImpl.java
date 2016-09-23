package com.company._07_1984.core;


import com.company._07_1984.interfaces.Data;
import com.company._07_1984.interfaces.Observable;
import com.company._07_1984.interfaces.Observer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataImpl implements Data {
    private HashMap<String, Observer> observers;
    private HashMap<String, Observable> observables;

    public DataImpl() {
        this.observers = new LinkedHashMap<>();
        this.observables = new LinkedHashMap<>();
    }
    @Override
    public void addObserver(Observer observer) {
        this.observers.put(observer.getId(),observer);
    }

    @Override
    public Observer getObserver(String id) {
        return this.observers.get(id);
    }

    @Override
    public void addObservable(Observable observable) {
        this.observables.put(observable.getId(),observable);
    }

    @Override
    public Observable getObservable(String id) {
        return this.observables.get(id);
    }

    @Override
    public void subscribeObserver(Observer observer) {
        for (String observableId : this.observables.keySet()) {
            this.observables.get(observableId).addObserver(observer);
        }
    }

    @Override
    public Set<String> getObservers() {
        return this.observers.keySet();
    }
}
