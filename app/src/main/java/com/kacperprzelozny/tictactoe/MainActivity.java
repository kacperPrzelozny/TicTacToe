package com.kacperprzelozny.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button onlineButton = (Button) findViewById(R.id.online);
        onlineButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        Button offlineButton = (Button) findViewById(R.id.offline);
        offlineButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchActivities();
            }
        });
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, OfflineActivity.class);
        startActivity(switchActivityIntent);
    }
}