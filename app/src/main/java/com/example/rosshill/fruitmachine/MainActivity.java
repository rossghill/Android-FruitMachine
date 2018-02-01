package com.example.rosshill.fruitmachine;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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

        fruitMachine = new FruitMachine(0.50);

        player1 = new Player("Ross", 2.50);
        new_game = new Game(fruitMachine, player1);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("name");
        player1.setName(name);


        welcomeBox = findViewById(R.id.textView);
        welcomeBox.setText(String.valueOf(new_game.welcomeMessage()));

    }

    public void onSpinButtonClick(View spinButton) {

        Random random = new Random();
        int randomReel1 = random.nextInt(fruitMachine.reel1.size());
        int randomReel2 = random.nextInt(fruitMachine.reel1.size());
        int randomReel3 = random.nextInt(fruitMachine.reel1.size());
        String result = new_game.startGame(randomReel1, randomReel2, randomReel3);

        ImageView reel10img = findViewById(R.id.reel1_0);
        reel10img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(0).get(0).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel11img = findViewById(R.id.reel1_1);
        reel11img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(0).get(1).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel12img = findViewById(R.id.reel1_2);
        reel12img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(0).get(2).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel20img = findViewById(R.id.reel2_0);
        reel20img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(1).get(0).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel21img = findViewById(R.id.reel2_1);
        reel21img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(1).get(1).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel22img = findViewById(R.id.reel2_2);
        reel22img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(1).get(2).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel30img = findViewById(R.id.reel3_0);
        reel30img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(2).get(0).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel31img = findViewById(R.id.reel3_1);
        reel31img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(2).get(1).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));
        ImageView reel32img = findViewById(R.id.reel3_2);
        reel32img.setImageResource(getResources().getIdentifier(fruitMachine.getPlayfield().get(2).get(2).name().toLowerCase(), "drawable", "com.example.rosshill.fruitmachine"));

              welcomeBox = findViewById(R.id.textView);
              welcomeBox.setText(String.valueOf(new_game.welcomeMessage()));

              statusBox = findViewById(R.id.status_box);
              statusBox.setText(String.valueOf(result));

        }
    }




