
package com.example.a96653.LetsCode;

        import android.content.Intent;
        import android.database.Cursor;
        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;

public class thirdlevel_resultsheet extends AppCompatActivity {

    MySQLliteHelper m;
    int result_13, result_23, result_33, result_43, result_53;
    int score_13, score_23, score_33, score_43, score_53;
    int totalscoreQuiz3;
    int minimum = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_resultsheet);


        m = new MySQLliteHelper(this);

//scoreBox display
        TextView scoredisplay = (TextView) findViewById(R.id.quiz1Score3);
        scoredisplay.setText(m.getChildScore() + "");

//HOME BUTTON
        ImageButton homebtnres3 = (ImageButton) findViewById(R.id.homebtnres3);
        homebtnres3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gohome);
            }
        });
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TextView question3_1 = (TextView) findViewById(R.id.q3_1);
        TextView question3_2 = (TextView) findViewById(R.id.q3_2);
        TextView question3_3 = (TextView) findViewById(R.id.q3_3);
        TextView question3_4 = (TextView) findViewById(R.id.q3_4);
        TextView question3_5 = (TextView) findViewById(R.id.q3_5);
        //Score
        TextView ScoreDisplay3_1 = (TextView) findViewById(R.id.resultq3_1);
        TextView ScoreDisplay3_2 = (TextView) findViewById(R.id.resultq3_2);
        TextView ScoreDisplay3_3 = (TextView) findViewById(R.id.resultq3_3);
        TextView ScoreDisplay3_4 = (TextView) findViewById(R.id.resultq3_4);
        TextView ScoreDisplay3_5 = (TextView) findViewById(R.id.resultq3_5);
        Button But3 = (Button) findViewById(R.id.button12);
        TextView totalQuizResult = (TextView) findViewById(R.id.totalquizresult31);

        //Extract q1
        Cursor resreturned1 = m.returnQuestionAnswer(8);
        resreturned1.moveToFirst();
        int index1 = resreturned1.getColumnIndexOrThrow("Q_ANSWER");
        int answer1_3 = resreturned1.getInt(index1);
        result_13 = answer1_3;
        score_13 = GiveScore(result_13);
        //display the score
        ScoreDisplay3_1.setText(String.valueOf(score_13));

        //Extraxt q2

        Cursor resreturned2 = m.returnQuestionAnswer(9);
        resreturned2.moveToFirst();
        int index2 = resreturned2.getColumnIndexOrThrow("Q_ANSWER");
        int answer2_3 = resreturned2.getInt(index2);
        result_23 = answer2_3;
        score_23 = GiveScore(result_23);
        //display the score
        ScoreDisplay3_2.setText(String.valueOf(score_23));

        //Extract q3

        Cursor resreturned3 = m.returnQuestionAnswer(10);
        resreturned3.moveToFirst();
        int index3 = resreturned3.getColumnIndexOrThrow("Q_ANSWER");
        int answer3_3 = resreturned3.getInt(index3);
        result_33 = answer3_3;
        score_33 = GiveScore(result_33);
        //display the score
        ScoreDisplay3_3.setText(String.valueOf(score_33));

        //Extract  q4

        Cursor resreturned4 = m.returnQuestionAnswer(11);
        resreturned4.moveToFirst();
        int index4 = resreturned4.getColumnIndexOrThrow("Q_ANSWER");
        int answer4_3 = resreturned4.getInt(index4);
        result_43 = answer4_3;
        score_43 = GiveScore(result_43);
        //display the score
        ScoreDisplay3_4.setText(String.valueOf(score_43));

        //extract q5

        Cursor resreturned5 = m.returnQuestionAnswer(12);
        resreturned5.moveToFirst();
        int index5 = resreturned5.getColumnIndexOrThrow("Q_ANSWER");
        int answer5_3 = resreturned5.getInt(index5);
        result_53 = answer5_3;
        score_53 = GiveScore(result_53);
        //display the scoree
        ScoreDisplay3_5.setText(String.valueOf(score_53));

        //Feedback for each question :
        /////////
        QuestionFeedback(question3_1, score_13);
        QuestionFeedback(question3_2, score_23);
        QuestionFeedback(question3_3, score_33);
        QuestionFeedback(question3_4, score_43);
        QuestionFeedback(question3_5, score_53);

        totalscoreQuiz3 = score_13 + score_23 + score_33 + score_43 + score_53;
        totalQuizResult.setText(String.valueOf(totalscoreQuiz3));


        //Save quiz result  in db
        m.SubmitResultToQuizTable(3, totalscoreQuiz3);

        //Next level : Jupiter
        boolean levelstatus = m.getLevelStatus("Jupiter");

        Changelabebstatus(totalscoreQuiz3, minimum);
        ChangeButtonText(totalscoreQuiz3, minimum, levelstatus, But3);


    }//End of onCreate

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
        happy = (ImageView) findViewById(R.id.happylabeb33);
        sad = (ImageView) findViewById(R.id.sadlabeb3);
        TextView feedback3 = (TextView) findViewById(R.id.feedback3);
        happy.setVisibility(View.INVISIBLE);
        sad.setVisibility(View.INVISIBLE);
        if (total > min) {
            happy.setVisibility(View.VISIBLE);
            feedback3.setText(R.string.AboveMinimmum);
            feedback3.setTextColor(Color.parseColor("#0E932E"));
        } else {
            sad.setVisibility(View.VISIBLE);
            feedback3.setText(R.string.UnderMinimum);
            feedback3.setTextColor(Color.parseColor("#2340B7"));

        }
    }//End of the method

    public void ChangeButtonText(int total, int min, boolean status, Button btn) {
        if (total > min) {
            if (status == false) {
                CallUnlockMethod();
                updateScore(total);

            }
            btn.setText(R.string.ButtonCorrect);
        } else {
            btn.setText(R.string.ButtonWrong);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gobacktoSolveQuiz = new Intent(getApplicationContext(), thirdlevel_1.class);
                    startActivity(gobacktoSolveQuiz);
                }
            });
        }

    }//end of method

    public void CallUnlockMethod() {
        m.UnlockNextLevel("Jupiter");
    }


    //تسوي ابديت ل سكور الطفل
    public void updateScore(int totalscore) {
        int scorebeforeupdate = m.getChildScore();
        totalscore = totalscore + scorebeforeupdate;
        m.updateChildScore(totalscore);
        TextView textView = (TextView) findViewById(R.id.quiz1Score3);
        textView.setText(m.getChildScore() + "");

    }

}