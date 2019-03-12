package com.example.a96653.LetsCode;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Fourthlevel_resultsheet extends AppCompatActivity {
    MySQLliteHelper m;
    int result_41, result_42, result_43;
    int score_41, score_424, score_43;
    int totalscoreQuiz4;
    int minimum = 20;
    MediaPlayer rightAnswerVoice;
    MediaPlayer wrongAnswerVoice;
    voice resultsheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthlevel_resultsheet);


        m = new MySQLliteHelper(this);

        //create MediaPLayer to play the voice
        rightAnswerVoice=MediaPlayer.create(Fourthlevel_resultsheet.this,R.raw.rightanswerfeedbackvoice);
        wrongAnswerVoice=MediaPlayer.create(Fourthlevel_resultsheet.this,R.raw.wronganswerfeedbackvoice);



        //scoreBox display
        TextView scoredisplay = (TextView) findViewById(R.id.quiz4Scoredisplay);
        scoredisplay.setText(m.getChildScore() + "");

        //HOME BUTTON
        ImageButton homebtnres3 = (ImageButton) findViewById(R.id.homebtnquiz4);
        homebtnres3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gohome);

            }
        });


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TextView question4_1 = (TextView) findViewById(R.id.lastquizresult1);
        TextView question4_2 = (TextView) findViewById(R.id.lastquizresult2);
        TextView question4_3 = (TextView) findViewById(R.id.lastquizresult3);

        //totalquizresult4

        //Score
        TextView ScoreDisplay4_1 = (TextView) findViewById(R.id.q1score);
        TextView ScoreDisplay4_2 = (TextView) findViewById(R.id.q2score2);
        TextView ScoreDisplay4_3 = (TextView) findViewById(R.id.q2score3);

        Button But3 = (Button) findViewById(R.id.button13quiz);
        TextView totalQuizResult4 = (TextView) findViewById(R.id.totalquizresult4);

        //Extract from db

        //Extract q1
        Cursor resreturned1 = m.returnQuestionAnswer(13);
        resreturned1.moveToFirst();
        int index1 = resreturned1.getColumnIndexOrThrow("Q_ANSWER");
        int answer4_1 = resreturned1.getInt(index1);
        result_41 = answer4_1;
        score_41 = GiveScore(result_41);
        //display the score
        ScoreDisplay4_1.setText(String.valueOf(score_41));



        //Extract q2
        Cursor resreturned2= m.returnQuestionAnswer(14);
        resreturned2.moveToFirst();
        int index2 = resreturned2.getColumnIndexOrThrow("Q_ANSWER");
        int answer4_2 = resreturned2.getInt(index2);
        result_42 = answer4_2;
        score_424 = GiveScore(result_42);
        //display the score
        ScoreDisplay4_2.setText(String.valueOf(score_424));


         //exctract q3
        Cursor resreturned3 = m.returnQuestionAnswer(15);
        resreturned3.moveToFirst();
        int index3 = resreturned3.getColumnIndexOrThrow("Q_ANSWER");
        int answer4_3 = resreturned3.getInt(index3);
        result_43 = answer4_3;
        score_43 = GiveScore(result_43);
        //display the score
        ScoreDisplay4_3.setText(String.valueOf(score_43));


        //Feedback for each question :
        /////////
        QuestionFeedback(question4_1, score_41);
        QuestionFeedback(question4_2, score_424);
        QuestionFeedback(question4_3, score_43);

        totalscoreQuiz4 = score_41+score_424+score_43;
        totalQuizResult4.setText(String.valueOf(totalscoreQuiz4));

        //Save quiz result  in db
        m.SubmitResultToQuizTable(4, totalscoreQuiz4);

        //Next level : Jupiter
        boolean levelstatus = m.getLevelStatus("Earth");
        Changelabebstatus(totalscoreQuiz4, minimum);
        ChangeButtonText(totalscoreQuiz4, minimum, levelstatus, But3);



    }



    public int GiveScore(int result) {
        int givenScore = 0;
        if (result == 1)
            givenScore = 10;
        //  else
        // givenScore=0;

        return givenScore;
    }//End of the method




    //Takes score and displays the question feedback either احسنت or امر خاطئ
    public void QuestionFeedback(TextView quesresult, int score) {
        if (score == 10) {
            quesresult.setText(R.string.AnswerCorrect);
            quesresult.setTextColor(Color.parseColor("#0E932E"));
        } else {
            quesresult.setText(R.string.AnswerWrong);
            quesresult.setTextColor(Color.parseColor("#FF6B6B"));
        }
    }//Close the method


    public void Changelabebstatus(int total, int min) {
        ImageView happy, sad;
        happy = (ImageView) findViewById(R.id.labebholdingsheet3);
        sad = (ImageView) findViewById(R.id.sadlabeb4);
        TextView feedback3 = (TextView) findViewById(R.id.feedback4);
        happy.setVisibility(View.INVISIBLE);
        sad.setVisibility(View.INVISIBLE);
        if (total > min) {
            happy.setVisibility(View.VISIBLE);
            feedback3.setText(R.string.AboveMinimmum);
            feedback3.setTextColor(Color.parseColor("#0E932E"));
            resultsheet = new voice(rightAnswerVoice);
            resultsheet.play();
        } else {
            sad.setVisibility(View.VISIBLE);
            feedback3.setText(R.string.UnderMinimum);
            feedback3.setTextColor(Color.parseColor("#2340B7"));
            resultsheet=new voice(wrongAnswerVoice);
            resultsheet.play();

        }
    }//End of the method


    public void ChangeButtonText(int total, int min, boolean status, Button btn) {
        if (total > min) {
            if (status == false) {
                CallUnlockMethod();
                updateScore(total);
                m.UpdateNumOfLesson(53,"Jupiter");

            }
            btn.setText(R.string.ButtonCorrect);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    m.UpdateNumOfLesson(53,"Jupiter");
                    Intent gobacktoMain=new Intent (getApplicationContext(),EndOfLevels.class);
                    startActivity(gobacktoMain);
                }
            });
        } else {
            btn.setText(R.string.ButtonWrong);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gobacktoSolveQuiz = new Intent(getApplicationContext(), fourthlevel_4.class);
                    startActivity(gobacktoSolveQuiz);
                }
            });
        }

    }//end of method

    public void CallUnlockMethod() {
        m.UnlockNextLevel("Earth");
    }


    //تسوي ابديت ل سكور الطفل
    public void updateScore(int totalscore) {
        int scorebeforeupdate = m.getChildScore();
        totalscore = totalscore + scorebeforeupdate;
        m.updateChildScore(totalscore);
        TextView textView = (TextView) findViewById(R.id.quiz4Scoredisplay);
        textView.setText(m.getChildScore() + "");

    }


    @Override
    protected void onPause() {
        super.onPause();
        resultsheet.pause();
    }

    public void play(View view) {
        resultsheet.play();
    }




}//End class



