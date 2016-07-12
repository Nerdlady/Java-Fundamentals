package com.company._05BorderControl;

import com.company._05BorderControl.interfaces.Rebel;

public class RebelImpl implements Rebel {
    private String name;
    private String group;
    private int age;
    private int food;

    public RebelImpl(String name, String group, int age) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void buyFoood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
