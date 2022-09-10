package com.kacperprzelozny.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Bundle b = getIntent().getExtras();
            String result = b.getString("result");

    }
}