package com.company._10;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class FamilyTree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = new Person();
        String infoAboutPerson = reader.readLine();
        LinkedList<Person> people = new LinkedList<>();
        if (Character.isDigit(infoAboutPerson.charAt(0))) {
            person.setBirthday(infoAboutPerson);
        } else {
            person.setName(infoAboutPerson);
        }

        while (true) {
            String line = reader.readLine();
            if (line.equals("End")) {
                break;
            }

            if (line.contains("-")) {
                String[] info = line.split("-");
                String one = info[0].trim();
                String two = info[1].trim();

                if (Character.isLetter(one.charAt(0)) && Character.isLetter(two.charAt(0))) {
                    Person oneP = new Person();
                    Person twoP = new Person();
                    oneP.setName(one);
                    twoP.setName(two);

                    boolean haveOne = false;
                    boolean haveTwo = false;
                    for (Person person1 : people) {
                        if (person1.name.equals(one)) {
                            person1.childrents.add(twoP);
                            haveOne = true;

                        } else if (person1.name.equals(two)) {
                            person1.perents.add(oneP);
                            haveTwo = true;
                        }
                    }
                    if (!haveOne) {
                        oneP.childrents.add(twoP);
                        people.add(oneP);
                    }
                    if (!haveTwo) {
                        twoP.perents.add(oneP);

                        people.add(twoP);
                    }


                } else if (Character.isDigit(one.charAt(0)) && Character.isDigit(two.charAt(0))) {
                    Person oneP = new Person();
                    Person twoP = new Person();
                    oneP.setBirthday(one);
                    twoP.setBirthday(two);
                    boolean haveOne = false;
                    boolean haveTwo = false;

                    for (Person person1 : people) {
                        if (person1.birthday.equals(one)) {
                            person1.childrents.add(twoP);
                            haveOne = true;
                        } else if (person1.birthday.equals(two)) {
                            person1.perents.add(oneP);
                            haveTwo = true;
                        }
                    }


                    if (!haveOne) {
                        oneP.childrents.add(twoP);
                        people.add(oneP);
                    }
                    if (!haveTwo) {
                        twoP.perents.add(oneP);

                        people.add(twoP);
                    }


                } else if (Character.isLetter(one.charAt(0)) && Character.isDigit(two.charAt(0))) {
                    Person oneP = new Person();
                    Person twoP = new Person();
                    oneP.setName(one);
                    twoP.setBirthday(two);
                    boolean haveOne = false;
                    boolean haveTwo = false;
                    for (Person person1 : people) {
                        if (person1.name.equals(one)) {
                            person1.childrents.add(twoP);
                            haveOne = true;
                        } else if (person1.birthday.equals(two)) {
                            person1.perents.add(oneP);
                            haveTwo = true;
                        }
                    }


                    if (!haveOne) {
                        oneP.childrents.add(twoP);
                        people.add(oneP);
                    }
                    if (!haveTwo) {
                        twoP.perents.add(oneP);

                        people.add(twoP);
                    }

                } else if (Character.isDigit(one.charAt(0)) && Character.isLetter(two.charAt(0))) {
                    Person oneP = new Person();
                    Person twoP = new Person();
                    oneP.setBirthday(one);
                    twoP.setName(two);
                    boolean haveOne = false;
                    boolean haveTwo = false;
                    for (Person person1 : people) {
                        if (person1.birthday.equals(one)) {
                            person1.childrents.add(twoP);
                            haveOne = true;

                        } else if (person1.name.equals(two)) {
                            person1.perents.add(oneP);
                            haveTwo = true;
                        }
                    }


                    if (!haveOne) {
                        oneP.childrents.add(twoP);
                        people.add(oneP);
                    }
                    if (!haveTwo) {
                        twoP.perents.add(oneP);

                        people.add(twoP);
                    }


                }
            } else {
                String[] info = line.split("\\s+");
                String name = info[0] + " " + info[1];
                String birhday = info[2];

                for (Person person1 : people) {
                    if (person1.name.equals(name)) {
                        person1.setBirthday(birhday);
                    } else if (person1.birthday.equals(birhday)) {
                        person1.setName(name);
                    }


                }
                if (person.name.equals(name) && !person.name.equals("")) {
                    person.setBirthday(birhday);

                } else if (person.birthday.equals(birhday) && !person.birthday.equals("")) {
                    person.setName(name);

                }
            }


        }

        for (Person person1 : people) {


            for (Person perent : person1.perents) {
                if (person.name.equals(perent.name)){
                    person.childrents.add(person1);
                } else if (person.birthday.equals(perent.birthday)){
                    person.childrents.add(person1);
                }
            }

            for (Person perent : person1.childrents) {
                if (person.name.equals(perent.name)){
                    person.perents.add(person1);
                } else if (person.birthday.equals(perent.birthday)){
                    person.perents.add(person1);
                }
            }
        }


        System.out.println(person.name + " " + person.birthday);
        System.out.println("Parents:");
        for (Person perent : person.perents) {
            System.out.println(perent.name + " " + perent.birthday);
        }
        System.out.println("Children:");
        for (Person childrent : person.childrents) {
            System.out.println(childrent.name + " " + childrent.birthday);
        }
    }
}

class Person {
    String name;
    String birthday;
    LinkedHashSet<Person> perents;
    LinkedHashSet<Person> childrents;

    public Person() {
        this.perents = new LinkedHashSet<>();
        this.childrents = new LinkedHashSet<>();
        this.name = "";
        this.birthday = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (this.name.equals(other.name) && this.birthday.equals(other.birthday))
            return true;

        return true;
    }

}
