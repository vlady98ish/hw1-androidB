package com.project1.common;

import android.content.Context;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static Question[] readQuestions(Context context, String fileName){
        Gson gson = new Gson();
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            Reader reader = new InputStreamReader(inputStream);
            Question[] questions = gson.fromJson(reader, Question[].class);
            reader.close();
            inputStream.close();
            return questions;
        } catch (IOException e) {
            e.printStackTrace();
            return new Question[0];
        }
    }

    public static String[] ShuffleArray(String[] arr){
        List<String> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
        return arr;
    }
}
