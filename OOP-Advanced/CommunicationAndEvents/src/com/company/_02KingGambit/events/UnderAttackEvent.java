package com.company._02KingGambit.events;

import java.util.EventObject;

public class UnderAttackEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public UnderAttackEvent(Object source) {
        super(source);
    }
}
