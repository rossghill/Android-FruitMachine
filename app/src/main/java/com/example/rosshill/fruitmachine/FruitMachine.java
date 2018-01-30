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
// TODO: 30/01/2018 make the function take in the random numbers so its testable 
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
            else if (randomPosition == reel1.size() - 1)  {
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


    public int spin() {

        ArrayList<ArrayList<Symbol>> playfield = getPlayfield();
//        System.out.println(playfield);
        if (playfield.get(0).get(0).equals(playfield.get(1).get(1)) && playfield.get(1).get(1).equals(playfield.get(2).get(2))) {
            return calculateWinnings(playfield.get(1).get(1));
        } else if (playfield.get(0).get(1).equals(playfield.get(1).get(1)) && playfield.get(1).get(1).equals(playfield.get(2).get(1))) {
            return calculateWinnings(playfield.get(1).get(1));
        } else if (playfield.get(0).get(2).equals(playfield.get(1).get(1)) && playfield.get(1).get(1).equals(playfield.get(2).get(0))) {
            return calculateWinnings(playfield.get(1).get(1));
        } else {
            return lose();
        }
    }

    public int calculateWinnings(Symbol symbol) {
        return symbol.getValue() * 3;
    }

    public int lose() {
        return 0;
    }
}