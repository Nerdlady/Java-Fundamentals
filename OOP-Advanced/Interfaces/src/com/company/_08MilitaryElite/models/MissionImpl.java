package com.company.models;

import com.company.interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private  String state;

    public MissionImpl(String codeName, String state) {
      this.setCodeName(codeName);
        this.setState(state);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {
        if (!state.equals("Finished") && !state.equals("inProgress")){
            throw new IllegalArgumentException("Invalid state type");
        }
        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.setState("Finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.getCodeName(),this.getState());
    }
}
