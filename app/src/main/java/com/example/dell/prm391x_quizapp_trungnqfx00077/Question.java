package com.example.dell.prm391x_quizapp_trungnqfx00077;

import java.util.List;

public class Question {
    private String mQuestionName;
    private EQuestionType mEQuestionType;
    private List<Answer> mAnswerList;

    public Question(String questionName, EQuestionType EQuestionType, List<Answer> answerList) {
        mQuestionName = questionName;
        mEQuestionType = EQuestionType;
        mAnswerList = answerList;
    }

    enum EQuestionType {
        DEFAULT(0),
        SINGLE_CHOICE(1),
        MULTIPLE_CHOICE(2),
        FILL_IN(3);

        int type;

        EQuestionType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
