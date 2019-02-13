package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class secondlevel_12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_12);
        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        //HOME BUTTON
        ImageButton homebtnres=(ImageButton) findViewById(R.id.homebtn_12);
        homebtnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //TO VIEW SCORE
        TextView textView = (TextView)findViewById(R.id.scoreBox_12);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );
        //PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id. previous_12);
        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );
        ////showing result button
        Button showResult=(Button)findViewById(R.id.ShowMeResultButton_secondlevel_12);
        final TextView ResultBox=(TextView)findViewById(R.id.ResultBox_secondlevel_12);
        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the show result button clicked for first time we update the numOfLessonPassed in db .
                SharedPreferences prefs = getSharedPreferences("pref_secondLevel_12", MODE_PRIVATE);
                boolean firstStart = prefs.getBoolean("firstStart", true);
                if (firstStart){
                    mySqliteOpenHelper.UpdateNumOfLesson(19,"Nepton");
                    SharedPreferences pref = getSharedPreferences("pref_secondLevel_12", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();}
                //setting the  fixed result in resultBox
                ResultBox.setText("لبيب");
                Intent feedback=new Intent(getApplicationContext(),secondlevel_13_feedback.class);
                startActivity(feedback);
            }
        });


    }//END onCREATE

    public void openPreviousActivity(){

        Intent intent=new Intent(this,secondlevel_11.class);
        startActivity(intent);

    }
    }

