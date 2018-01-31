package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

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

    public String startGame(int randomReel1, int randomReel2, int randomReel3) {
        if (player.getWallet() > 0) {
            player.spendMoney(fruitMachine.getCost());
            int winAmount = fruitMachine.spin(randomReel1, randomReel2, randomReel3);
            if (winAmount > 0) {
                player.receiveMoney(winAmount);
                return "Congrats, you won £" + winAmount;
            } else {
                return "Sorry, no matching symbols";
            }
        }
        return "Sorry, not enough funds.";
    }
}