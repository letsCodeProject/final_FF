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

public class thirdlevel_3 extends AppCompatActivity {
    MediaPlayer thirdlevel_3;
    voice voice3_thirdlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_3);

        final MySQLliteHelper m=new MySQLliteHelper(this);

        //create MediaPLayer to play the voice
        thirdlevel_3= MediaPlayer.create(thirdlevel_3.this,R.raw.thirdlevel_3);
        voice3_thirdlevel=new voice( thirdlevel_3);
        voice3_thirdlevel.play();

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_firstlevel9);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn15);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });


//PREVIOUS BUTTON
        ImageView previous3=(ImageView)findViewById(R.id.previous8);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

        //NEXT BUTTON
        ImageView next3=(ImageView)findViewById(R.id.next81);
        next3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_3", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(32,"Saturn");
                            SharedPreferences pref = getSharedPreferences("pref_thirdLevel_3", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );

    }//oncreate method closing.

    //METHOD FOR TALI
    public void    openSecondActivity(){
        Intent gonext=new Intent(getApplicationContext(),thirdlevel_4.class);
        startActivity(gonext);
    }


    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_2.class);
        startActivity(goBack);
    }

    @Override
    protected void onPause() {
        super.onPause();
        voice3_thirdlevel.pause();
    }

    public void play(View view) {
        voice3_thirdlevel.play();
    }//end play method

}

