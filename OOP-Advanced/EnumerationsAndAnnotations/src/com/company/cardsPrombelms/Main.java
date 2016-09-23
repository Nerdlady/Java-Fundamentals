package com.company.cardsPrombelms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        Player first = new CardPlayer(nameOne);
        Player second = new CardPlayer(nameTwo);
        Deck deck = new Deck();

        while (true) {
            if (!first.canAddCard() && !second.canAddCard()){
                break;
            }
            String line = reader.readLine();
            try {
                Card card = deck.getCard(line);
                if (first.canAddCard()){
                    first.addCard(card);
                } else if (second.canAddCard()){
                    second.addCard(card);
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        if (first.compareTo(second) >0){
            System.out.printf("%s wins with %s.",first.getName(),first.getMaxCard().getName());
        } else {
            System.out.printf("%s wins with %s.",second.getName(),second.getMaxCard().getName());
        }

    }
}

