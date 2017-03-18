package com.example.mytom.projectprm391.Item;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mytom on 3/9/2017.
 */

public class QuestionEntity implements Serializable{
    private String name;
    private String setID;
    private String type;
    private String ImagePath;
    private String questionID;
    private String questionTitle;
    private ArrayList<MultipleChoiceAnswer> answers;
    private boolean isCorrect;
    private String answerCorrect;

    public QuestionEntity(String name, String setID, String type, String imagePath, String questionID, String questionTitle,ArrayList<MultipleChoiceAnswer> answers, boolean isCorrect, String answerCorrect) {
        this.name = name;
        this.setID = setID;
        this.type = type;
        this.ImagePath = imagePath;
        this.answers = answers;
        this.questionID = questionID;
        this.questionTitle = questionTitle;

        this.isCorrect = isCorrect;
        this.answerCorrect = answerCorrect;
    }

    public ArrayList<MultipleChoiceAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<MultipleChoiceAnswer> answers) {
        this.answers = answers;
    }

    public String getSetID() {
        return setID;
    }

    public void setSetID(String setID) {
        this.setID = setID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public QuestionEntity(String name, String question, ArrayList<MultipleChoiceAnswer> answer) {
        this.questionTitle = question;
        this.answers = answer;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return questionTitle;
    }

    public void setQuestion(String question) {
        this.questionTitle = question;
    }




}
