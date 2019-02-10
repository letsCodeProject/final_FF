package com.example.a96653.LetsCode;



import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class feedback3 extends AppCompatActivity {
    MediaPlayer plutofeedback3;
    voice voiceplutofeedback3;
    //try if push work


    @Override
    protected void onCreate(Bundle savedInstanceState){

        final MySQLliteHelper m=new MySQLliteHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback3);
        TextView textView2 = (TextView)findViewById(R.id.ScoreBox_feedback);
        textView2.setText(m.getChildScore()+"" );
        //create MediaPLayer to play the voice
        plutofeedback3=MediaPlayer.create(feedback3.this,R.raw.firstlevelfeedback3voice);
        voiceplutofeedback3=new voice(plutofeedback3);
        voiceplutofeedback3.play();

        ImageButton homebtn2=(ImageButton)findViewById(R.id.homebtn2);

        homebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });


        ImageView next = (ImageView)findViewById(R.id.imageView41);

        next.setOnClickListener(new ImageView.OnClickListener(){
                                    public void onClick(View v){
                                        SharedPreferences prefs = getSharedPreferences("pref7", MODE_PRIVATE);
                                        boolean firstStart = prefs.getBoolean("firstStart", true);
                                        if (firstStart){
                                            m.UpdateNumOfLesson(4,"Ploto");
                                            SharedPreferences pref = getSharedPreferences("prefs7", MODE_PRIVATE);
                                            SharedPreferences.Editor editor = prefs.edit();
                                            editor.putBoolean("firstStart", false);
                                            editor.apply();}

                                        openSecondActivity();
                                    }

                                }

        );

        ImageView previous = (ImageView)findViewById(R.id.imageView40);

        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );




    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,firstlevel_4.class);
        startActivity(intent);
    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_3.class);
        startActivity(intent);

    }
    @Override
    protected void onPause() {
        super.onPause();
        voiceplutofeedback3.pause();
    }

    public void play(View view) {
        voiceplutofeedback3.play();
    }






}

