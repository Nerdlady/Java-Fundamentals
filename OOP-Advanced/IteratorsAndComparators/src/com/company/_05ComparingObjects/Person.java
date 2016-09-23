package com.company._05ComparingObjects;

public interface Person extends Comparable<Person> {
    String getName();
    int getAge();
    String getTown();
}
