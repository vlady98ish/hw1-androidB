package com.project1.common;

public class Question {
    private String question;
    private String[] options;
    private String answer;

    public Question(){}

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String[] getOptions() {
        return options;
    }

    public Question setOptions(String[] options){
        this.options = options;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Question setAnswer(String answer) {
        this.answer = answer;
        return this;
    }
}
