package com.company._02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class OldestFamilyMember {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        Family family = new Family();
        for (int i = 0; i < number; i++) {
            String[] person = reader.readLine().split("\\s+");
            Person current = new Person(person[0],Integer.parseInt(person[1]));
            family.addFamilyMember(current);
        }

        System.out.println(family.getOldestMember().toString());

        Method getOldestMethod =Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addFamilyMember", Person.class);


    }
}

class Family{
    LinkedList<Person>  members;

    public Family() {
        this.members = new LinkedList<>();
    }

    public void addFamilyMember(Person member){
        members.add(member);
    }

     public Person getOldestMember(){
        int max = Integer.MIN_VALUE;
         Person person = new Person();
        for (Person member : members) {
            if (member.age > max){
                max = member.age;
                person = member;
            }
        }
        return person;
    }


}

class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("%s %d",this.name, this.age);
    }
}
