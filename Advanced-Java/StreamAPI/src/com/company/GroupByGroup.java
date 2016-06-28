package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Person> people = new LinkedList<>();

        while (true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }

            String[] info = line.split("\\s+");
            String name = info[0] + " " + info[1];
            Integer group = Integer.parseInt(info[2]);
            Person person = new Person(name,group);
            people.add(person);
        }
        Stream<Person> stream = people.stream();
        Map<Integer, List<Person>> counted = stream.collect(Collectors.groupingBy(Person::getGroup));
        counted.entrySet().stream()
                .forEach(a -> System.out.printf("%d - %s%n", a.getKey(),String.join(", ",a.getValue()
                        .stream()
                        .map(Person::toString)
                        .collect(Collectors.toList()))));

    }
}
class Person{
    String name;
    Integer group;
    public Person(String name,Integer group){
        this.name = name;
        this.group = group;
    }

    public Integer getGroup(){
        return group;
    }
    @Override
    public String toString(){
        return name;
    }
}
