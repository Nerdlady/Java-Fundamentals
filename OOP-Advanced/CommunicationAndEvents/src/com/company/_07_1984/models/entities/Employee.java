package com.company._07_1984.models.entities;

import com.company._07_1984.anotations.Setter;

public class Employee extends Entity {
    private String name;
    private int income;
    public Employee(String id,String name,int income) {
        super(id);
        this.name = name;
        this.income =income;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Setter(fieldName = "name", fieldType = "String")
    public void setName(String name){
        String oldName = this.getName();
        this.name =name;
        this.fieldChanged(Employee.class,"name",oldName,this.getName());
    }

    @Setter(fieldName = "income", fieldType = "int")
    public void setIncome(int income) {
        int oldValue = this.income;
        this.income = income;
        this.fieldChanged(Employee.class,"income", oldValue, this.income);
    }
}
