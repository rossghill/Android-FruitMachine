package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 29/01/2018.
 */

public enum InstructorsSymbols {

    ALEX(100),
    ZSOLT(50),
    CRAIG(25),
    COLIN(10);

    private final int value;

    InstructorsSymbols(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
