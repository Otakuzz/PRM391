package com.example.mytom.projectprm391.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mytom.projectprm391.Item.MultipleChoiceAnswer;
import com.example.mytom.projectprm391.Item.QuestionEntity;
import com.example.mytom.projectprm391.Item.QuestionSets;
import com.example.mytom.projectprm391.R;

import java.util.ArrayList;

/**
 * Created by Mytom on 3/16/2017.
 */

public class ListNumberQuestionAdapter extends ArrayAdapter {
    ArrayList<QuestionEntity> list_question;
    Activity activity;
    public ListNumberQuestionAdapter(Activity context, int resource, ArrayList<QuestionEntity> exams) {
        super(context, resource, exams);
        this.list_question = exams;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.layout_item_number_question,null);
            TextView numberquestion = (TextView) view.findViewById(R.id.number_question);
                ArrayList<MultipleChoiceAnswer> answers = list_question.get(position).getAnswers();
                for(int i = 0; i < answers.size(); i++){
                    if(answers.get(i).isChecked()){
                       numberquestion.setBackground(view.getResources().getDrawable(R.color.colorChecked));
                    }
                }

            numberquestion.setText(position+1+"");

        }
        return view;
    }
}