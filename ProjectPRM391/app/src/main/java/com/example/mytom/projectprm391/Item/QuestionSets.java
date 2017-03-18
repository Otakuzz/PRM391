package com.example.mytom.projectprm391.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by Mytom on 3/9/2017.
 */

public class QuestionSets implements Serializable{
    private String setSame;
    private String setID;
    private String UserID;
    private Timer timeLimited;
    private int totalQuestion;
    private boolean isSaved;

    private ArrayList<QuestionEntity> questions;

    public QuestionSets(String setSame, String setID, String userID, Timer timeLimited, int totalQuestion, boolean isSaved, ArrayList<QuestionEntity> questions) {
        this.setSame = setSame;
        this.setID = setID;
        UserID = userID;
        this.timeLimited = timeLimited;
        this.totalQuestion = totalQuestion;
        this.isSaved = isSaved;
        this.questions = questions;
    }

    public String getSetSame() {
        return setSame;
    }

    public void setSetSame(String setSame) {
        this.setSame = setSame;
    }

    public String getSetID() {
        return setID;
    }

    public void setSetID(String setID) {
        this.setID = setID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public Timer getTimeLimited() {
        return timeLimited;
    }

    public void setTimeLimited(Timer timeLimited) {
        this.timeLimited = timeLimited;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public QuestionSets(String name, ArrayList<QuestionEntity> questions) {
        this.setSame = name;
        this.questions = questions;
    }

    public QuestionSets() {
    }

    public String getName() {
        return setSame;
    }

    public void setName(String name) {
        this.setSame = name;
    }

    public ArrayList<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionEntity> questions) {
        this.questions = questions;
    }
}
