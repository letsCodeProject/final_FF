package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_19 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_19);
        //Go Button
        final MySQLliteHelper m=new MySQLliteHelper(this);
        Button goButton=(Button) findViewById(R.id.GoToquize_thirdlevel_19);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_19", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(47,"Saturn");
                            m.addQuestion(3);
                            m.addQuestion(3);
                            m.addQuestion(3);
                            m.addQuestion(3);
                            m.addQuestion(3);
                            SharedPreferences pref = getSharedPreferences("pref_thirdLevel_19", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner




        );
        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_thirdlevel_19);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn9=(ImageButton)findViewById(R.id.homebtn_thirdlevel_19);
        homebtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });

        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel_19);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, thirdlevel_21.class);
        startActivity(intent);

    }
    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_18.class);
        startActivity(goBack);
    }
    }

