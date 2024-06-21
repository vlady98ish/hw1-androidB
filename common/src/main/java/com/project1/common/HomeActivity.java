package com.project1.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Button startGameButton;
    private TextView adsIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViews();
        initializeUI();
    }

    private void findViews() {
        startGameButton = findViewById(R.id.home_BTN_startGame);
        adsIdTextView = findViewById(R.id.home_TV_ADS_ID);
    }

    private void initializeUI() {
        adsIdTextView.setText(AppParent.ADS_ID);
        startGameButton.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, GameActivity.class)));
    }
}