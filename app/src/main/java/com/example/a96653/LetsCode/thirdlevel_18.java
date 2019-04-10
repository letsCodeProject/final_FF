package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_18 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_18);
        //NEXT BUTTON
        final MySQLliteHelper m=new MySQLliteHelper(this);
       final ImageView goButton=(ImageView) findViewById(R.id.next_thirdlevel_18);
goButton.setVisibility(View.INVISIBLE);
        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_18", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(46,"Saturn");
                            SharedPreferences pref = getSharedPreferences("pref_thirdLevel_18", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );
        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.ScoreBox_thirdlevel_18);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn9=(ImageButton)findViewById(R.id.homebtn_thirdlevel_18);
        homebtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });
///PREVIOUS BUTTON
        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel_18);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });
        //SHOW ME RESULT BUTTON
      final   TextView ResultBox=(TextView) findViewById(R.id.ResultBox_thirdlevel_18);
        Button showMeResult=(Button)findViewById(R.id.showMeResult_thirdlevel_18);
        showMeResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // ResultBox.setText("True");
                ResultBox.setTextColor(Color.BLACK);
                ResultBox.setTextSize(25);
               // goButton.setVisibility(View.VISIBLE);
                openSecondActivity();
            }
        });

    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, thirdlevel_18feedback.class);
        startActivity(intent);

    }
    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_17.class);
        startActivity(goBack);
    }
    }

