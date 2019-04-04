package com.example.a96653.LetsCode;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndOfLevels extends AppCompatActivity {
    MediaPlayer congrats;
    voice congratsVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_levels);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_EndOflevels);
        textView.setText(m.getChildScore()+"" );

        //create MediaPLayer to play the voice
        congrats= MediaPlayer.create(EndOfLevels.this,R.raw.congrats);
        congratsVoice=new voice(congrats);
        congratsVoice.play();

        //BACK BUTON
        Button back=(Button)findViewById(R.id.back_earth);
        back.setOnClickListener(new Button.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(getApplicationContext(),MainActivity.class); 
                                        startActivity(intent);
                                    }
                                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        congratsVoice.pause();
    }

}
