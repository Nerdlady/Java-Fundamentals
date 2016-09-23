package com.company.cardsPrombelms;

public interface Player extends Comparable<Player>{
    String getName();
    void addCard(Card card);
    int getTotalPower();
    boolean canAddCard();
    Card getMaxCard();
}
