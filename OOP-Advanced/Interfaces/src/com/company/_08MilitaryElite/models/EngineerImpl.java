package com.company.models;

import com.company.interfaces.Engineer;
import com.company.interfaces.Repair;

import java.util.Collection;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps,Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    private void setRepairs(Collection<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public Collection<Repair> getRepairs() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator())
                .append("Repairs:");

        for (Repair repair : repairs) {
            builder.append(System.lineSeparator())
                    .append("  ")
                    .append(repair.toString());
        }

        return builder.toString();
    }
}
