package com.company._05ComparingObjects;

public class PersonImpl implements Person,Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public PersonImpl(String name, int age, String town) {
       this.setAge(age);
        this.setName(name);
        this.setTown(town);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTown(String town) {
        this.town = town;
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
    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person o) {
        int one = this.getName().compareTo(o.getName());
        int two = Integer.compare(this.getAge(),o.getAge());
        int three = this.getTown().compareTo(o.getTown());
        if (one < 0 || two <0 ||three < 0){
            return -1;
        }

        if (one == 0 && two ==0 &&three==0){
            return 0;
        }

        return 1;

    }
}
