package _04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AnimalClinic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = reader.readLine();
            try {
                if (line.equals("End") || line.isEmpty() || line == null){
                    break;
                }

                String[] info = line.split("\\s+");
                switch (info[2]){
                    case "rehabilitate":
                        Animal animal = new Animal(info[0],info[1]);
                        AnimalClinicc.rehabilitated(animal);
                        break;
                    case "heal":
                        Animal animals = new Animal(info[0],info[1]);
                        AnimalClinicc.helth(animals);

                        break;

                }


            } catch (Exception e){
                break;
            }

        }
        String line = reader.readLine();

        System.out.printf("Total healed animals: %d%n",AnimalClinicc.helt);
        System.out.printf("Total rehabilitated animals: %d%n",AnimalClinicc.reh);
        switch (line){
            case "heal":
                for (Animal animal : AnimalClinicc.heltList) {
                    System.out.printf("%s %s%n",animal.name,animal.type);
                }
                break;
            case "rehabilitate":
                for (Animal animal : AnimalClinicc.rehList) {
                    System.out.printf("%s %s%n",animal.name,animal.type);
                }
                break;
        }




    }


}


class AnimalClinicc {
    static int count = 1;
    static int reh = 0;
    static int helt = 0;

    static LinkedList<Animal> rehList = new LinkedList<>();
    static LinkedList<Animal> heltList = new LinkedList<>();

    public static void rehabilitated(Animal animal) {
        System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n",count,animal.name,animal.type);
        count++;
        reh++;
        rehList.add(animal);
    }

    public static void helth(Animal animal) {
        System.out.printf("Patient %d: [%s (%s)] has been healed!%n",count,animal.name,animal.type);
        count++;
        helt++;
        heltList.add(animal);
    }
}

class Animal{
    String name;
    String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

