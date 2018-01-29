package com.example.rosshill.fruitmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Game new_game;
    Player player1;
    FruitMachine fruitMachine;
    TextView welcomeBox;
    TextView statusBox;

    TextView reel1A;
    TextView reel1B;
    TextView reel1C;
    TextView reel2A;
    TextView reel2B;
    TextView reel2C;
    TextView reel3A;
    TextView reel3B;
    TextView reel3C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = new Player("Ross", 2.50);
        new_game = new Game(fruitMachine, player1);

        welcomeBox = findViewById(R.id.textView);
        welcomeBox.setText(String.valueOf(new_game.welcomeMessage()));
    }

        public void onSpinButtonClick(View spin_button) {
            new_game.startGame();
            statusBox = findViewById(R.id.status_box);
            statusBox.setText(R.string.lose_text);

            welcomeBox = findViewById(R.id.textView);
            welcomeBox.setText(String.valueOf(new_game.welcomeMessage()));
//
//            reel1A = findViewById(R.id.reel1A);
//            reel1A.setText(String.valueOf(reel1A));
        }
    }

