package com.company._06StrategyPattern;

public class PersonImpl implements Person {
    private String name;
    private int age;

    public PersonImpl(String name, int age) {
      this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %d",this.getName(),this.getAge());
    }
}
