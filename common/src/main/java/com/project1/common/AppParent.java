package com.project1.common;

import android.app.Application;

public abstract class AppParent extends Application {

    public static Question[] questions;
    public static String ADS_ID;
    protected abstract  Question[] generateQuestions();
    protected abstract String getAdsId();
    @Override
    public void onCreate(){
        super.onCreate();
        ADS_ID = this.getAdsId();
        questions = this.generateQuestions();
        for(int i = 0; i < questions.length; i++){
            questions[i].setOptions(Utils.ShuffleArray(questions[i].getOptions()));
        }

    }
}
