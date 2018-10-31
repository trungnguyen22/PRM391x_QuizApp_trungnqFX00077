package com.example.dell.prm391x_quizapp_trungnqfx00077;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionFactory {

    public static List<Question> makeQuestionList() {
        return Arrays.asList(
                makeQuestion("What is Deoxyribonucleic acid commonly referred to as?", Question.EQuestionType.SINGLE_CHOICE, 1),
                makeQuestion("What process involves treating rubber with sulfur to harden it?", Question.EQuestionType.FILL_IN, 2),
                makeQuestion("Name two different organelles of a eukaryotic cell.", Question.EQuestionType.MULTIPLE_CHOICE, 3),
                makeQuestion("This word describes the force that pulls objects to the middle of the earth?", Question.EQuestionType.FILL_IN, 4),
                makeQuestion("What type of trees yield the resin used to produce turpentine?", Question.EQuestionType.SINGLE_CHOICE, 5),
                makeQuestion("Cumulus and Cirrus are types of what?", Question.EQuestionType.FILL_IN, 6),
                makeQuestion("Which two planets have one or more moons?", Question.EQuestionType.MULTIPLE_CHOICE, 7),
                makeQuestion("Where in the human body would you find the scaphoid bone?", Question.EQuestionType.FILL_IN, 8),
                makeQuestion("Which grow upwards Stalactites or Stalagmites?", Question.EQuestionType.SINGLE_CHOICE, 9),
                makeQuestion("What process involves heating an ore to obtain a metal?", Question.EQuestionType.FILL_IN, 10)
        );
    }

    public static Question makeQuestion(String questionName, Question.EQuestionType eQuestionType, int questionNumber) {
        return new Question(questionName, eQuestionType, makeAnswerList(questionNumber));
    }

    public static List<Answer> makeAnswerList(int questionNumber) {
        List<Answer> answerList = new ArrayList<>();
        switch (questionNumber) {
            case 1:
                answerList.add(new Answer("RNA", false));
                answerList.add(new Answer("CIA", false));
                answerList.add(new Answer("DNA", true));
                return answerList;
            case 2:
                answerList.add(new Answer("Vulcanizing", true));
                return answerList;
            case 3:
                answerList.add(new Answer("Ribosome", false));
                answerList.add(new Answer("Plasmids", false));
                answerList.add(new Answer("Golgi apparatus", true));
                answerList.add(new Answer("Diploid", false));
                return answerList;
            case 4:
                answerList.add(new Answer("Gravity", true));
                return answerList;
            case 5:
                answerList.add(new Answer("Palm trees", false));
                answerList.add(new Answer("Pine trees", true));
                answerList.add(new Answer("Oak trees", true));
                return answerList;
            case 6:
                answerList.add(new Answer("Clouds", true));
                answerList.add(new Answer("Cloud", true));
                return answerList;
            case 7:
                answerList.add(new Answer("Ceres", false));
                answerList.add(new Answer("Mercury", false));
                answerList.add(new Answer("Earth", false));
                answerList.add(new Answer("Pluto", true));
                return answerList;
            case 8:
                answerList.add(new Answer("Wrist", true));
                return answerList;
            case 9:
                answerList.add(new Answer("Stalactites", false));
                answerList.add(new Answer("Stalagmites", false));
                return answerList;
            case 10:
                answerList.add(new Answer("Smelting", true));
                return answerList;
            default:
                return answerList;
        }
    }
}
