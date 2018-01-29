package com.example.rosshill.fruitmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public class Game {

        FruitMachine fruitMachine;
        Player player;

        public Game(FruitMachine fruitMachineFull, Player player) {
            this.fruitMachine = fruitMachineFull;
            this.player = player;
        }

        public void startGame() {
            Scanner reader = new Scanner(System.in);
            System.out.println("Welcome " + player.getName() + ", your balance is £" + player.getWallet());
            while (player.getWallet() > 0) {
                System.out.println("Type SPIN to play or QUIT to end game");
                System.out.println("Your current balance is: " + player.getWallet());
                String selection;
                selection = reader.next();
                selection = selection.toUpperCase();
                if (selection.equals("SPIN")) {
                    player.spendMoney(0.5);
                    int result = fruitMachine.spin();
                    if (result > 0) {
                        System.out.println("Congrats! You won £");
                        player.wallet += result;
                    } else {
                        System.out.println("Sorry, you lost");
                    }

                } else if (selection.equals("QUIT")) {
                    System.out.println("Thanks for playing! Your balance is £" + player.getWallet());
                    break;
                } else {
                    System.out.println("I don't recognise that command.");
                }
            }

        }

    }
}
