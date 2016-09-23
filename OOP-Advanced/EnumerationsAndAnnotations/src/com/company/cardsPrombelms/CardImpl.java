package com.company.cardsPrombelms;

public class CardImpl implements Card{
    private CardRank rank;
    private CardSuits suit;

    public CardImpl(CardRank rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getName(){
        return this.rank.name() + " of " +this.suit.name();
    }

    public int getPower(){
        return this.rank.getRang() +this.suit.getRang();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s; Card power: %s",getName(),getPower());
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getPower(),o.getPower());
    }
}
