package com.company._07_1984.models.entities;

import com.company._07_1984.anotations.Setter;

public class Company extends Entity {
    private String name;
    private int turnover;
    private int revenue;

    public Company(String id, String name, int turnover, int revenue) {
        super(id);
        this.name = name;
        this.turnover = turnover;
        this.revenue = revenue;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Setter(fieldName = "name", fieldType = "String")
    public void setName(String name) {
        String oldName = this.getName();
        this.name = name;
        this.fieldChanged(Company.class, "name", oldName, this.getName());
    }

    public int getTurnover() {
        return turnover;
    }

    @Setter(fieldName = "turnover", fieldType = "int")
    public void setTurnover(int turnover) {
        int oldTurnover = this.getTurnover();
        this.turnover = turnover;
        this.fieldChanged(Company.class, "turnover", oldTurnover, this.getTurnover());
    }

    public int getRevenue() {
        return revenue;
    }

    @Setter(fieldName = "revenue", fieldType = "int")
    public void setRevenue(int revenue) {
        int oldRevenue = this.getRevenue();
        this.revenue = revenue;
        this.fieldChanged(Company.class, "revenue", oldRevenue, this.getRevenue());
    }
}
