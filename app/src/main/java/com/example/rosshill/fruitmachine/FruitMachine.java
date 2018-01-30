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

    public ArrayList<ArrayList<Symbol>> getPlayfield() {

        setupReels();

        ArrayList reel1selection = new ArrayList();
        ArrayList reel2selection = new ArrayList();
        ArrayList reel3selection = new ArrayList();

        Random random = new Random();
        int randomPosition = random.nextInt (reel1.size());
        Random random2 = new Random();
        int randomPosition2 = random2.nextInt (reel2.size());
        Random random3 = new Random();
        int randomPosition3 = random3.nextInt (reel3.size());


        reel1selection.add(reel1.get(randomPosition -1));
        reel1selection.add(reel1.get(randomPosition));
        reel1selection.add(reel1.get(randomPosition + 1));

        reel2selection.add(reel2.get(randomPosition2 - 1));
        reel2selection.add(reel2.get(randomPosition2));
        reel2selection.add(reel2.get(randomPosition2 + 1));

        reel3selection.add(reel3.get(randomPosition3 - 1));
        reel3selection.add(reel3.get(randomPosition3));
        reel3selection.add(reel3.get(randomPosition3 + 1));

        ArrayList playfield = new ArrayList<ArrayList>();

        playfield.add(reel1selection);
        playfield.add(reel2selection);
        playfield.add(reel3selection);

        return playfield;
    }

//    public int spin() {
//
//        playfield = getPlayField();
//        if (reel1A.equals(reel1.get(0)) && reel2B.equals(reel3C)) {
//            return win(reel1A, reel2B, reel3C);
//        } else if (reel1B.equals(reel2B) && reel2B.equals(reel3B)) {
//            return win(reel1B, reel2B, reel3B);
//        } else if (reel1C.equals(reel2B) && reel2B.equals(reel3A)) {
//            return win(reel1C, reel2B, reel3A);
//        } else {
//            return lose();
//        }
//    }

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