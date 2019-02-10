package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class secondlevel_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_6);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        ////showing result button
        Button showResult=(Button)findViewById(R.id.ShowMeResultButton_secondlevel_5);
        final TextView ResultBox=(TextView)findViewById(R.id.ResultBox_secondlevel_6);
        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the show result button clicked for first time we update the numOfLessonPassed in db .
                SharedPreferences prefs = getSharedPreferences("pref_secondLevel_l6", MODE_PRIVATE);
                boolean firstStart = prefs.getBoolean("firstStart", true);
                if (firstStart){
                    m.UpdateNumOfLesson(14,"Nepton");
                    SharedPreferences pref = getSharedPreferences("pref_secondLevel_l6", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();}
                    //setting the  fixed result in resultBox
                ResultBox.setText("5");
                Intent feedback=new Intent(getApplicationContext(),secondlevel_7_feedback2.class);
                startActivity(feedback);
            }
        });


        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_6);
        textView.setText(m.getChildScore()+"" );
        //HOME BUTTON
        ImageButton homebtn3=(ImageButton)findViewById(R.id.homebtn_secondlevel5);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
    }
}//end class
