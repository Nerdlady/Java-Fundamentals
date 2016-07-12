package com.company.models;

import com.company.interfaces.Commando;
import com.company.interfaces.Mission;

import java.util.Collection;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;
    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps,Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions(missions);
    }

    private void setMissions(Collection<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Missions:");

        for (Mission mission : missions) {
            builder.append(System.lineSeparator())
                    .append("  ")
                    .append(mission.toString());
        }
        return builder.toString();
    }
}
