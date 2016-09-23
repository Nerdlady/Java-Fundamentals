package com.company._07EqualityLogic;

public class PersonImpl implements Person {
    private String name;
    private int age;

    public PersonImpl(String name, int age) {
     this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
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
    public int hashCode() {
        return this.getName().hashCode() + this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Person)){
            return false;
       }

        Person other = (Person) obj;
        return this.getName().equals(other.getName()) && this.getAge() == other.getAge();
    }

    @Override
    public int compareTo(Person o) {
        int result = this.getName().compareTo(o.getName());
        if(result == 0){
            result = Integer.compare(this.getAge(),o.getAge());
        }

        return result;
    }
}
