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
        return this.player_name;
    }

    public String setName(String name) {
        return this.player_name = name;
    }

    public double getWallet() {
        return this.wallet;
    }

    public double setWallet(double funds) {
        return this.wallet = funds;
    }

    public double spendMoney(double gameCost) {
        return this.wallet -= gameCost;
    }

    public double receiveMoney(int winAmount) {
        return this.wallet += winAmount;
    }
}
