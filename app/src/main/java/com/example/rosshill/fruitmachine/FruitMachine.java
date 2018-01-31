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
    double cost;


    public FruitMachine(double cost) {
        this.reel1 = new ArrayList<>();
        this.reel2 = new ArrayList<>();
        this.reel3 = new ArrayList<>();
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }


    public ArrayList<ArrayList<Symbol>> getPlayfield() {
// TODO: 30/01/2018 make the function take in the random numbers so its testable


        ArrayList<Symbol> reel1selection = assignPosition();
        ArrayList<Symbol> reel2selection = assignPosition();
        ArrayList<Symbol> reel3selection = assignPosition();

        ArrayList<ArrayList<Symbol>> playfield = new ArrayList<ArrayList<Symbol>>();

        playfield.add(reel1selection);
        playfield.add(reel2selection);
        playfield.add(reel3selection);

        return playfield;
    }

    public ArrayList<Symbol> assignPosition() {
        Random random = new Random();
        int randomPosition = random.nextInt(reel1.size());
        int upperNeighbourPosition;
        int lowerNeighbourPosition;
        ArrayList<Symbol> reelSelection = new ArrayList();

        if (randomPosition == 0) {
            upperNeighbourPosition = reel1.size();
            lowerNeighbourPosition = randomPosition + 1;}
        else if (randomPosition == reel1.size() - 1)  {
            upperNeighbourPosition = randomPosition - 1;
            lowerNeighbourPosition = 0;}
        else {
            upperNeighbourPosition = randomPosition - 1;
            lowerNeighbourPosition = randomPosition + 1;
        }

        Symbol upperSymbol = reelSelection.get(upperNeighbourPosition);
        reelSelection.add(upperSymbol);
        Symbol middleSymbol = reelSelection.get(randomPosition);
        reelSelection.add(middleSymbol);
        Symbol lowerSymbol = reelSelection.get(lowerNeighbourPosition);
        reelSelection.add(lowerSymbol);


        return reelSelection;
            }

    public int spin() {

        ArrayList<ArrayList<Symbol>> playfield = getPlayfield();

        Symbol topLeft = playfield.get(0).get(0);
        Symbol middle = playfield.get(1).get(1);
        Symbol bottomRight = playfield.get(2).get(2);

        boolean downDiagonalMatch = topLeft.equals(middle) && middle.equals(bottomRight);


        if (downDiagonalMatch) {
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