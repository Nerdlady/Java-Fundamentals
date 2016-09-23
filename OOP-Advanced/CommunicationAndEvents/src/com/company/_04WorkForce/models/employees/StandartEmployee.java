package com.company._04WorkForce.models.employees;

public class StandartEmployee extends AbstractEmployee {
    private static final int WORK_HOURS = 40;

    public StandartEmployee(String name) {
        super(name);
        super.setWorkHoursPerWeek(WORK_HOURS);
    }
}
