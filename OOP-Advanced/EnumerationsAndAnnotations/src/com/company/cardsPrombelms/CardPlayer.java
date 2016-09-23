package com.company.cardsPrombelms;

import java.util.ArrayList;
import java.util.List;

public class CardPlayer implements Player, Comparable<Player> {
    private String name;
    private List<Card> cardsInHand;

    public CardPlayer(String name) {
        this.name = name;
        this.cardsInHand = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addCard(Card card) {
        this.cardsInHand.add(card);
    }

    @Override
    public int getTotalPower() {
        return this.cardsInHand.stream().mapToInt(Card::getPower).sum();
    }

    @Override
    public boolean canAddCard() {
        return this.cardsInHand.size() != 5;
    }

    @Override
    public Card getMaxCard() {
        return this.cardsInHand.stream().max(Comparable::compareTo).get();
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.getMaxCard().getPower(),o.getMaxCard().getPower());
    }
}
