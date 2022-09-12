package com.kacperprzelozny.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Bundle b = getIntent().getExtras();
        String resultText = b.getString("winner");
        String resultInfoOnView;
        TextView result = (TextView) findViewById(R.id.resultInfo);
        if(resultText.equals("cross"))
            resultInfoOnView = "Wygrywa: krzyżyk";
        else if(resultText.equals("circle"))
            resultInfoOnView = "Wygrywa: kółko";
        else resultInfoOnView = "Remis";
        result.setText(resultInfoOnView);

        Button backToMenu = (Button) findViewById(R.id.backToMenu);
        backToMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(switchActivityIntent);
            }
        });

        Button playAgain = (Button) findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(ResultActivity.this, OfflineActivity.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}