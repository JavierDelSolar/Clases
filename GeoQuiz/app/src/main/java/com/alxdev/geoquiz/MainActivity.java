package com.alxdev.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnYes, btnNo, btnPrevious, btnNext;
    TextView tvQuestion;
    int pos = 0;
    ArrayList<Question> question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        tvQuestion = findViewById(R.id.tvQuestion);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        question = new ArrayList<>();

        loadQuestions(getString(R.string.question_peru), true, question);
        loadQuestions(getString(R.string.question_chile), false, question);
        loadQuestions(getString(R.string.question_colombia), false, question);

        tvQuestion.setText(question.get(pos).getName());
    }

    @Override
    public void onClick(View v) {
        int ans, cantQuestion;
        boolean answer;
        cantQuestion = question.size();
        switch (v.getId()) {
            case R.id.btnYes:
            case R.id.btnNo:
                answer = (v.getId()==R.id.btnYes)?true:false;
                ans = (question.get(pos).isResponse()==answer)?R.string.correct:R.string.incorrect;
                Toast.makeText(MainActivity.this, ans, Toast.LENGTH_SHORT).show();
                if(pos < cantQuestion-1) {
                    pos += 1;
                    tvQuestion.setText(question.get(pos).getName());
                }
                break;
            case R.id.btnPrevious:
                if(pos > 0) {
                    pos -= 1;
                    tvQuestion.setText(question.get(pos).getName());
                }
                break;
            case R.id.btnNext:
                if(pos < cantQuestion-1) {
                    pos += 1;
                    tvQuestion.setText(question.get(pos).getName());
                }
                break;
        }
    }

    private void loadQuestions(String question, boolean answer, ArrayList<Question> listQuestion) {
        Question quest = new Question(question, answer);
        listQuestion.add(quest);
    }
}