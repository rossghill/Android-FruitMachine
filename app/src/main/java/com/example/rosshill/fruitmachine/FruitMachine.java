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
        int upperNeighbour;
        int lowerNeighbour;

            if (randomPosition == 0) {
                upperNeighbour = reel1.size();
                lowerNeighbour = randomPosition + 1;}
            else if (randomPosition == reel1.size())  {
                upperNeighbour = randomPosition - 1;
                lowerNeighbour = 0;}
            else {
                upperNeighbour = randomPosition - 1;
                lowerNeighbour = randomPosition + 1;
                }

            reel1selection.add(upperNeighbour);
            reel1selection.add(randomPosition);
            reel1selection.add(lowerNeighbour);

        ArrayList playfield = new ArrayList<ArrayList>();

        playfield.add(reel1selection);

            return playfield;
            }

//        Random random2 = new Random();
//        int randomPosition2 = random2.nextInt (reel2.size());
//        Random random3 = new Random();
//        int randomPosition3 = random3.nextInt (reel3.size());
//
//
//        reel1selection.add(reel1.get(randomPosition -1));
//        reel1selection.add(reel1.get(randomPosition));
//        reel1selection.add(reel1.get(randomPosition + 1));
//
//        reel2selection.add(reel2.get(randomPosition2 - 1));
//        reel2selection.add(reel2.get(randomPosition2));
//        reel2selection.add(reel2.get(randomPosition2 + 1));
//
//        reel3selection.add(reel3.get(randomPosition3 - 1));
//        reel3selection.add(reel3.get(randomPosition3));
//        reel3selection.add(reel3.get(randomPosition3 + 1));

//        ArrayList playfield = new ArrayList<ArrayList>();
//
//        playfield.add(reel1selection);
//        playfield.add(reel2selection);
//        playfield.add(reel3selection);
//
//        return playfield;


    public int spin() {

        ArrayList<ArrayList<Symbol>> playfield = getPlayfield();
        System.out.println(playfield);
        if (reel1.get(0).equals(reel2.get(1)) && reel1.get(1).equals(reel3.get(2))) {
            return win(reel1.get(0), reel2.get(1), reel3.get(2));
        } else if (reel1.get(1).equals(reel2.get(1)) && reel2.get(1).equals(reel3.get(1))) {
            return win(reel1.get(1), reel2.get(1),reel3.get(1));
        } else if (reel1.get(2).equals(reel2.get(1)) && reel2.get(1).equals(reel3.get(0))) {
            return win(reel1.get(2), reel2.get(1), reel3.get(0));
        } else {
            return lose();
        }
    }

    public int win(Symbol winningReel1, Symbol winningReel2, Symbol winningReel3) {
        int value1 = winningReel1.getValue();
        int value2 = winningReel2.getValue();
        int value3 = winningReel3.getValue();
        System.out.println(value1 + value2 + value3);
        return value1 + value2 + value3;

    }

    public int lose() {
        System.out.println("You lost");
        return 0;
    }
}