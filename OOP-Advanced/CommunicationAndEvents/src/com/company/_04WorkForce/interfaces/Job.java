package com.company._04WorkForce.interfaces;

public interface Job {
    String getName();
    int getRequiredHoursPerWeek();
    void update();
    void addJobListener(JobListener jobListener);
    void removeJobListener(JobListener jobListener);
    void fireJobListeners();
}
