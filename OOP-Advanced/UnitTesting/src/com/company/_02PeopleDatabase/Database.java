package com.company._02PeopleDatabase;

import javax.naming.OperationNotSupportedException;

public class Database {
    private static final int MAX_CAPACITY = 16;
    private Person[] people;
    private int peopleCount;
    private int currentIndex;

    public Database(Person... elements) throws OperationNotSupportedException {
        this.setPeople(elements);
        this.peopleCount = elements.length;
        this.currentIndex = this.peopleCount;
    }

    public void addPerson(Person person) throws OperationNotSupportedException {
        if (person == null) {
            throw new OperationNotSupportedException();
        }

        this.people[currentIndex++] = person;
        this.peopleCount++;

    }

    public void removePerson() throws OperationNotSupportedException {
        if (this.peopleCount == 0) {
            throw new OperationNotSupportedException();
        }

        this.people[--currentIndex] = null;
        this.peopleCount--;
    }

    public Person[] getPeople() {
        Person[] copyToReturn = new Person[this.peopleCount];
        for (int i = 0; i < this.peopleCount; i++) {
            copyToReturn[i] = this.people[i];
        }

        return copyToReturn;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public Person getByName(String name) throws OperationNotSupportedException {
        if (name == null) {
            throw new OperationNotSupportedException();
        }

        int peopleWithGivenName = 0;
        Person person = null;
        for (Person currentPerson : people) {
            if (currentPerson != null && currentPerson.getName().equals(name)) {
                peopleWithGivenName++;
                person = currentPerson;
            }
        }

        if (peopleWithGivenName != 1) {
            throw new OperationNotSupportedException();
        }

        return person;
    }


    public Person getById(Long id) throws OperationNotSupportedException {
        if (id == null || id < 0) {
            throw new OperationNotSupportedException();
        }

        int peopleWithGivenName = 0;
        Person person = null;
        for (Person currentPerson : people) {
            if (currentPerson != null && currentPerson.getId() == id) {
                peopleWithGivenName++;
                person = currentPerson;
            }
        }

        if (peopleWithGivenName != 1) {
            throw new OperationNotSupportedException();
        }

        return person;
    }

    private void setPeople(Person... people) throws OperationNotSupportedException {
        if (people.length > MAX_CAPACITY || people.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.people = new Person[MAX_CAPACITY];
        for (int i = 0; i < people.length; i++) {
            this.people[i] = people[i];
        }

    }
}
