package com.example.rosshill.fruitmachine;

/**
 * Created by rosshill on 28/01/2018.
 */

public class Player {

    String player_name;
    double wallet;

    public Player (String player_name, double wallet) {
        this.player_name = player_name;
        this.wallet = wallet;
    }

    public String getName() {
        return player_name;
    }

    public double getWallet() {
        return wallet;
    }

    public double spendMoney(double gameCost) {
        return wallet -= gameCost;
    }
}
