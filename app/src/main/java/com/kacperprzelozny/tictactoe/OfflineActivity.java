package com.kacperprzelozny.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OfflineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        for(int i = 0; i<9; i++){
            playground.add("empty");
        }
        TextView whos_move = (TextView) findViewById(R.id.whos_move);
        whos_move.setText("Krzyżyk");
    }
    ArrayList<String> playground = new ArrayList<String>();
    boolean cross = true;
    public void handleClick(View v){
        LinearLayout button = (LinearLayout) v;
        int tappedButton = Integer.parseInt(button.getTag().toString());
        ImageView img = (ImageView) button.getChildAt(0);
        if(cross && playground.get(tappedButton - 1).equals("empty")){
            playground.set(tappedButton-1, "cross");
            cross = !cross;
            img.setImageResource(R.drawable.cross);
            TextView whos_move = (TextView) findViewById(R.id.whos_move);
            whos_move.setText("Kółko");
        }
        else if(!cross && playground.get(tappedButton - 1).equals("empty")){
            playground.set(tappedButton-1, "circle");
            img.setImageResource(R.drawable.circle);
            cross = !cross;
            TextView whos_move = (TextView) findViewById(R.id.whos_move);
            whos_move.setText("Krzyżyk");
        }
        if(
                (playground.get(0)=="cross" && playground.get(1)=="cross" && playground.get(2)=="cross")
                        || (playground.get(3)=="cross" && playground.get(4)=="cross" && playground.get(5)=="cross")
                        || (playground.get(6)=="cross" && playground.get(7)=="cross" && playground.get(8)=="cross")
                        || (playground.get(0)=="cross" && playground.get(3)=="cross" && playground.get(6)=="cross")
                        || (playground.get(1)=="cross" && playground.get(4)=="cross" && playground.get(7)=="cross")
                        || (playground.get(2)=="cross" && playground.get(5)=="cross" && playground.get(8)=="cross")
                        || (playground.get(0)=="cross" && playground.get(4)=="cross" && playground.get(8)=="cross")
                        || (playground.get(2)=="cross" && playground.get(4)=="cross" && playground.get(6)=="cross")

        ){
            Intent intent = new Intent(OfflineActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putString("winner", "cross"); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
            finish();
        }
        else if(
                (playground.get(0)=="circle" && playground.get(1)=="circle" && playground.get(2)=="circle")
                        || (playground.get(3)=="circle" && playground.get(4)=="circle" && playground.get(5)=="circle")
                        || (playground.get(6)=="circle" && playground.get(7)=="circle" && playground.get(8)=="circle")
                        || (playground.get(0)=="circle" && playground.get(3)=="circle" && playground.get(6)=="circle")
                        || (playground.get(1)=="circle" && playground.get(4)=="circle" && playground.get(7)=="circle")
                        || (playground.get(2)=="circle" && playground.get(5)=="circle" && playground.get(8)=="circle")
                        || (playground.get(0)=="circle" && playground.get(4)=="circle" && playground.get(8)=="circle")
                        || (playground.get(2)=="circle" && playground.get(4)=="circle" && playground.get(6)=="circle")
        ){
            Intent intent = new Intent(OfflineActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putString("winner", "circle"); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
            finish();
        }
        else if(
                playground.get(0)!="empty"
                        && playground.get(1)!="empty"
                        && playground.get(2)!="empty"
                        && playground.get(3)!="empty"
                        && playground.get(4)!="empty"
                        && playground.get(5)!="empty"
                        && playground.get(6)!="empty"
                        && playground.get(7)!="empty"
                        && playground.get(8)!="empty"
        ){
            Intent intent = new Intent(OfflineActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putString("winner", "draw"); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
            finish();
        }
    }
}