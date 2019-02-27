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

public class thirdlevel_8 extends AppCompatActivity {
    MediaPlayer thirdlevel_8;
    voice voice8_thirdlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_8);

        //create MediaPLayer to play the voice
        thirdlevel_8= MediaPlayer.create(thirdlevel_8.this,R.raw.thirdlevel_8);
        voice8_thirdlevel=new voice( thirdlevel_8);
        voice8_thirdlevel.play();

        //NEXT BUTTON
        final MySQLliteHelper m=new MySQLliteHelper(this);
        ImageView goButton=(ImageView) findViewById(R.id.next_thirdlevel_8);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_8", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(37,"Saturn");
                            SharedPreferences pref = getSharedPreferences("pref_thirdLevel_8", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );
        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_thirdlevel_8);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn9=(ImageButton)findViewById(R.id.homebtn_thirdlevel_8);
        homebtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });

        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel_8);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, thirdlevel_9.class);
        startActivity(intent);

    }
    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_7.class);
        startActivity(goBack);
    }
    @Override
    protected void onPause() {
        super.onPause();
        voice8_thirdlevel.pause();
    }

    public void play(View view) {
        voice8_thirdlevel.play();
    }//end play method
}
