package com.project1.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class GameActivity extends AppCompatActivity {

    private RadioGroup game_RBG_options;
    private TextView game_TV_question, game_TV_answer;
    private MaterialButton game_BTN_next, game_BTN_exit;
    private int currentQuestion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViews();
        initVars();


    }



    private void initVars() {
        setUIQuestion(currentQuestion);
        game_BTN_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        game_BTN_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestion++ ;
                if(currentQuestion < AppParent.questions.length){
                    setUIQuestion(currentQuestion);
                    game_TV_answer.setVisibility(View.INVISIBLE);
                    clearChecked();
                }
                else{
                    finish();
                }
            }
        });

        game_RBG_options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedId);
                if(rb != null && rb.isChecked() && currentQuestion < AppParent.questions.length){
                    String answer = AppParent.questions[currentQuestion].getAnswer();
                    if(rb.getText().toString().equals(answer)){
                        game_TV_answer.setText("Correct answer!");
                        game_TV_answer.setTextColor(Color.GREEN);
                        game_TV_answer.setBackgroundColor(Color.BLACK);
                    }else{
                        game_TV_answer.setTextColor(Color.RED);
                        game_TV_answer.setText("Wrong answer, the correct answer is: " + answer);
                    }
                    game_TV_answer.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    public void findViews(){
        game_BTN_next = findViewById(R.id.game_BTN_next);
        game_BTN_exit = findViewById(R.id.game_BTN_exit);
        game_TV_question = findViewById(R.id.game_TV_question);
        game_TV_answer = findViewById(R.id.game_TV_answer);
        game_RBG_options = findViewById(R.id.game_RBG_options);

    }

    private void setUIQuestion(int index){
       String[] options = AppParent.questions[index].getOptions();
       for(int i = 0; i < game_RBG_options.getChildCount(); i++){
          RadioButton rb = (RadioButton) game_RBG_options.getChildAt(i);
          rb.setText(options[i]);
       }
       game_TV_question.setText(AppParent.questions[index].getQuestion());

    }

    private void clearChecked(){
        for(int i = 0; i < game_RBG_options.getChildCount(); i++){
            RadioButton radioButton = (RadioButton) game_RBG_options.getChildAt(i);
            radioButton.setChecked(false);
        }
    }
}