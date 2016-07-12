package com.company._08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (true) {
            String line = reader.readLine();
            if (line.equals("Tournament")) {
                break;
            }

            String[] info = line.split("\\s+");
            String name = info[0];
            String pokemonName = info[1];
            String element = info[2];
            int health = Integer.parseInt(info[3]);

            if (!trainers.containsKey(name)) {
                trainers.put(name, new Trainer(name));
            }

            Trainer current = trainers.get(name);
            current.addPokemon(new Pokemon(pokemonName, element, health));
            trainers.put(name, current);
        }

        LinkedList<Trainer> trainerss = new LinkedList<>();

        for (Map.Entry<String, Trainer> trainerEntry : trainers.entrySet()) {
            trainerss.add(trainerEntry.getValue());
        }

        while (true) {
            String line = reader.readLine();
            if (line.equals("End")) {
                break;
            }


            for (Trainer trainer : trainerss) {
                if (trainer.checkPokemontElement(line)) {
                    trainer.numberOfBadges++;
                } else {
                    trainer.takePokemonsHealth();
                }
            }
        }

        trainerss.stream().sorted((a,b)-> Integer.compare(b.numberOfBadges,a.numberOfBadges)).forEach(a -> System.out.printf("%s %d %d%n",a.name,a.numberOfBadges,a.pokemons.size()));
    }
}

class Trainer {
    String name;
    int numberOfBadges;
    LinkedList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        numberOfBadges = 0;
        pokemons = new LinkedList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public boolean checkPokemontElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void takePokemonsHealth() {
        LinkedList<Pokemon> toRemove = new LinkedList<>();
        for (Pokemon pokemon : pokemons) {
            pokemon.takeHealh();
            if (pokemon.health <=0){
               toRemove.add(pokemon);
            }
        }

        for (Pokemon pokemon : toRemove) {
            pokemons.remove(pokemon);
        }
    }

}

class Pokemon {
    String name;
    String element;
    int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public void takeHealh() {
        health -= 10;
    }
}