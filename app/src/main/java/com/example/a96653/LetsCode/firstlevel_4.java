package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

public class firstlevel_4 extends AppCompatActivity {
    MediaPlayer firstlevel4Voice;
    voice voicepluto4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_4);

        //create MediaPLayer to play the voice
        firstlevel4Voice=MediaPlayer.create(firstlevel_4.this,R.raw.firstlevel4);
        voicepluto4=new voice(firstlevel4Voice);
        voicepluto4.play();


        //HOME BUTTON
        ImageButton homebtn4=(ImageButton)findViewById(R.id.homebtn4);
        homebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });


//NEXT INTERFACE BUTTON
        ImageView next = (ImageView)findViewById(R.id.next);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_firstlevel4);
        textView.setText(m.getChildScore()+"" );
        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        SharedPreferences prefs = getSharedPreferences("pref8", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(5,"Ploto");
                            SharedPreferences pref = getSharedPreferences("prefs8", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                        openSecondActivity();
                    }

                }

        );
//PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id.previous);

        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );
        //RUN BUTTON FOR EXERSIE
        Button Runbutton=(Button) findViewById(R.id.button4);
        Runbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed1=(EditText)findViewById(R.id.editText3);
                TextView t1=(TextView)findViewById(R.id.textView57);
                t1.setText(ed1.getText().toString());
                t1.setTextColor(Color.BLACK);
                t1.setTextSize(25);
            }
        });




    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,firstlevel_5.class);
        startActivity(intent);
    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,feedback3.class);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        voicepluto4.pause();
    }

    public void play(View view) {
        voicepluto4.play();
    }




}
