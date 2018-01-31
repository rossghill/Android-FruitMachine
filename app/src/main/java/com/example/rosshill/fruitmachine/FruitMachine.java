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


        if (randomPosition == 0) {
            upperNeighbourPosition = reel1.size() - 1;
            lowerNeighbourPosition = randomPosition + 1;
        }
        else if (randomPosition == reel1.size() - 1)  {
            upperNeighbourPosition = randomPosition - 1;
            lowerNeighbourPosition = 0;
        }
        else {
            upperNeighbourPosition = randomPosition - 1;
            lowerNeighbourPosition = randomPosition + 1;
        }

        return assignSelections(reel1, upperNeighbourPosition, randomPosition, lowerNeighbourPosition);


            }

    private ArrayList<Symbol> assignSelections(ArrayList<Symbol> reel, int upperNeighbourPosition, int middlePosition, int lowerNeighbourPosition) {
        ArrayList<Symbol> reelSelection = new ArrayList();

        Symbol upperSymbol = reel.get(upperNeighbourPosition);
        reelSelection.add(upperSymbol);
        Symbol middleSymbol = reel.get(middlePosition);
        reelSelection.add(middleSymbol);
        Symbol lowerSymbol = reel.get(lowerNeighbourPosition);
        reelSelection.add(lowerSymbol);
        return reelSelection;
    }

    public int spin() {

        ArrayList<ArrayList<Symbol>> playfield = getPlayfield();

        Symbol middle = playfield.get(1).get(1);
        Symbol topLeft = playfield.get(0).get(0);
        Symbol topRight = playfield.get(2).get(0);
        Symbol middleLeft = playfield.get(0).get(1);
        Symbol middleRight = playfield.get(2).get(1);
        Symbol bottomLeft = playfield.get(0).get(2);
        Symbol bottomRight = playfield.get(2).get(2);

        boolean downDiagonalMatch = topLeft.equals(middle) && middle.equals(bottomRight);
        boolean middleDiagonalMatch = middleLeft.equals(middle) && middle.equals(middleRight);
        boolean upDiagonalMatch = bottomLeft.equals(middle) && middle.equals(topRight);


        if (downDiagonalMatch) {
            return calculateWinnings(playfield.get(1).get(1));
        } else if (middleDiagonalMatch) {
            return calculateWinnings(playfield.get(1).get(1));
        } else if (upDiagonalMatch) {
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