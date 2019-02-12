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

public class seconlevel_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconlevel_8);
        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        //HOME BUTTON
        ImageButton homebtnres=(ImageButton) findViewById(R.id.homebtn_secondlevel8);
        homebtnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //TO VIEW SCORE
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_8);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );
        //PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id. previous_seconlevel_8);
        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );
        //NEXT BUTTON
        ImageView goButton=(ImageView) findViewById(R.id.next);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_secondLevel_8", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            mySqliteOpenHelper.UpdateNumOfLesson(16,"Nepton");
                            SharedPreferences pref = getSharedPreferences("pref_secondLevel_8", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );



    }//END onCREATE

    public void openPreviousActivity(){

        Intent intent=new Intent(this,secondlevel_7_feedback2.class);
        startActivity(intent);

    }
    public void openSecondActivity(){
        Intent intent=new Intent(this,secondlevel_10_feedback.class);
        startActivity(intent);
    }

}

