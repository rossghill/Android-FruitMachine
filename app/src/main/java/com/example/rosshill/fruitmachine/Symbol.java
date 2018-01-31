package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

public enum Symbol {

    CHERRY(1),
    ORANGE(2),
    LEMON(5),
    BAR  (10),
    DIAMOND (60);

    private final int value;

    Symbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}