package com.example.a96653.LetsCode;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class firstlevel_resultsheet extends AppCompatActivity {
    String correct="تم إتمام المهمة بنجاح";
    String wrong ="لقد حدث أمر خاطئ";

    String btntextcorrect="انطلق للكوكب التالي";

    String btntextwrong="الرجوع إلى المهمة";


    int result ,result2;
    int q1score,q2score,totalscore;
    String text1,text2;
    MySQLliteHelper mySqliteOpenHelper23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_resultsheet);
        TextView t1=(TextView)findViewById(R.id.resultq1);
        TextView t2=(TextView)findViewById(R.id.resultq2);
        TextView t3=(TextView)findViewById(R.id.totalquizresult);
        Button button7=(Button) findViewById(R.id.button7);

        // homebtn811.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(HomePage);
        //  }
        // });

        mySqliteOpenHelper23=new MySQLliteHelper(this);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalscore>5 ){

                    Intent gohime=new Intent (getApplicationContext(),MainActivity.class);
                    mySqliteOpenHelper23.updateChildScore(totalscore);
                    mySqliteOpenHelper23.UnlockNextLevel("nepton" ,1);

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
        result=answer;

        Cursor cursor=mySqliteOpenHelper23.returnQuestionAnswer(2);
        cursor.moveToFirst();
        int index2=cursor.getColumnIndexOrThrow("Q_ANSWER");
        int answer2=cursor.getInt(index2);
        result2=answer2;



        if ((result==1) && (result2==1)) {
            t1.setText(correct);
            t1.setTextColor(Color.parseColor("#0E932E"));
            t2.setText(correct);
            t2.setTextColor(Color.parseColor("#0E932E"));
            q1score =5;
            q2score=5;}

        else if ((result==0) && (result2==1)){
            t1.setText(wrong);
            t1.setTextColor(Color.parseColor("#FF6B6B"));
            t2.setText(correct);
            t2.setTextColor(Color.parseColor("#0E932E"));
            q1score =0;
            q2score=5;
        }
        else if ((result==1) && (result2==0)){
            t1.setText(correct);
            t1.setTextColor(Color.parseColor("#0E932E"));
            t2.setText(wrong);
            t2.setTextColor(Color.parseColor("#FF6B6B"));
            q1score =5;
            q2score=0;

        }
        else {
            t1.setText(wrong);
            t1.setTextColor(Color.parseColor("#FF6B6B"));
            t2.setText(wrong);
            t2.setTextColor(Color.parseColor("#FF6B6B"));
            q1score =0;
            q2score=0;
        }

        totalscore=q1score+q2score;
        t3.setText(""+totalscore);
        setbuttontext(totalscore , button7);




    }

    public void setbuttontext(int total , Button btn7){
        if (total>5)
            btn7.setText(btntextcorrect);


        else
            btn7.setText(btntextwrong);


    }//end of method buttong


}