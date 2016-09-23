package com.company.cardsPrombelms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deck implements CardDeck{
    private Map<String,CardImpl> deck;
    private List<String> gettedCardsFromDeck;

    public Deck() {
        this.deck = new HashMap<>();
        this.gettedCardsFromDeck = new ArrayList<>();
        this.makeDeck();
    }

    @Override
    public CardImpl getCard(String name) {
        if (!this.deck.containsKey(name)){
            throw  new IllegalArgumentException("No such card exists.");
        }

        if (this.gettedCardsFromDeck.contains(name)){
            throw new IllegalArgumentException("Card is not in the deck.");
        }
        this.gettedCardsFromDeck.add(name);
        return this.deck.get(name);
    }

    private void makeDeck() {
        for (CardRank cardRank : CardRank.values()) {
            for (CardSuits cardSuits : CardSuits.values()) {
                CardImpl card = new CardImpl(cardRank,cardSuits);
                this.deck.put(card.getName(),card);
            }
        }
    }


}
