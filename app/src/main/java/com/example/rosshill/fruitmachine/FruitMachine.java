package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

import java.util.ArrayList;
import java.util.Collections;

public class FruitMachine {

    private ArrayList<Symbol> reel1;
    private ArrayList<Symbol> reel2;
    private ArrayList<Symbol> reel3;

    private Symbol reel1A;
    private Symbol reel1B;
    private Symbol reel1C;
    private Symbol reel2A;
    private Symbol reel2B;
    private Symbol reel2C;
    private Symbol reel3A;
    private Symbol reel3B;
    private Symbol reel3C;


    public FruitMachine() {
        this.reel1 = new ArrayList<>();
        this.reel2 = new ArrayList<>();
        this.reel3 = new ArrayList<>();
        this.reel1A = reel1A;
        this.reel1B = reel1B;
        this.reel1C = reel1C;
        this.reel2A = reel2A;
        this.reel2B = reel2B;
        this.reel2C = reel2C;
        this.reel3A = reel3A;
        this.reel3B = reel3B;
        this.reel3C = reel3C;
    }

    public ArrayList<Symbol> getReel1Symbols() {
        return reel1;
    }

    public ArrayList<Symbol> getReel2Symbols() {
        return reel2;
    }

    public ArrayList<Symbol> getReel3Symbols() {
        return reel3;
    }

    public void shuffle(ArrayList reel) {
        Collections.shuffle(reel);
    }

    public void addSymbols(ArrayList<Symbol> reel) {
        reel.add(Symbol.CHERRY);
        reel.add(Symbol.ORANGE);
        reel.add(Symbol.BANANA);
        reel.add(Symbol.BAR);
        reel.add(Symbol.GOLD);
    }

    public void getRandomSymbols() {
        addSymbols(reel1);
        addSymbols(reel2);
        addSymbols(reel3);
        shuffle(reel1);
        reel1A = reel1.get(0);
        reel1B = reel1.get(1);
        reel1C = reel1.get(2);
        shuffle(reel2);
        reel2A = reel2.get(0);
        reel2B = reel2.get(1);
        reel2C = reel2.get(2);
        shuffle(reel3);
        reel3A = reel2.get(0);
        reel3B = reel2.get(1);
        reel3C = reel2.get(2);
        System.out.println("==+==+==SLOTS==+==+==");
        System.out.println(reel1A + " " + reel2A + " " + reel3A);
        System.out.println(reel1B + " " + reel2B + " " + reel3B);
        System.out.println(reel1C + " " + reel2B + " " + reel3C);
        System.out.println("==+==+==+==+==+==+==");

    }

    public int spin() {
        getRandomSymbols();
        if (reel1A.equals(reel2A) && reel2B.equals(reel3C)) {
            return win(reel1A, reel2B, reel3C);
        } else if (reel1B.equals(reel2B) && reel2B.equals(reel3B)) {
            return win(reel1B, reel2B, reel3B);
        } else if (reel1C.equals(reel2B) && reel2B.equals(reel3A)) {
            return win(reel1C, reel2B, reel3A);
        } else {
            return lose();
        }
    }

    public int win(Symbol winningReel1, Symbol winningReel2, Symbol winningReel3) {
        int value1 = winningReel1.getValue();
        int value2 = winningReel2.getValue();
        int value3 = winningReel3.getValue();
        int winnings = value1 + value2 + value3;
        System.out.println("Congrats! You matched three symbols and won " + winnings);
        return winnings;
    }

    public int lose() {
        return 0;
    }
}