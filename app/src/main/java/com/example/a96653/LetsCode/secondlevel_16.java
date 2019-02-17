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

public class secondlevel_16 extends AppCompatActivity {
    MediaPlayer secondlevel_16;
    voice voice16_secondlevel;
    TextView  text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_16);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_16);
        textView.setText(m.getChildScore()+"" );
        //create MediaPLayer to play the voice
        secondlevel_16= MediaPlayer.create(secondlevel_16.this,R.raw.secondlevel_16_voice);
        voice16_secondlevel=new voice( secondlevel_16);
        voice16_secondlevel.play();

        //HOME BUTTON
        ImageButton homebtn3=(ImageButton)findViewById(R.id.homebtn_secondlevel16);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id.previous_seconlevel_16);
        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );
        //NEXT BUTTON
        ImageView goButton=(ImageView) findViewById(R.id.next_16);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_secondLevel_16", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(22,"Nepton");
                            SharedPreferences pref = getSharedPreferences("pref_secondLevel_16", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );
//show me result button
        Button showmMe=(Button)findViewById(R.id.button10);
       text= (TextView) findViewById(R.id.textView91);
        showmMe.setOnClickListener( new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                text.setText("هيا نبرمج");
            }
        });

    }//END onCREATE

    public void openPreviousActivity() {
        Intent intent=new Intent(this,secondlevel_15.class);
        startActivity(intent);
    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, secondlevel_17.class);
        startActivity(intent);

    }
    @Override
    protected void onPause() {
        super.onPause();
        voice16_secondlevel.pause();
    }

    public void play(View view) {
        voice16_secondlevel.play();
    }//end play method

}

