package com.animals;

import com.InvalidInputExaption;
public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) throws InvalidInputExaption {
      this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setName(String name) throws InvalidInputExaption {
        if (name == null || name.trim().length() == 0){
            throw new InvalidInputExaption();
        }
        this.name = name;
    }

    public void setAge(int age) throws InvalidInputExaption {
        if (age < 0){
            throw new InvalidInputExaption();
        }
        this.age = age;
    }

    public void setGender(String gender) throws InvalidInputExaption {
        if (!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")){
            throw new InvalidInputExaption();
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void produceSound(){
        System.out.println("Not implemented!");
    };
}
