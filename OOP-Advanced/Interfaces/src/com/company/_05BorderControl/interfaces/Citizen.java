package com.company._05BorderControl.interfaces;

public interface Citizen extends Identifiable,Birthable,Buyer {

    int getAge();
    void setAge(int age);
}
