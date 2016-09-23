package com.company.infernoInfinity.interfaces;

import com.company.infernoInfinity.annotations.CustomAnnotation;
import com.company.infernoInfinity.enums.Stat;

import java.util.List;

@CustomAnnotation(
        author =  "Pesho",
        revision =  3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers =  {"Pesho","Svetlio"})

public interface Weapon extends Comparable<Weapon>{
    String getName();
    int getMinDamage();
    int getMaxDamage();
    List<Stat> getStats();
    void addStatAtIndex(Stat stat,int index);
    void removeAtIndex(int index);
    double getItemLeve();
}
