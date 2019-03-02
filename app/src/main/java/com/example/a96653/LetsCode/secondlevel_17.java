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

public class secondlevel_17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_17);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_secondleve_l7);
        textView.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn3=(ImageButton)findViewById(R.id.homebtn_secondlevel7);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id.previous_seconlevel_17);
        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );
        //NEXT BUTTON
      Button goButton=(Button) findViewById(R.id.NEXT_17);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_secondLevel_17", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(23,"Nepton");
                            SharedPreferences pref = getSharedPreferences("pref_secondLevel_17", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );
        SharedPreferences prefs = getSharedPreferences("pre5fs_for_question_secondlevrl", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            m.addQuestion(2);
            m.addQuestion(2);
            m.addQuestion(2);
            m.addQuestion(2);
            m.addQuestion(2);
            SharedPreferences pref = getSharedPreferences("pre5fs_for_question_secondlevrl", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();
        }

    }//END OF ONcreate
    public void openPreviousActivity(){

        Intent intent=new Intent(this,secondlevel_16.class);
        startActivity(intent);

    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, secondlevel_18_quiz.class);
        startActivity(intent);

    }
}
