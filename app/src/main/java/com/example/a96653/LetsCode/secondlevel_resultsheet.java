
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


public class secondlevel_resultsheet extends AppCompatActivity {

    MySQLliteHelper m;
    int result_1,result_2,result_3,result_4,result_5 ;
    int score_1,score_2,score_3,score_4,score_5;
    int  totalscoreQuiz2;
    int minimum=20;
    MediaPlayer rightAnswerVoice;
    MediaPlayer wrongAnswerVoice;
    voice resultsheet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_resultsheet);

        m=new MySQLliteHelper(this);
        //create MediaPLayer to play the voice
        rightAnswerVoice=MediaPlayer.create(secondlevel_resultsheet.this,R.raw.rightanswerfeedbackvoice);
        wrongAnswerVoice=MediaPlayer.create(secondlevel_resultsheet.this,R.raw.wronganswerfeedbackvoice);


//scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.quiz1Score2);
        scoredisplay.setText(m.getChildScore()+"" );
//HOME BUTTON
        ImageButton homebtnres2=(ImageButton)findViewById(R.id.homebtnres2);
        homebtnres2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TextView question1=(TextView) findViewById(R.id.q1);
        TextView question2=(TextView) findViewById(R.id.q2);
        TextView question3=(TextView) findViewById(R.id.q3);
        TextView question4=(TextView) findViewById(R.id.q4);
        TextView question5=(TextView) findViewById(R.id.q5);
        //Score
        TextView ScoreDisplay1=(TextView) findViewById(R.id.resultq1);
        TextView ScoreDisplay2=(TextView) findViewById(R.id.resultq2);
        TextView ScoreDisplay3=(TextView) findViewById(R.id.resultq3);
        TextView ScoreDisplay4=(TextView) findViewById(R.id.resultq4);
        TextView ScoreDisplay5=(TextView) findViewById(R.id.resultq5);
        Button But=(Button)findViewById(R.id.button11);


        TextView totalQuizResult=(TextView) findViewById(R.id.totalquizresult3);
//______________________________ RESULT SHEET______________________________
//Extract question 1 answer from DB

        Cursor resreturned1=m.returnQuestionAnswer(3);
        resreturned1.moveToFirst();
        int index1=resreturned1.getColumnIndexOrThrow("Q_ANSWER");
        int answer1_2=resreturned1.getInt(index1);
        result_1=answer1_2;
        score_1=GiveScore (result_1);
        //display the score
        ScoreDisplay1.setText(String.valueOf(score_1));
//Extract  question 2 answer from DB

        Cursor resreturned2=m.returnQuestionAnswer(4);
        resreturned2.moveToFirst();
        int index2=resreturned2.getColumnIndexOrThrow("Q_ANSWER");
        int answer2_2=resreturned2.getInt(index2);
        result_2=answer2_2;
        score_2=GiveScore(result_2);
        //display the score
        ScoreDisplay2.setText(String.valueOf(score_2));
//Extract  question 3 answer from DB

        Cursor resreturned3=m.returnQuestionAnswer(5);
        resreturned3.moveToFirst();
        int index3=resreturned3.getColumnIndexOrThrow("Q_ANSWER");
        int answer3_2=resreturned3.getInt(index3);
        result_3=answer3_2;
        score_3=GiveScore(result_3);
        //display the score
        ScoreDisplay3.setText(String.valueOf(score_3));

//Extract  question 4 answer from DB

        Cursor resreturned4=m.returnQuestionAnswer(6);
        resreturned4.moveToFirst();
        int index4=resreturned4.getColumnIndexOrThrow("Q_ANSWER");
        int answer4_2=resreturned4.getInt(index4);
        result_4=answer4_2;
        score_4=GiveScore(result_4);
        //display the score
        ScoreDisplay4.setText(String.valueOf(score_4));

//Extract  question 5 answer from DB

        Cursor resreturned5=m.returnQuestionAnswer(7);
        resreturned5.moveToFirst();
        int index5=resreturned5.getColumnIndexOrThrow("Q_ANSWER");
        int answer5_2=resreturned5.getInt(index5);
        result_5=answer5_2;

        //Call give score method to give score to each question
        score_5=GiveScore(result_5);
        //display the score in the uper left box
        ScoreDisplay5.setText(String.valueOf(score_5));
