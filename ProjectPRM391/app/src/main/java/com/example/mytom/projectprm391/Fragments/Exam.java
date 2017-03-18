package com.example.mytom.projectprm391.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mytom.projectprm391.Adapter.ListExamAdapter;
import com.example.mytom.projectprm391.Item.MultipleChoiceAnswer;
import com.example.mytom.projectprm391.Item.QuestionSets;
import com.example.mytom.projectprm391.Item.QuestionEntity;
import com.example.mytom.projectprm391.R;
import com.example.mytom.projectprm391.TestingActivity;

import java.util.ArrayList;

/**
 * Created by Mytom on 3/7/2017.
 */

public class Exam extends Fragment {
    private ArrayList<QuestionSets> exams;
    private ListView list_exam_lv;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_exam,container,false);
        addListExam();
        ListExamAdapter adapter = new ListExamAdapter(getActivity(),R.layout.layout_entity_exam,exams);
        list_exam_lv = (ListView) view.findViewById(R.id.list_exam_home);
        list_exam_lv.setAdapter(adapter);
        list_exam_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QuestionSets questionSets = exams.get(position);
                Intent intent = new Intent(getActivity(), TestingActivity.class);
                intent.putExtra("questionExam", questionSets);
                intent.putExtra("nameExam",questionSets.getName());

                startActivity(intent);

            }
        });
        return view;
    }
    public void addListExam(){
        exams = new ArrayList<>();
        ArrayList<QuestionEntity> questionEntities = new ArrayList<>();
        ArrayList<MultipleChoiceAnswer> answers = new ArrayList<>();
        answers.add(new MultipleChoiceAnswer("Ha Noi 1",false));
        answers.add(new MultipleChoiceAnswer("Hai Phong 1 ",false));
        answers.add(new MultipleChoiceAnswer("Hai Duong 1",false));
        answers.add(new MultipleChoiceAnswer("Ha Noi",false));
        questionEntities.add(new QuestionEntity("Question 1","Where are you from", answers));
        answers = new ArrayList<>();
        answers.add(new MultipleChoiceAnswer("True",false));
        answers.add(new MultipleChoiceAnswer("False",false));
        questionEntities.add(new QuestionEntity("Question 2","are you com from Ha noi",answers));
        answers = new ArrayList<>();
        answers.add(new MultipleChoiceAnswer("ghost",false));
        answers.add(new MultipleChoiceAnswer("titan",false));
        answers.add(new MultipleChoiceAnswer("human",false));
        questionEntities.add(new QuestionEntity("Question 3","Who you are..",answers));

        exams.add(new QuestionSets("Exam 1",questionEntities));
        exams.add(new QuestionSets("Exam 2",questionEntities));
        exams.add(new QuestionSets("Exam 3",questionEntities));





    }


}
