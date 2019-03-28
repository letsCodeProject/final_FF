package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;
public class firstlevel_resultsheet extends AppCompatActivity {
    String correct="تم إتمام المهمة بنجاح";
    String wrong ="لقد حدث أمر خاطئ";

    String btntextcorrect="انطلق للكوكب التالي";

    String btntextwrong="الرجوع إلى المهمة";

    public String feedbackcorrect=" ممتاز ";

    public   String feedbackwrong="حاول مرة أخرى";


    int result ,result2;
    int q1score,q2score,totalscore;
    String text1,text2;
    MySQLliteHelper mySqliteOpenHelper23;
    MediaPlayer rightAnswerVoice;
    MediaPlayer wrongAnswerVoice;
    voice resultsheet;
    int minimum=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySqliteOpenHelper23=new MySQLliteHelper(this);
        //create MediaPLayer to play the voice
        rightAnswerVoice=MediaPlayer.create(firstlevel_resultsheet.this,R.raw.rightanswerfeedbackvoice);
        wrongAnswerVoice=MediaPlayer.create(firstlevel_resultsheet.this,R.raw.wronganswerfeedbackvoice);

        setContentView(R.layout.activity_firstlevel_resultsheet);
        TextView textView = (TextView)findViewById(R.id.quiz1Score);
        textView.setText(mySqliteOpenHelper23.getChildScore()+"" );

        TextView t1=(TextView)findViewById(R.id.resultq1);
        TextView t2=(TextView)findViewById(R.id.resultq2);
        TextView t3=(TextView)findViewById(R.id.totalquizresult);
        TextView resnum1=(TextView) findViewById(R.id.resnum1);
        TextView resnum2=(TextView) findViewById(R.id.resnum2);

        TextView resfeedback=(TextView) findViewById(R.id.feedback);
        Button button7=(Button) findViewById(R.id.button7);
        ImageButton homebtnres=(ImageButton) findViewById(R.id.homebtnres);
        homebtnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

