package com.example.a96653.LetsCode;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class welcome_6 extends AppCompatActivity {


    MediaPlayer welcome6Voice;
    voice voice6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_6);
        ImageView next = (ImageView)findViewById(R.id.imageView30);

        //create MediaPLayer to play the voice
        welcome6Voice=MediaPlayer.create(welcome_6.this,R.raw.welcome6voice);
        voice6=new voice(welcome6Voice);
        voice6.play();

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        mySqliteOpenHelper.UpdateWelcomingTable("welcome7",1);
                        openSecondActivity();
                    }

                }

        );


        ImageView previous = (ImageView)findViewById(R.id.imageView24);

        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );

    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,welcome_7.class);
        startActivity(intent);
    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,welcome_5.class);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        voice6.pause();
    }

    public void play(View view) {
        voice6.play();
    }




}
