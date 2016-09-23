package com.company._02PeopleDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static Person ivan;
    private static Person gosho;
    public Database database;

    @Before
    public void initialize() throws OperationNotSupportedException {
        ivan = new Person("Ivan", 1234);
        gosho = new Person("Gosho", 5678);
        Person mariika = new Person("Mariika", 1472);
        this.database = new Database(ivan, gosho, mariika);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorToAddMoreThenMaxCapacityShouldThrowExeption() throws OperationNotSupportedException {
        Person[] people = new Person[18];
        Person pesho = new Person("Pesho", 2568);
        for (int i = 0; i < people.length; i++) {
            people[i] = pesho;
        }

        this.database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithoutParametersShouldThrowExeption() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Test
    public void addingElementShouldBeLast() throws OperationNotSupportedException {
        Person expextedPersn = new Person("Sara", 87);
        int expectedIndex = 3;

        this.database.addPerson(expextedPersn);

        Assert.assertEquals(expextedPersn, this.database.getPeople()[expectedIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullObjectShouldThrowExeption() throws OperationNotSupportedException {
        this.database.addPerson(null);
    }

    @Test
    public void removigElementCollectionSizeShouldBeLesser() throws OperationNotSupportedException {
        int expectedSize = this.database.getPeopleCount() - 1;
        this.database.removePerson();

        Assert.assertTrue(expectedSize == this.database.getPeopleCount());
    }

    @Test
    public void removedElementShouldNotExist() throws OperationNotSupportedException {
        Person[] expexctedPeople = {ivan, gosho};

        this.database.removePerson();

        Assert.assertArrayEquals(expexctedPeople, this.database.getPeople());
    }


    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyCollectionShouldThrowExeption() throws OperationNotSupportedException {
        int startPeopleCount = this.database.getPeopleCount();
        for (int i = 0; i <= startPeopleCount; i++) {
            this.database.removePerson();
        }
    }

    @Test
    public void getPersonByName() throws OperationNotSupportedException {
        Person expextedPerson = ivan;
        String nameToSearch = ivan.getName();

        Person gettedPerson = this.database.getByName(nameToSearch);

        Assert.assertEquals(expextedPerson, gettedPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void getPersonByNonExistingNameShouldThrowExeption() throws OperationNotSupportedException {
        String nameToCherch = "mimi";
        Person person = this.database.getByName(nameToCherch);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void gettingPersnonByNullNameShouldTrowExeption() throws OperationNotSupportedException {
        Person person = this.database.getByName(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void getingPersonWithDublicatedNameShouldThrowExeption() throws OperationNotSupportedException {
        this.database.addPerson(ivan);

        Person person = this.database.getByName(ivan.getName());
    }

    @Test
    public void getPersonById() throws OperationNotSupportedException {
        Person expectedPerson = gosho;
        long idToSearch = gosho.getId();

        Person gettedPerson = this.database.getById(idToSearch);

        Assert.assertEquals(expectedPerson, gettedPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void getPersonByNullIdShouldThrowExeption() throws OperationNotSupportedException {
        Person person = this.database.getById(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void getPersonByNegativeIdShouldThrowEeption() throws OperationNotSupportedException {
        Person person = this.database.getById(-2L);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void getPersonWithDuplicatedIdShouldThrowExeption() throws OperationNotSupportedException {
        this.database.addPerson(gosho);

        long idTosearch = gosho.getId();

        Person person = this.database.getById(idTosearch);
    }
}
