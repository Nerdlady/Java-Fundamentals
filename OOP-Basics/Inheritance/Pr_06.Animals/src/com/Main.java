package com;

import com.animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
      //  try {
            while (true) {
                String line = reader.readLine();
                if (line.equals("Beast!")) {
                    break;
                }

                String[] info = reader.readLine().split("\\s+");
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String gender = info[2];
                Animal animal;
                try {
                    switch (line.toLowerCase()) {
                        case "cat":
                            animal = new Cat(name,age,gender);
                            break;
                        case "dog":
                            animal = new Dog(name,age,gender);
                            break;
                        case "frog":
                            animal = new Frog(name,age,gender);
                            break;
                        case "kitten":
                            animal = new Kitten(name,age);
                            break;
                        case "tomcat":
                            animal = new Tomcat(name,age);
                            break;
                        default:
                            throw new InvalidInputExaption();

                    }
                    System.out.println(animal.getClass().getSimpleName());
                    System.out.printf("%s %d %s%n",animal.getName(),animal.getAge(),animal.getGender());
                    animal.produceSound();
                } catch (InvalidInputExaption e){
                    System.out.println(e.getMessage());
                }

            }
       // } catch (InvalidInputExaption e){
        //    System.out.println(e.getMessage());
        //}

    }


}
