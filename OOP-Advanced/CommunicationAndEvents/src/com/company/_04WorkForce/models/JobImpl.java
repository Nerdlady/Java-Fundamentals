package com.company._04WorkForce.models;

import com.company._04WorkForce.interfaces.Employee;
import com.company._04WorkForce.interfaces.Job;
import com.company._04WorkForce.interfaces.JobListener;
import com.company._04WorkForce.models.events.JobCompletedEvent;

import java.util.ArrayList;
import java.util.List;

public class JobImpl implements Job {
    private String name;
    private int requiredHoursPerWeek;
    private Employee employee;
    private List<JobListener> jobListeners;

    public JobImpl(String name, int requiredHoursPerWeek,Employee employee) {
        this.setName(name);
        this.setRequiredHoursPerWeek(requiredHoursPerWeek);
        this.setEmployee(employee);
        this.jobListeners = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRequiredHoursPerWeek(int requiredHoursPerWeek) {
        this.requiredHoursPerWeek = requiredHoursPerWeek;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getRequiredHoursPerWeek() {
        return this.requiredHoursPerWeek;
    }

    @Override
    public void update() {
        this.requiredHoursPerWeek -= this.employee.getWorkHoursPerWeek();
        if (this.requiredHoursPerWeek <= 0){
            System.out.printf("Job %s done!%n",this.getName());
            this.fireJobListeners();
        }
    }

    @Override
    public void addJobListener(JobListener jobListener) {
        this.jobListeners.add(jobListener);
    }

    @Override
    public void removeJobListener(JobListener jobListener) {
        this.jobListeners.remove(jobListener);
    }

    @Override
    public void fireJobListeners() {
        JobCompletedEvent event = new JobCompletedEvent(this);
        for (JobListener jobListener : jobListeners) {
            jobListener.handleJobComplated(event);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d",this.getName(),this.getRequiredHoursPerWeek());
    }
}
