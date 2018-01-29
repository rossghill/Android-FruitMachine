package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

public enum Symbol {

    CHERRY(10),
    ORANGE(25),
    BANANA(50),
    BAR  (100),
    GOLD (250);

    private final int value;

    Symbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}