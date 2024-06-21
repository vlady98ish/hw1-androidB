package com.project1.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Button home_BTN_startGame;
    private TextView home_TV_ADS_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_BTN_startGame  = findViewById(R.id.home_BTN_startGame);
        home_TV_ADS_ID = findViewById(R.id.home_TV_ADS_ID);

        home_TV_ADS_ID.setText(AppParent.ADS_ID);
        home_BTN_startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GameActivity.class));
            }
        });

    }
}