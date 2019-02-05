package com.example.a96653.LetsCode;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class welcome_4 extends AppCompatActivity {

    MediaPlayer welcome4Voice;
    voice voice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_4);

        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);

        //create MediaPLayer to play the voice
        welcome4Voice=MediaPlayer.create(welcome_4.this,R.raw.welcome4voice);
        voice4=new voice(welcome4Voice);
        voice4.play();


        ImageView next = (ImageView)findViewById(R.id.imageView25);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        mySqliteOpenHelper.UpdateWelcomingTable("welcome5",1);
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
        Intent intent=new Intent(this,welcome_5.class);
        startActivity(intent);
    }

    public void openPreviousActivity(){

        Intent intent=new Intent(this,welcome_3.class);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        voice4.pause();
    }

    public void play(View view) {
        voice4.play();
    }
}
