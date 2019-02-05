package com.example.a96653.LetsCode;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class welcome_5 extends AppCompatActivity {

    MediaPlayer welcome5Voice;
    voice voice5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_5);

        //create MediaPLayer to play the voice
        welcome5Voice=MediaPlayer.create(welcome_5.this,R.raw.welcom5voice);
        voice5=new voice(welcome5Voice);
        voice5.play();



        ImageView next = (ImageView)findViewById(R.id.imageView32);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        mySqliteOpenHelper.UpdateWelcomingTable("welcome6",1);
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
        Intent intent=new Intent(this,welcome_6.class);
        startActivity(intent);
    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,welcome_4.class);
        startActivity(intent);

    }
    @Override
    protected void onPause() {
        super.onPause();
        voice5.pause();
    }

    public void play(View view) {
        voice5.play();
    }
}




