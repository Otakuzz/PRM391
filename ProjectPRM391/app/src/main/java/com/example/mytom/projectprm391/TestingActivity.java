package com.example.mytom.projectprm391;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mytom.projectprm391.Adapter.ListAnswerAdapter;
import com.example.mytom.projectprm391.Adapter.ListNumberQuestionAdapter;
import com.example.mytom.projectprm391.Adapter.MultipleChoiceAdapter;
import com.example.mytom.projectprm391.Item.MultipleChoiceAnswer;
import com.example.mytom.projectprm391.Item.QuestionEntity;
import com.example.mytom.projectprm391.Item.QuestionSets;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mytom on 3/9/2017.
 */

public class TestingActivity extends AppCompatActivity implements View.OnClickListener{
    private Button  mFinishbtn, mStopbtn, mNextbtn;
    private TextView mNameExamtv, mTimeCountDowntv, mQuestionTitle;
    private static final String FORMAT = "%02d:%02d:%02d";
    private CountDownTimer cdt;
    private ListView listAnswer, listAnswerChoice;
    private int index = 0;
    private GridView mListNumberQuestion;
    private ArrayList<QuestionEntity> questionEntities;
    private ListNumberQuestionAdapter listNumberQuestionAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_exam);
        Intent intent = getIntent();

        QuestionSets listQuestion = (QuestionSets) intent.getSerializableExtra("questionExam");
        questionEntities = listQuestion.getQuestions();
        mNameExamtv = (TextView) findViewById(R.id.name_exam_testing);
        mListNumberQuestion = (GridView) findViewById(R.id.list_number_question_test_exam);

        listNumberQuestionAdapter = new ListNumberQuestionAdapter(this, R.layout.layout_item_number_question,listQuestion.getQuestions());
        mTimeCountDowntv = (TextView) findViewById(R.id.time_count_down_test);
        mNextbtn = (Button) findViewById(R.id.btn_next_test_exam);
        mNameExamtv.setText(listQuestion.getName());
        mQuestionTitle = (TextView) findViewById(R.id.question_title_test_exam);
        listAnswerChoice = (ListView) findViewById(R.id.list_answer_test_exam);
        listAnswer = (ListView) findViewById(R.id.list_answer_question_test_exam);
        mFinishbtn = (Button) findViewById(R.id.btnFinish_test);
        mStopbtn = (Button) findViewById(R.id.btnStop_test);
        mFinishbtn.setOnClickListener(this);
        mNextbtn.setOnClickListener(this);
        mStopbtn.setOnClickListener(this);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        cdt = new CountDownTimer(108000, 1000) { // adjust the milli seconds here

                            public void onTick(long millisUntilFinished) {

                                mTimeCountDowntv.setText(""+String.format(FORMAT,
                                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));

                            }

                            public void onFinish() {
                                mTimeCountDowntv.setText("FINISH!");

                            }
                        }.start();
                        setViewQuestion(questionEntities.get(index));
                        dialog.dismiss();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Intent intent = new Intent(TestingActivity.this,HomeActivity.class);
                        finish();
                        dialog.dismiss();
                        startActivity(intent);
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure star test?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


    }
public void setViewQuestion(QuestionEntity question){
    ArrayList<MultipleChoiceAnswer> answers = question.getAnswers();
    MultipleChoiceAdapter adapterMultiChoice = new MultipleChoiceAdapter(this,R.layout.layout_entity_answer_multiple, question.getAnswers());
    listAnswerChoice.setAdapter(adapterMultiChoice);
    ListAnswerAdapter listAnswerAdapter = new ListAnswerAdapter(this, R.layout.layout_item_answer_title,answers);
    listAnswer.setAdapter(listAnswerAdapter);
    mQuestionTitle.setText(question.getQuestionTitle());
    mListNumberQuestion.setAdapter(listNumberQuestionAdapter);

}
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_next_test_exam:
                if(index == questionEntities.size()){
                    index = 0;
                    setViewQuestion(questionEntities.get(index++));
                } else
                if(index == 0){
                    index = 1;
                    setViewQuestion(questionEntities.get(index++));
                } else {
                    setViewQuestion(questionEntities.get(index++));
                }
                listNumberQuestionAdapter.notifyDataSetChanged();
                mListNumberQuestion.setAdapter(listNumberQuestionAdapter);

                break;
            case R.id.btnFinish_test:
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                dialog.dismiss();
                                Intent intent = new Intent(TestingActivity.this,HomeActivity.class);
                                finish();
                                startActivity(intent);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                dialog.dismiss();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                break;
            case R.id.btnStop_test:
                dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                dialog.dismiss();

                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
        }
    }
class AsynTaskTest extends AsyncTask<String,Integer, String>{

    WeakReference<Activity> mWeakReference;
    public AsynTaskTest(Activity activity){
        this.mWeakReference = new WeakReference<Activity>(activity);
    }
    @Override
    protected String doInBackground(String... params) {
        Activity activity = mWeakReference.get();

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }


}
}
