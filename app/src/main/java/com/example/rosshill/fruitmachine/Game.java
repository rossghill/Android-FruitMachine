package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Game {

    FruitMachine fruitMachine;
    Player player;

    public Game(FruitMachine fruitMachine, Player player) {
        this.fruitMachine = fruitMachine;
        this.player = player;
    }

    public String welcomeMessage() {
        return "Welcome " + player.getName() + ", your balance is £" + player.getWallet() + "0";
    }

    public void startGame() {
        if (player.getWallet() > 0) {
            player.spendMoney(fruitMachine.getCost());
            fruitMachine.getPlayfield();
            fruitMachine.spin();
        } else {

        }
    }
}