//_____Calculate the total score


//_____ Call feedback method
        QuestionFeedback(question1,score_1);
        QuestionFeedback(question2,score_2);
        QuestionFeedback(question3,score_3);
        QuestionFeedback(question4,score_4);
        QuestionFeedback(question5,score_5);




        totalscoreQuiz2=score_1+score_2+score_3+score_4+score_5;
        totalQuizResult.setText(String.valueOf(totalscoreQuiz2));
        //Save quiz result  in db
        m.SubmitResultToQuizTable(2,totalscoreQuiz2);


        //Cursor cur1=m.returnLevelStatus("Saturn");
        // cur1.moveToFirst();
        //int status=cur1.getColumnIndexOrThrow("LevelStatus");
        boolean levelstatus=m.getLevelStatus("Saturn");

        Changelabebstatus(totalscoreQuiz2,minimum);
        ChangeButtonText(totalscoreQuiz2 , minimum,levelstatus,But);

    }//End of onCreate

/////////////METHODS/////////METHODS///////////////

    //Takes 0 or 1 and return 0 or 10
    public int GiveScore(int result){
        int givenScore=0;
        if (result==1)
            givenScore=10;
        //  else
        // givenScore=0;

        return givenScore;
    }

    //Takes score and displays the question feedback either احسنت or امر خاطئ
    public void QuestionFeedback (TextView quesresult,int score){
        if (score==10) {
            quesresult.setText(R.string.AnswerCorrect);
            quesresult.setTextColor(Color.parseColor("#0E932E"));
        }
        else {
            quesresult.setText(R.string.AnswerWrong);
            quesresult.setTextColor(Color.parseColor("#FF6B6B"));
        }
    }

//Based on the total labeb appearance will change either sad or happy
    public void Changelabebstatus(int total , int min){
        ImageView happy,sad;
        happy=(ImageView) findViewById(R.id.happylabeb33);
        sad=(ImageView) findViewById(R.id.sadlabeb2);
        TextView feedback2=(TextView) findViewById(R.id.feedback2);
        happy.setVisibility(View.INVISIBLE);
        sad.setVisibility(View.INVISIBLE);
        if (total>min) {
            happy.setVisibility(View.VISIBLE);
            feedback2.setText(R.string.AboveMinimmum);
            feedback2.setTextColor(Color.parseColor("#0E932E"));
            resultsheet = new voice(rightAnswerVoice);
            //Play chearing sound
            resultsheet.play();
        }
        else {
            sad.setVisibility(View.VISIBLE);
            feedback2.setText(R.string.UnderMinimum);
            feedback2.setTextColor(Color.parseColor("#2340B7"));
            resultsheet=new voice(wrongAnswerVoice);
            //Play sad sound
            resultsheet.play();

        }
    }



    public void ChangeButtonText(int total , int min , boolean status,Button btn){
        if (total>min){
            if(status==false){
                CallUnlockMethod();
                updateScore(total);
                m.UpdateNumOfLesson(9, "Nepton");

            }
            m.UpdateNumOfLesson(9, "Nepton");
            btn.setText(R.string.ButtonCorrect);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gobacktoMain=new Intent (getApplicationContext(),MainActivity.class);
                    startActivity(gobacktoMain);
                }
            });
        }
        else {
            btn.setText(R.string.ButtonWrong);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gobacktoSolveQuiz=new Intent (getApplicationContext(),secondlevel_18_quiz.class);
                    startActivity(gobacktoSolveQuiz);
                }
            });
        }

    }//end of method

    public void CallUnlockMethod () {
        m.UnlockNextLevel("Saturn");
    }



    //تسوي ابديت ل سكور الطفل
    public void updateScore(int totalscore){
        int scorebeforeupdate=m.getChildScore();
        totalscore=totalscore+scorebeforeupdate;
        m.updateChildScore(totalscore);
        TextView textView = (TextView)findViewById(R.id.quiz1Score2);
        textView.setText(m.getChildScore()+"" );

    }
    @Override
    protected void onPause() {
        super.onPause();
        resultsheet.pause();
    }

    public void play(View view) {
        resultsheet.play();
    }
}