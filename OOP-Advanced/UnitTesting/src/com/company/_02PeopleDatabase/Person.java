package com.company._02PeopleDatabase;

public class Person {
    private String name;
    private long id;

    public Person(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)){
            return false;
        }

        Person other = (Person)obj;
        return this.getName().equals(other.getName()) && this.getId() == other.getId();
    }

    @Override
    public String toString() {
        return String.format("%s-%d",this.getName(),this.getId());
    }
}
