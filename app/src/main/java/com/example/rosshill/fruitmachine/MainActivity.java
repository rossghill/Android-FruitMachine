package com.example.rosshill.fruitmachine;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Game new_game;
    Player player1;
    FruitMachine fruitMachine;
    TextView welcomeBox;
    TextView statusBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitMachine = new FruitMachine();

        player1 = new Player("Ross", 2.50);
        new_game = new Game(fruitMachine, player1);

        welcomeBox = findViewById(R.id.textView);
        welcomeBox.setText(String.valueOf(new_game.welcomeMessage()));

        fruitMachine.getPlayfield();
    }

        public void onSpinButtonClick(View spin_button) {

                ImageView reel10img = findViewById(R.id.reel1_0);
                reel10img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(0).get(0).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));

//                reel10img.setImageResource(fruitMachine.getSymbol(reel1, 0));

//                ImageView reel11img = (ImageView) findViewById(R.id.reel1_1);
//                reel10img.setImageResource(R.drawable.cherry);
//                ImageView reel12img = (ImageView) findViewById(R.id.reel1_2);
//                reel10img.setImageResource(R.drawable.cherry);
//                ImageView reel20img = (ImageView) findViewById(R.id.reel2_0);
//                reel10img.setImageResource(R.drawable.cherry);
//                ImageView reel21img = (ImageView) findViewById(R.id.reel2_1);
//                reel10img.setImageResource(R.drawable.cherry);
//                ImageView reel22img = (ImageView) findViewById(R.id.reel2_2);
//                reel10img.setImageResource(R.drawable.cherry);
//                ImageView reel30img = (ImageView) findViewById(R.id.reel3_0);
//                reel10img.setImageResource(R.drawable.cherry);
//                ImageView reel31img = (ImageView) findViewById(R.id.reel3_1);
//                reel10img.setImageResource(R.drawable.cherry);
//                ImageView reel32img = (ImageView) findViewById(R.id.reel3_2);
//                reel10img.setImageResource(R.drawable.cherry);


//            int winnings = new_game.startGame();
//
//            statusBox = findViewById(R.id.status_box);
//            statusBox.setText(String.valueOf(winnings));
//
//            welcomeBox = findViewById(R.id.textView);
//            welcomeBox.setText(String.valueOf(new_game.welcomeMessage()));
//
////            fruitMachine.
//

        }
    }




