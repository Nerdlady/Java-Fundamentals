package com.company._07_1984.interfaces;

import java.util.Set;

public interface Data {
    void addObserver(Observer observer);
    Observer getObserver(String id);
    void addObservable(Observable observable);
    Observable getObservable(String id);
    void subscribeObserver(Observer observer);
    Set<String> getObservers();
}
