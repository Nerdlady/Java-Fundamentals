package com.company._08PetClinics;

public class PetImpl implements Pet {
    private String name;
    private int age;
    private String kind;

    public PetImpl(String name, int age, String kind) {
       this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getKind() {
        return this.kind;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s",this.getName(),this.getAge(),this.getKind());
    }
}
