package com.company._04WorkForce.models.employees;

public class PartTimeEmployee extends AbstractEmployee {
    private static final int WORK_HOURS = 20;

    public PartTimeEmployee(String name) {
        super(name);
        super.setWorkHoursPerWeek(WORK_HOURS);
    }
}
