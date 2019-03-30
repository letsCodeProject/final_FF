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

public class thirdlevel_15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_15);
        //TRY ME YOURSELF BUTTON .
        final String text="False";
        Button Runbutton=(Button) findViewById(R.id.showMeResult_thirdlevel_15);
        Runbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t1=(TextView)findViewById(R.id.ResultBox_thirdlevel_15);
                t1.setText(text.toString());
                t1.setTextSize(25);
                t1.setTextColor(Color.BLACK);
            }
        });
        //scoreBox
        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.ScoreBox_thirdlevel_15);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn_thirdlevel15);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });
        //PREVIOUS BUTTON
        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel15);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

        //NEXT BUTTON
        ImageView next=(ImageView)findViewById(R.id.nextBTN_thirdlevel15);
        next.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_15", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(43,"Saturn");
                            SharedPreferences pref = getSharedPreferences("pref_thirdLevel_15", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );


    }//End of Oncreate


    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_14.class);
         startActivity(goBack);
    }

    public void  openSecondActivity(){
        Intent gonext=new Intent(getApplicationContext(),thirdlevel_16.class);
      startActivity(gonext);
    }

}


