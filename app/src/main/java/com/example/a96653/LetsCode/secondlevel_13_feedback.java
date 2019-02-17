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

public class secondlevel_13_feedback extends AppCompatActivity {
    MediaPlayer secondlevel_13;
    voice voice13_secondlevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_13);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        ///to show result
        TextView ResultBox=(TextView)findViewById(R.id.ResultBox_secondlevel_13);
        ResultBox.setText("لبيب");
        ResultBox.setTextSize(20);

        //create MediaPLayer to play the voice
        secondlevel_13= MediaPlayer.create(secondlevel_13_feedback.this,R.raw.secondlevel_exercise_feedback);
        voice13_secondlevel=new voice( secondlevel_13);
        voice13_secondlevel.play();

        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_13);
        textView.setText(m.getChildScore()+"" );


        //HOME BUTTON
        ImageButton homebtn3=(ImageButton)findViewById(R.id.homebtn_secondlevel13);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id. previous_seconlevel_13);
        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );
//NEXT BUTTON
        ImageView goButton=(ImageView) findViewById(R.id.next_13);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_secondLevel_13", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(19,"Nepton");
                            SharedPreferences pref = getSharedPreferences("pref_secondLevel_13", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );

    }//END onCREATE
    public void openSecondActivity() {

        Intent intent = new Intent(this, secondlevel_14.class);
        startActivity(intent);

    }

    public void openPreviousActivity(){

        Intent intent=new Intent(this,secondlevel_11.class);
        startActivity(intent);

    }
    @Override
    protected void onPause() {
        super.onPause();
        voice13_secondlevel.pause();
    }

    public void play(View view) {
        voice13_secondlevel.play();
    }//end play method

}

