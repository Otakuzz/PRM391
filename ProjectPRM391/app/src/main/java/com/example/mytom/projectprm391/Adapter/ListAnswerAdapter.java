package com.example.mytom.projectprm391.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mytom.projectprm391.Item.MultipleChoiceAnswer;
import com.example.mytom.projectprm391.Item.QuestionSets;
import com.example.mytom.projectprm391.R;

import java.util.ArrayList;

/**
 * Created by Mytom on 3/16/2017.
 */

public class ListAnswerAdapter extends ArrayAdapter
{
    ArrayList<MultipleChoiceAnswer> list_answer;
    Activity activity;
    public ListAnswerAdapter(Activity context, int resource, ArrayList<MultipleChoiceAnswer> exams) {
        super(context, resource, exams);
        this.list_answer = exams;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.layout_item_answer_title,null);
            TextView answerChoice = (TextView) view.findViewById(R.id.txt_answer_to_choice);
            TextView answerTitle = (TextView) view.findViewById(R.id.txt_title_answer);
            char c = (char)(position + 65);
            answerChoice.setText(c+". ");
            answerTitle.setText(list_answer.get(position).getAnswerTitle());
        }
        return view;
    }
}

