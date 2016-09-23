package com.company._07_1984.core;

import com.company._07_1984.anotations.Setter;
import com.company._07_1984.interfaces.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class DispathcerImpl implements Dispatcher {
    private Data data;
    private Reader reader;
    private Writter writer;
    private ObserverCreator observerCreator;
    private ObservableCreator observableCreator;

    public DispathcerImpl(Data data, Reader reader, Writter writer, ObserverCreator observerCreator, ObservableCreator observableCreator) {
        this.data = data;
        this.reader = reader;
        this.writer = writer;
        this.observerCreator = observerCreator;
        this.observableCreator = observableCreator;
    }

    @Override
    public void readEntities(int entitiesCount) throws IOException {
        for (int i = 0; i < entitiesCount; i++) {
            String[] entitiesTokens = this.reader.readLine().split("\\s+");
            Observable observable = this.observableCreator.createObservable(entitiesTokens);
            this.data.addObservable(observable);
        }
    }

    @Override
    public void readInstitutions(int institutionsCount) throws IOException {
        for (int i = 0; i < institutionsCount; i++) {
            String[] institutionTokens = this.reader.readLine().split("\\s+");
            Observer observer = this.observerCreator.create(institutionTokens);
            this.data.addObserver(observer);
            this.data.subscribeObserver(observer);
        }
    }

    @Override
    public void executeChange(String... changesTokens) throws IllegalAccessException, InvocationTargetException {
        String id = changesTokens[0];
        String fieldName = changesTokens[1];
        String parameter = changesTokens[2];

        Observable observable = this.data.getObservable(id);

        Class<?> observableClass = observable.getClass();
        Method[] observableClassDeclaredMethods = observableClass.getDeclaredMethods();

        for (Method method : observableClassDeclaredMethods) {
            Setter setter = method.getAnnotation(Setter.class);
            if (setter != null && setter.fieldName().equals(fieldName)) {
                if (setter.fieldType().equals("int")) {
                    method.invoke(observable, Integer.parseInt(parameter));
                } else {
                    method.invoke(observable, parameter);
                }
            }
        }
    }

    @Override
    public void printChanges() {
        for (String observerId : this.data.getObservers()) {
            Observer observer = this.data.getObserver(observerId);
            List<String> observerChangeLog = observer.getChanges();

            String heading = String.format("%s: %d changes registered", observer.getName(), observerChangeLog.size());
            this.writer.writeLine(heading);

            for (String change : observerChangeLog) {
                this.writer.writeLine(change);
            }
        }
    }
}
