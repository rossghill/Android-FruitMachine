package com.example.rosshill.fruitmachine;

import java.util.ArrayList;

/**
 * Created by rosshill on 28/01/2018.
 */

public class Runner {

    public static void main(String[] args) {

        FruitMachine fruitMachine = new FruitMachine();
        Player player = new Player("Ross", 2.50);
        Game game = new Game(fruitMachine, player);
//        game.startGame();
        System.out.println(game.fruitMachine.spin());
//        System.out.println(game.fruitMachine.getSymbol(reel1, 0));

    }
}

