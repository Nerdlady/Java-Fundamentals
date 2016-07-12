package com.company._05BorderControl;

import com.company._05BorderControl.interfaces.Robot;

public class RobotImpl implements Robot {
    private String model;
    private String id;

    public RobotImpl(String model, String id) {
        this.setId(id);
        this.setModel(model);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
}
