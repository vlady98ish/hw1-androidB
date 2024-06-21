package com.project1.common;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class GameActivity extends AppCompatActivity {

    private RadioGroup gameOptionsRadioGroup;
    private TextView gameQuestionTextView, gameAnswerTextView;
    private MaterialButton nextButton, exitButton;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViews();
        initializeVariables();
    }

    private void initializeVariables() {
        updateUIWithQuestion(currentQuestionIndex);

        exitButton.setOnClickListener(view -> finish());

        nextButton.setOnClickListener(view -> {
            currentQuestionIndex++;
            if (currentQuestionIndex < AppParent.questions.length) {
                updateUIWithQuestion(currentQuestionIndex);
                gameAnswerTextView.setVisibility(View.INVISIBLE);
                clearCheckedOptions();
            } else {
                finish();
            }
        });

        gameOptionsRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            if (selectedRadioButton != null && selectedRadioButton.isChecked() && currentQuestionIndex < AppParent.questions.length) {
                String correctAnswer = AppParent.questions[currentQuestionIndex].getAnswer();
                if (selectedRadioButton.getText().toString().equals(correctAnswer)) {
                    gameAnswerTextView.setText("Correct answer!");
                    gameAnswerTextView.setTextColor(Color.GREEN);
                    gameAnswerTextView.setBackgroundColor(Color.BLACK);
                } else {
                    gameAnswerTextView.setTextColor(Color.RED);
                    gameAnswerTextView.setText("Wrong answer, the correct answer is: " + correctAnswer);
                }
                gameAnswerTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void findViews() {
        nextButton = findViewById(R.id.game_BTN_next);
        exitButton = findViewById(R.id.game_BTN_exit);
        gameQuestionTextView = findViewById(R.id.game_TV_question);
        gameAnswerTextView = findViewById(R.id.game_TV_answer);
        gameOptionsRadioGroup = findViewById(R.id.game_RBG_options);
    }

    private void updateUIWithQuestion(int index) {
        String[] options = AppParent.questions[index].getOptions();
        for (int i = 0; i < gameOptionsRadioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) gameOptionsRadioGroup.getChildAt(i);
            radioButton.setText(options[i]);
        }
        gameQuestionTextView.setText(AppParent.questions[index].getQuestion());
    }

    private void clearCheckedOptions() {
        for (int i = 0; i < gameOptionsRadioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) gameOptionsRadioGroup.getChildAt(i);
            radioButton.setChecked(false);
        }
    }
}