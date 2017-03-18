package com.example.mytom.projectprm391.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mytom.projectprm391.Item.QuestionSets;
import com.example.mytom.projectprm391.R;

import java.util.ArrayList;

/**
 * Created by Mytom on 3/9/2017.
 */

public class ListExamAdapter  extends ArrayAdapter{
    ArrayList<QuestionSets> list_exam;
    Activity activity;
    public ListExamAdapter(Activity context, int resource, ArrayList<QuestionSets> exams) {
        super(context, resource, exams);
        this.list_exam = exams;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.layout_entity_exam,null);
            TextView nameExam = (TextView) view.findViewById(R.id.name_exam_entity);
            QuestionSets exam = list_exam.get(position);
            nameExam.setText(exam.getName());
            if (position % 2 == 0){
                nameExam.setBackgroundColor(view.getResources().getColor(R.color.colorItem));
            }
        }
        return view;
    }
}
