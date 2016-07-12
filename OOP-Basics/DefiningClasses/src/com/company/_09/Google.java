package com.company._09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Google {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> people = new HashMap<>();
        while (true) {
            String line = reader.readLine();
            if (line.equals("End")) {
                break;
            }

            String[] info = line.split("\\s+");
            String name = info[0];
            String command = info[1];

            if (!people.containsKey(name)) {
                people.put(name, new Person(name));
            }

            switch (command) {
                case "company":
                    String companyName = info[2];
                    String dep = info[3];
                    double salary = Double.parseDouble(info[4]);
                    Company company = new Company(salary, dep, companyName);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String type = info[3];
                    Pokemon pokemon = new Pokemon(type, pokemonName);
                    people.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    String perentName = info[2];
                    String birh = info[3];
                    people.get(name).addPerent(new Perent(perentName, birh));
                    break;
                case "children":
                    String childrenName = info[2];
                    String chBirh = info[3];
                    people.get(name).addChildren(new Children(childrenName, chBirh));
                    break;
                case "car":
                    String model = info[2];
                    int speed = Integer.parseInt(info[3]);
                    people.get(name).setCar(new Car(model, speed));
                    break;
            }

        }
        String name = reader.readLine();
        System.out.println(name);
        System.out.println(people.get(name).toString());
    }
}

class Person {
    String name;
    Company company;
    Car car;
    LinkedList<Perent> perents;
    LinkedList<Children> childrens;
    LinkedList<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.perents = new LinkedList<>();
        this.childrens = new LinkedList<>();
        this.pokemons = new LinkedList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void addPerent(Perent perent) {
        perents.add(perent);
    }

    public void addChildren(Children children) {
        childrens.add(children);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Company: %n%s", (company != null ? company.toString() : "")))
                .append(String.format("Car: %n%s", (car != null ? car.toString() : "")))
                .append(String.format("Pokemon: %n%s", (pokemons != null ?  pokemons.stream().map(Pokemon::toString).collect(Collectors.joining(String.format(""))): "")))
                .append(String.format("Parents: %n%s", (perents != null ? perents.stream().map(Perent::toString).collect(Collectors.joining(String.format(""))): "")))
                .append(String.format("Children: %n%s", (childrens != null ? childrens.stream().map(Children::toString).collect(Collectors.joining(String.format(""))): "")));
        return builder.toString();
    }
}

class Car {
    String model;
    int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(model).append(" ").append(speed).append(String.format("%n"));
        return builder.toString();
    }
}

class Pokemon {
    String name;
    String type;

    public Pokemon(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(type).append(String.format("%n"));
        return builder.toString();
    }
}

class Company {
    String name;
    String demartment;
    double selary;

    public Company(double selary, String demartment, String name) {
        this.selary = selary;
        this.demartment = demartment;
        this.name = name;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(demartment).append(" ").append(String.format("%.2f",selary)).append(String.format("%n"));
        return builder.toString();
    }
}

class Children {
    String name;
    String birhday;

    public Children(String name, String birhday) {
        this.name = name;
        this.birhday = birhday;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(birhday).append(String.format("%n"));
        return builder.toString();
    }
}

class Perent {
    String name;
    String birhday;

    public Perent(String name, String birhday) {
        this.name = name;
        this.birhday = birhday;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(birhday.toString()).append(String.format("%n"));
        return builder.toString();
    }
}
