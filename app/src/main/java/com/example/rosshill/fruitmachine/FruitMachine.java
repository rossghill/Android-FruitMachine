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
//        this.playfield = null;
        setupReels();
    }

    public void setupReels() {
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.CHERRY);
        this.reel1.add(Symbol.ORANGE);
        this.reel1.add(Symbol.ORANGE);
        this.reel1.add(Symbol.LEMON);
        this.reel1.add(Symbol.LEMON);
        this.reel1.add(Symbol.BAR);
        this.reel1.add(Symbol.DIAMOND);
        this.reel2 = new ArrayList<>(this.reel1);
        this.reel3 = new ArrayList<>(this.reel1);
        Collections.shuffle(reel1);
        Collections.shuffle(reel2);
        Collections.shuffle(reel3);
    }

    public double getCost() {
        return cost;
    }


    public ArrayList<ArrayList<Symbol>> getPlayfield(int reel1random, int reel2random, int reel3random) {
// TODO: 31/01/2018 test it :D 
// TODO: 31/01/2018 rename this method to setupPlayfield() 
        // TODO: 31/01/2018 method should create new property on fruitMachine
        // TODO: 31/01/2018 create getter for playfield and use it in MainActivity 


        ArrayList<Symbol> reel1selection = assignPosition(reel1random);
        ArrayList<Symbol> reel2selection = assignPosition(reel2random);
        ArrayList<Symbol> reel3selection = assignPosition(reel3random);

        ArrayList<ArrayList<Symbol>> playfield = new ArrayList<ArrayList<Symbol>>();

        playfield.add(reel1selection);
        playfield.add(reel2selection);
        playfield.add(reel3selection);
        
        return playfield;
    }

    public ArrayList<Symbol> assignPosition(int random) {

        int randomPosition = random;
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

    public int spin(int reel1random, int reel2random, int reel3random) {

        ArrayList<ArrayList<Symbol>> playfield = getPlayfield(reel1random, reel2random, reel3random);
        
//        

        Symbol topLeft = playfield.get(0).get(0);
        Symbol middle = playfield.get(1).get(1);
        Symbol bottomRight = playfield.get(2).get(2);
        Symbol middleLeft = playfield.get(0).get(1);
        Symbol middleRight = playfield.get(2).get(1);
        Symbol bottomLeft = playfield.get(0).get(2);
        Symbol topRight = playfield.get(2).get(0);




        boolean downDiagonalMatch = topLeft.name().equals(middle.name()) && middle.name().equals(bottomRight.name());
        boolean middleDiagonalMatch = middleLeft.name().equals(middle.name()) && middle.name().equals(middleRight.name());
        boolean upDiagonalMatch = bottomLeft.name().equals(middle.name()) && middle.name().equals(topRight.name());


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