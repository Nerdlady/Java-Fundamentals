package com.company._11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CatLady {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //LinkedList<Cat> cats = new LinkedList<>();
        HashMap<String,Cat> cats = new HashMap<>();
        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }

            String[] info = line.split("\\s+");

            switch (info[0]){
                case "StreetExtraordinaire":
                    cats.put(info[1],new StreetExtraordinaire(info[1],Integer.parseInt(info[2])));
                    break;
                case "Siamese":
                    cats.put(info[1],new Siamese(info[1],Integer.parseInt(info[2])));
                    break;
                case "Cymric":
                    cats.put(info[1],new Cymric(info[1],Double.parseDouble(info[2])));
                    break;
            }
        }
        String name = reader.readLine();
        System.out.println(cats.get(name).toString());

    }
}

class Cat{
    String name;
}

class StreetExtraordinaire extends Cat{
    int decibelsOfMeows;

    public StreetExtraordinaire(String name,int decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("StreetExtraordinaire %s %d",this.name,this.decibelsOfMeows);
    }
}

class Siamese extends Cat{
    int earSize;

    public Siamese(String name,int earSize) {
        this.earSize = earSize;
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("Siamese %s %d",this.name,this.earSize);
    }
}
class Cymric extends Cat{
    double furLenght;

    public Cymric(String name,double furLenght) {
        this.furLenght = furLenght;
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("Cymric %s %.2f",this.name,this.furLenght);
    }
}
