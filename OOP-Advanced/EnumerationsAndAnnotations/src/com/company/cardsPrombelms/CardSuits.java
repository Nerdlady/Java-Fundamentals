package com.company.cardsPrombelms;

@CardMember(category = "Suit", description = "Provides suit constants for a Card class.")
enum CardSuits{
    CLUBS(0),DIAMONDS(13), HEARTS(26),  SPADES(39);

    private int rang;

    CardSuits(int rang) {
        this.rang = rang;
    }

    public int getRang() {
        return rang;
    }
}
