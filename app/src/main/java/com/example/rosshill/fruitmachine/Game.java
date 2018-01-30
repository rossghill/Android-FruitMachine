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
        player.spendMoney(0.50);
        fruitMachine.getPlayfield();
//        fruitMachine.spin();
    }
}




//    public void startGame() {
//        Scanner reader = new Scanner(System.in);
//        welcomeMessage();
//        while (player.getWallet() > 0) {
//            System.out.println("Type SPIN to play or QUIT to end game");
//            System.out.println("Your current balance is: £" + player.getWallet() + "0");
//            String selection;
//            selection = reader.next();
//            selection = selection.toUpperCase();
//            if (selection.equals("SPIN")) {
//                player.spendMoney(0.5);
//                int result = fruitMachine.spin();
//                if (result > 0) {
//                    System.out.println("Congrats! You won £");
//                    player.wallet += result;
//                } else {
//                    System.out.println("Sorry, you lost");
//                }
//
//            } else if (selection.equals("QUIT")) {
//                System.out.println("Thanks for playing! Your balance is £" + player.getWallet() + "0");
//                break;
//            } else {
//                System.out.println("I don't recognise that command.");
//            }
//        }


