package com.company._07_1984.models;

import com.company._07_1984.interfaces.Event;
import com.company._07_1984.interfaces.Observable;
import com.company._07_1984.interfaces.Observer;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Institution implements Observer {
    private String id;
    private String name;
    private List<String> subjectsMonitored;
    private List<String> changes;

    public Institution(String id, String name, String... subjects) {
        this.id = id;
        this.name = name;
        this.subjectsMonitored = new LinkedList<>();
        Collections.addAll(subjectsMonitored, subjects);
        this.changes = new LinkedList<>();
    }

    @Override
    public void handleChange(Event event) {
        Observable source = event.getSource();
        String sourceClass = source.getClass().getSimpleName();
        String id = source.getId();
        Field changedField = event.getChangedField();

        String fieldName = changedField.getName();
        String fieldType = changedField.getType().getSimpleName();

        String oldValue = event.getOldValue().toString();
        String newValue = event.getNewValue().toString();

        if (subjectsMonitored.contains(fieldName)) {
            String result =
                    String.format("--%s(ID:%s) changed %s(%s) from %s to %s",
                            sourceClass,
                            id,
                            fieldName,
                            fieldType,
                            oldValue,
                            newValue);

            changes.add(result);
        }
    }

    public List<String> getChanges() {
        return this.changes;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
