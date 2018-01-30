package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FruitMachine {

    public ArrayList<Symbol> reel1;
    public ArrayList<Symbol> reel2;
    public ArrayList<Symbol> reel3;


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


        ArrayList reel1selection = assignPosition();
        ArrayList reel2selection = assignPosition();
        ArrayList reel3selection = assignPosition();

        ArrayList playfield = new ArrayList<ArrayList>();

        playfield.add(reel1selection);
        playfield.add(reel2selection);
        playfield.add(reel3selection);

        return playfield;
    }

    public ArrayList assignPosition() {
        Random random = new Random();
        int randomPosition = random.nextInt (reel1.size());
        int upperNeighbour;
        int lowerNeighbour;
        ArrayList reelselection = new ArrayList();

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

        reelselection.add(upperNeighbour);
        reelselection.add(randomPosition);
        reelselection.add(lowerNeighbour);

        return reelselection;
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