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

public class thirdlevel_7 extends AppCompatActivity {
    MediaPlayer thirdlevel_7;
    voice voice7_thirdlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_7);


        //create MediaPLayer to play the voice
        thirdlevel_7= MediaPlayer.create(thirdlevel_7.this,R.raw.thirdlevel_7);
        voice7_thirdlevel=new voice( thirdlevel_7);
        voice7_thirdlevel.play();

        //NEXT BUTTON
        final MySQLliteHelper m=new MySQLliteHelper(this);
        ImageView goButton=(ImageView) findViewById(R.id.next_thirdlevel_7);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_7", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(36,"Saturn");
                            SharedPreferences pref = getSharedPreferences("pref_thirdLevel_7", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );
        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox__thirdlevel_7);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn9=(ImageButton)findViewById(R.id.homebtn_thirdlevel_7);
        homebtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });

        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel_7);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, thirdlevel_8.class);
        startActivity(intent);

    }
    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_6.class);
        startActivity(goBack);
    }
    @Override
    protected void onPause() {
        super.onPause();
        voice7_thirdlevel.pause();
    }

    public void play(View view) {
        voice7_thirdlevel.play();
    }//end play method
}
