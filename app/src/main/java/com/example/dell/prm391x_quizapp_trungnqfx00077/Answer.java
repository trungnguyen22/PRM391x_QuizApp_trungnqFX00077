package com.example.dell.prm391x_quizapp_trungnqfx00077;

public class Answer {
    private String mAnswerName;
    private boolean mIsCorrect;

    public Answer(String answerName, boolean isCorrect) {
        mAnswerName = answerName;
        mIsCorrect = isCorrect;
    }

    public String getAnswerName() {
        return mAnswerName;
    }

    public void setAnswerName(String answerName) {
        mAnswerName = answerName;
    }

    public boolean isCorrect() {
        return mIsCorrect;
    }

    public void setCorrect(boolean correct) {
        mIsCorrect = correct;
    }
}
