package com.company.trafficLights;

public enum Light {
    RED,
    GREEN,
    YELLOW;

    private static Light[] vals = values();

    public Light next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
