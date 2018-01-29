package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

public class Runner {

    public static void main(String[] args) {

        FruitMachine fruitMachineFull = new FruitMachine();
        Player player = new Player("Ross", 2.50);
        Game game = new Game(fruitMachineFull, player);
        game.startGame();

    }
}

