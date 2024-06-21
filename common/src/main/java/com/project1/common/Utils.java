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

    public static Question[] loadQuestionsFromAssets(Context context, String fileName) {
        Gson gson = new Gson();
        try (InputStream inputStream = context.getAssets().open(fileName);
             Reader reader = new InputStreamReader(inputStream)) {

            return gson.fromJson(reader, Question[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Question[0];
        }
    }

    public static String[] shuffleArray(String[] array) {
        List<String> list = Arrays.asList(array);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}
