package com.example.a96653.LetsCode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class firstlevel_1 extends AppCompatActivity  {
    //Lesson l1=new Lesson(1);

    MediaPlayer firstlevel1Voice;
    voice voicepluto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_1);

        //create MediaPLayer to play the voice
        firstlevel1Voice=MediaPlayer.create(firstlevel_1.this,R.raw.firstlevel1voice);
        voicepluto1=new voice(firstlevel1Voice);
        voicepluto1.play();



        final MySQLliteHelper m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_firstlevel1);
        textView.setText(m.getChildScore()+"" );
        ///
        SharedPreferences prefs = getSharedPreferences("prefs1", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            // m.addLesson(l1);
            SharedPreferences pref = getSharedPreferences("prefs1", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();
        }

        TextView t=(TextView)findViewById(R.id.textView17);
        // access a=access.getinstance(this);
        //List<String> name=a.getChildName();
        //a.close();
        //  t.setText((name.get(0)));

        Button goButton = (Button)findViewById(R.id.button3);
        //home button
        ImageButton homebtn=(ImageButton)findViewById(R.id.homebtn);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref2", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(2,"Ploto");
                            SharedPreferences pref = getSharedPreferences("prefs2", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }

                }

        );
    }





    public void openSecondActivity() {

        Intent intent = new Intent(this, firstlevel_2.class);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        voicepluto1.pause();
    }

    public void play(View view) {
        voicepluto1.play();
    }









//android:layout_alignBottom="@+id/imageView40"



}