        // homebtn811.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(HomePage);
        //  }
        // });



        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalscore>5 ){

                    Intent gohime=new Intent (getApplicationContext(),MainActivity.class);
                    //mySqliteOpenHelper23.updateChildScore(totalscore);
                    //mySqliteOpenHelper23.UnlockNextLevel("nepton" );
                    startActivity(gohime);

                }

            }
        });
        //totalquizresult
        // result=mySqliteOpenHelper23.returnQuestionAnswer(1);
        // result2=mySqliteOpenHelper23.returnQuestionAnswer(2);
        //Check q1
        Cursor resreturned=mySqliteOpenHelper23.returnQuestionAnswer(1);
        resreturned.moveToFirst();
        int index=resreturned.getColumnIndexOrThrow("Q_ANSWER");
        int answer=resreturned.getInt(index);
        result=answer; //if(answer==0){mySqliteOpenHelper23.addIndexData("firstlevel_6");}


        Cursor cursor=mySqliteOpenHelper23.returnQuestionAnswer(2);
        cursor.moveToFirst();
        int index2=cursor.getColumnIndexOrThrow("Q_ANSWER");
        int answer2=cursor.getInt(index2);
        result2=answer2;
       // if(answer2==0){mySqliteOpenHelper23.addIndexData("firstlevel_7");}


    /*    Cursor cur1=mySqliteOpenHelper23.returnLevelStatus("Nepton");
        cur1.moveToFirst();
        int status=cur1.getColumnIndexOrThrow("LevelStatus");*/
        boolean status=mySqliteOpenHelper23.getLevelStatus("Nepton");




        if ((result==1) && (result2==1)) {
            t1.setText(R.string.AnswerCorrect);
            t1.setTextColor(Color.parseColor("#0E932E"));
            t2.setText(R.string.AnswerCorrect);
            t2.setTextColor(Color.parseColor("#0E932E"));
            q1score =10;
            q2score=10;}

        else if ((result==0) && (result2==1)){
            t1.setText(R.string.UnderMinimum);
            t1.setTextColor(Color.parseColor("#FF6B6B"));
            t2.setText(R.string.AnswerCorrect);
            t2.setTextColor(Color.parseColor("#0E932E"));
            q1score =0;
            q2score=10;
        }
        else if ((result==1) && (result2==0)){
            t1.setText(R.string.AnswerCorrect);
            t1.setTextColor(Color.parseColor("#0E932E"));
            t2.setText(R.string.AnswerWrong);
            t2.setTextColor(Color.parseColor("#FF6B6B"));
            q1score =10;
            q2score=0;

        }
        else {
            t1.setText(R.string.AnswerWrong);
            t1.setTextColor(Color.parseColor("#FF6B6B"));
            t2.setText(R.string.AnswerWrong);
            t2.setTextColor(Color.parseColor("#FF6B6B"));
            q1score =0;
            q2score=0;
        }

        totalscore=q1score+q2score;
        t3.setText(""+totalscore);

        mySqliteOpenHelper23.SubmitResultToQuizTable(1,totalscore);

        resnum1.setText(String.valueOf(q1score));
        resnum2.setText(String.valueOf(q2score));


        setbuttontext(totalscore , button7 ,minimum,status);
        setFeedbackForResultSheet(totalscore ,resfeedback , minimum);


        setbuttontext(totalscore , button7 ,minimum,status);
        setFeedbackForResultSheet(totalscore ,resfeedback , minimum);
        //updateScore(totalscore);




    }

    public void setbuttontext(int total , Button btn7,int min,boolean status){
        if (total>10 ) {
            if (status == false) {
                CallUnlockMethod();
                updateScore(total);
                btn7.setText(btntextcorrect);
                mySqliteOpenHelper23.UpdateNumOfLesson(1, "Ploto");



                //play the voice for right answer
                resultsheet = new voice(rightAnswerVoice);
                resultsheet.play();
            } else {
                btn7.setText(btntextcorrect);
                mySqliteOpenHelper23.UpdateNumOfLesson(1, "Ploto");
                resultsheet = new voice(rightAnswerVoice);
                resultsheet.play();
            }
        }

        else
        {btn7.setText(btntextwrong);

            //play the voice for wrong answer
            resultsheet=new voice(wrongAnswerVoice);
            resultsheet.play();
            //FOR DATABASE
           btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent (getApplicationContext(),firstlevel_6.class);

                }

            });

        }

        //Call method changelabebstatus
        Changelabebstatus(total ,minimum);
    }//end of method buttong
    @Override
    protected void onPause() {
        super.onPause();
        resultsheet.pause();
    }

    public void play(View view) {
        resultsheet.play();
    }
    public void takeMeBack(View view) {
        Toast.makeText(firstlevel_resultsheet.this,  "hi",
                Toast.LENGTH_LONG).show();


    }





    public void Changelabebstatus( int total ,int minimum){
        ImageView labebhappy ,labebsad;

        labebhappy=(ImageView) findViewById(R.id.labebholdingsheet);
        labebsad=(ImageView) findViewById(R.id.sadlabeb);
        labebhappy.setVisibility(View.INVISIBLE);
        labebsad.setVisibility(View.INVISIBLE);

        if (totalscore>minimum)
            labebhappy.setVisibility(View.VISIBLE);
        else
            labebsad.setVisibility(View.VISIBLE); }


    //تسوي ابديت ل سكور الطفل
    public void updateScore(int totalscore){
        mySqliteOpenHelper23.updateChildScore(totalscore);
        TextView textView = (TextView)findViewById(R.id.quiz1Score);
        textView.setText(mySqliteOpenHelper23.getChildScore()+"" );

    }
    //تسوي انلوك بالميثود الي بعدها ما اناديها الا اذا كان ال سكور فوق ال ٥
    public void CallUnlockMethod () {
        mySqliteOpenHelper23.UnlockNextLevel("Nepton");
    }

    //Change to eather احسنت  or جيد جداً
    public void setFeedbackForResultSheet(int total ,TextView resfeedback ,int minimum) {
        if (total > minimum) {
            resfeedback.setText(feedbackcorrect);
            resfeedback.setTextColor(Color.parseColor("#0E932E"));
        } else {
            resfeedback.setText(feedbackwrong);
            resfeedback.setTextColor(Color.parseColor("#2340B7"));
        }
    }//تسوي انلوك بالميثود الي بعدها ما اناديها الا اذا كان ال سكور فوق ال ٥



}//end class