package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

// i hate it too -shyom
public class firstlevel_5 extends AppCompatActivity {
    MySQLliteHelper mySqliteOpenHelper;
    MediaPlayer firstlevel5Voice;
    voice voicepluto5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //create MediaPLayer to play the voice
        firstlevel5Voice=MediaPlayer.create(firstlevel_5.this,R.raw.firstlevel5voice);
        voicepluto5=new voice(firstlevel5Voice);
        voicepluto5.play();



        //FOR ADDING Q TO DB TO SEND THE QUIZE NUM
        mySqliteOpenHelper=new MySQLliteHelper(this);

        ////
        SharedPreferences prefs = getSharedPreferences("prefs9", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            //m.addLesson(l2);
            mySqliteOpenHelper.addQuestion(1);
            mySqliteOpenHelper.addQuestion(1);
            SharedPreferences pref = getSharedPreferences("prefs9", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();
        }

        ////
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_5);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_firstlevel5);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );

        //homebtn5
        ImageButton homebtn5=(ImageButton)findViewById(R.id.homebtn5);

        homebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

        ImageView previous = (ImageView)findViewById(R.id.previous2);
        Button Go=(Button) findViewById(R.id.button6);

        Go.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        SharedPreferences prefs = getSharedPreferences("pref10", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            mySqliteOpenHelper.UpdateNumOfLesson(6,"Ploto");
                            SharedPreferences pref = getSharedPreferences("prefs10", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                        openQuiz();
                    }

                }

        );


        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );



    }





    public void openQuiz(){

        Intent intent=new Intent(this,firstlevel_6.class);
        startActivity(intent);

    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_4.class);
        startActivity(intent);

    }


    @Override
    protected void onPause() {
        super.onPause();
        voicepluto5.pause();
    }

    public void play(View view) {
        voicepluto5.play();
    }




}
