package com.example.mytom.projectprm391.Item;

import java.io.Serializable;

/**
 * Created by Mytom on 3/15/2017.
 */

public class MultipleChoiceAnswer implements Serializable{
    private String questionID;
    private String answerTitle;
    private String answerID;
    private boolean isChecked;

    public MultipleChoiceAnswer(String questionID, String answerTitle, String answerID, boolean isChecked) {
        this.questionID = questionID;
        this.answerTitle = answerTitle;
        this.answerID = answerID;
        this.isChecked = isChecked;
    }

    public MultipleChoiceAnswer(String answerTitle, boolean isChecked) {
        this.answerTitle = answerTitle;
        this.isChecked = isChecked;
    }

    public MultipleChoiceAnswer() {
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
