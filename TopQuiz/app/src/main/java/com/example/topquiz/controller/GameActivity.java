package com.example.topquiz.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz.R;
import com.example.topquiz.model.model.Question;
import com.example.topquiz.model.model.QuestionBank;

import java.util.Arrays;

public class  GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    Button mGButton1;
    Button mGButton2;
    Button mGButton3;
    Button mGButton4;
    QuestionBank mQuestionBank = generateQuestion();
    Question mCurrentQuestion;
    private int mRemainingQuestionCount;
    private int mScore;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mTextView = findViewById(R.id.game_activity_textview_question);
        mGButton1 = findViewById(R.id.game_activity_button_1);
        mGButton2 = findViewById(R.id.game_activity_button_2);
        mGButton3 = findViewById(R.id.game_activity_button_3);
        mGButton4 = findViewById(R.id.game_activity_button_4);

        mGButton1.setOnClickListener(this);
        mGButton2.setOnClickListener(this);
        mGButton3.setOnClickListener(this);
        mGButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getCurrentQuestion();
        displayQuestion(mQuestionBank.getCurrentQuestion());

        mRemainingQuestionCount = 4;
        mScore = 0;
    }

    private void displayQuestion(final Question question){
        mTextView.setText(question.getQuestion());
        mGButton1.setText(question.getChoiceList().get(0));
        mGButton2.setText(question.getChoiceList().get(1));
        mGButton3.setText(question.getChoiceList().get(2));
        mGButton4.setText(question.getChoiceList().get(3));

    }


    private QuestionBank generateQuestion() {
        Question question1 = new Question(
                "Who is the creator of?",
                Arrays.asList(
                        "Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"
                ),
                0
        );

        Question question2 = new Question(
                "When did the first man land on the moon?",
                Arrays.asList(
                        "1958",
                        "1962",
                        "1967",
                        "1969"
                ),
                3
                );

        Question question3 = new Question(
                "What is the house number of The Simpsons?",
                Arrays.asList(
                        "42",
                        "101",
                        "666",
                        "742"
                ),
                3
                );

        return new QuestionBank(Arrays.asList(question1, question2, question3));

    }

    @Override
    public void onClick(View view) {
        int index;

        if (view == mGButton1) {
            index = 0;
        } else if (view == mGButton2) {
            index = 1;
        } else if (view == mGButton3) {
            index = 2;
        } else if (view == mGButton4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + view);
        }
        if (index == mQuestionBank.getCurrentQuestion().getAnswerIndex()) {
            Toast.makeText(this, "correct!", Toast.LENGTH_SHORT).show();
            mScore++;
        }else {
            Toast.makeText(this,"Incorrect!", Toast. LENGTH_SHORT) .show() ;

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRemainingQuestionCount--;

                if (mRemainingQuestionCount > 0) {
                    mCurrentQuestion = mQuestionBank.getNextQuestion();
                    displayQuestion(mCurrentQuestion);
                } else {
                    endGame();
                }
            }
        }, 2000);
        }
      private void endGame(){
          AlertDialog.Builder builder = new AlertDialog.Builder(this);

          builder.setTitle("Well done!")
                  .setMessage("Your score is " + mScore)
                  .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          Intent intent = new Intent();
                          intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                          setResult(RESULT_OK, intent);

                          finish();
                      }
                  })
                  .create()
                  .show();


    }
}
