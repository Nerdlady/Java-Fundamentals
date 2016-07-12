package com.company._05BorderControl;

import com.company._05BorderControl.interfaces.Citizen;

public class CitizenImpl implements Citizen {
    private String name;
    private String id;
    private int age;
    private String birthday;
    private int food;

    public CitizenImpl(String name, String id, int age,String birthday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthday);
        this.food = 0;
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
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
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
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public void buyFoood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
