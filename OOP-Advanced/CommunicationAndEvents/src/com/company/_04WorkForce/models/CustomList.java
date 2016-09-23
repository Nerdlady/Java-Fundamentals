package com.company._04WorkForce.models;

import com.company._04WorkForce.interfaces.JobListener;
import com.company._04WorkForce.models.events.JobCompletedEvent;

import java.util.LinkedList;

public class CustomList<T> extends LinkedList<T> implements JobListener {
    @Override
    public void handleJobComplated(JobCompletedEvent event) {
        this.remove(event.getSource());
    }
}
