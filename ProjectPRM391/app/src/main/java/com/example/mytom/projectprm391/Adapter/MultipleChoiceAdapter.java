package com.example.mytom.projectprm391.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.mytom.projectprm391.Item.MultipleChoiceAnswer;
import com.example.mytom.projectprm391.R;

import java.util.ArrayList;

/**
 * Created by Mytom on 3/16/2017.
 */

public class MultipleChoiceAdapter extends ArrayAdapter {
    ArrayList<MultipleChoiceAnswer> multichoice;
    Activity activity;


    public MultipleChoiceAdapter(Activity context, int resource, ArrayList<MultipleChoiceAnswer> exams) {
        super(context, resource, exams);
        this.multichoice = exams;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.layout_entity_answer_multiple,null);
            TextView textAnswer = (TextView) view.findViewById(R.id.text_answer_test_exam);
            final CheckBox rdbCheck = (CheckBox) view.findViewById(R.id.checkbox_answer_test_exam);
            if(multichoice.get(position).isChecked()){
                rdbCheck.setChecked(true);
            }
            rdbCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(rdbCheck.isChecked()){
                        multichoice.get(position).setChecked(true);

                    } else {
                        multichoice.get(position).setChecked(false);
                    }
                }
            });


            char c = (char)(position+65);
            textAnswer.setText(c+"");
        }
        return view;
    }
}
