package com.project1.food;

import com.project1.common.AppParent;
import com.project1.common.Question;
import com.project1.common.Utils;


public class App extends AppParent {

    @Override
    protected  Question[] generateQuestions() {
        return Utils.loadQuestionsFromAssets(this, "sport_questions.json");
    }

    @Override
    protected String getAdsId() {
        return BuildConfig.ADS_ID;
    }
}
