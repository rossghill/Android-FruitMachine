package com.example.rosshill.fruitmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.widget.TextView;


public class OpenScreen extends AppCompatActivity {

    EditText nameText;
    Button begin_button;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_screen);

        nameText = findViewById(R.id.name);
    }

    public void onBeginButtonClicked(View begin_button) {

        String enteredName = nameText.getText().toString();
        double gameCost = 0.50;
//
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", enteredName);
        intent.putExtra("game_cost", gameCost);

        startActivity(intent);
    }

}
