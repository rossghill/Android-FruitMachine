package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FruitMachine {

    private ArrayList<Symbol> reel1;
    private ArrayList<Symbol> reel2;
    private ArrayList<Symbol> reel3;

//    private Symbol reel1A;
//    private Symbol reel1B;
//    private Symbol reel1C;
//    private Symbol reel2A;
//    private Symbol reel2B;
//    private Symbol reel2C;
//    private Symbol reel3A;
//    private Symbol reel3B;
//    private Symbol reel3C;

//    private ArrayList<Symbol> symbolArrayList;


    public FruitMachine() {
        this.reel1 = new ArrayList<>();
        this.reel2 = new ArrayList<>();
        this.reel3 = new ArrayList<>();
        setupReels();
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


    public void setupReels() {
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.ORANGE);
        this.reel1.add(Symbol.ORANGE);
        this.reel1.add(Symbol.BANANA);
        this.reel1.add(Symbol.BANANA);
        this.reel1.add(Symbol.BAR);
        this.reel1.add(Symbol.GOLD);
        this.reel2 = new ArrayList<>(this.reel1);
        this.reel3 = new ArrayList<>(this.reel1);
        Collections.shuffle(reel1);
        Collections.shuffle(reel2);
        Collections.shuffle(reel3);
    }

    public void getRandomSymbol() {
//        addSymbols();
//        shuffle(symbolArrayList);
//        reel_item = symbolArrayList.get(0);
    }

//    public void getRandomSymbols() {
//        addSymbols(reel1);
//        addSymbols(reel2);
//        addSymbols(reel3);
//        shuffle(reel1);
//        reel1A = reel1.get(0);
//        reel1B = reel1.get(1);
//        reel1C = reel1.get(2);
//        shuffle(reel2);
//        reel2A = reel2.get(0);
//        reel2B = reel2.get(1);
//        reel2C = reel2.get(2);
//        shuffle(reel3);
//        reel3A = reel2.get(0);
//        reel3B = reel2.get(1);
//        reel3C = reel2.get(2);
//        System.out.println("==+==+==SLOTS==+==+==");
//        System.out.println(reel1A + " " + reel2A + " " + reel3A);
//        System.out.println(reel1B + " " + reel2B + " " + reel3B);
//        System.out.println(reel1C + " " + reel2B + " " + reel3C);
//        System.out.println("==+==+==+==+==+==+==");

//    }

    public ArrayList<ArrayList<Symbol>> getPlayfield() {

        setupReels();

        ArrayList reel1selection = new ArrayList();
        ArrayList reel2selection = new ArrayList();
        ArrayList reel3selection = new ArrayList();
        ArrayList playfield = new ArrayList<ArrayList>();

        Random random = new Random();
        int randomPosition = random.nextInt (reel1.size());
        int positionAbove = randomPosition - 1;
        int positionBelow = randomPosition + 1;

        reel1selection.add(reel1.get(positionAbove));
        reel1selection.add(reel1.get(randomPosition));
        reel1selection.add(reel1.get(positionBelow));

        playfield.add(reel1selection);
        playfield.add(reel2selection);
        playfield.add(reel3selection);

        return playfield;
    };

    public int spin() {
        ArrayList<ArrayList<Symbol>> playfield;
        playfield = getPlayField();
        if (reel1A.equals(reel1.get(0)) && reel2B.equals(reel3C)) {
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
        return value1 + value2 + value3;
    }

    public int lose() {
        return 0;
    }
}