package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class fourthlevel_video extends AppCompatActivity {

    ImageButton btn;
    MediaController mediaC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MySQLliteHelper    m = new MySQLliteHelper(this);
        setContentView(R.layout.activity_fourthlevel_video);
        btn=findViewById(R.id.next);
        btn.setOnClickListener( new ImageButton.OnClickListener(){
            public void onClick(View v) {
          Intent intent=new Intent(fourthlevel_video.this,MainActivity.class);
            startActivity(intent);
        }
        }
         );
        btn.setVisibility(View.GONE);
        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoview.setVideoURI(uri);
        mediaC=new  MediaController(this);

        videoview.setMediaController(mediaC);
        mediaC.setAnchorView(videoview);
        videoview.start();
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                btn.setVisibility(View.VISIBLE);
            }
        });


        if ( videoview.isPlaying() )
        {
            btn.setVisibility(View.GONE);
        }




       ImageButton btn=( ImageButton) findViewById(R.id.next);
        btn.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("fourthLevel_video", MODE_PRIVATE);
                boolean firstStart = prefs.getBoolean("firstStart", true);
                if (firstStart){
                    m.UpdateNumOfLesson(56,"Jupiter");
                    SharedPreferences pref = getSharedPreferences("fourthLevel_video", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();}
                Intent next=new Intent(getApplicationContext(),fourthlevel_3.class);
                startActivity(next);

            }
        });

    }



}










