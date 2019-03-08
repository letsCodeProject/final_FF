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

public class fourthlevel_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthlevel_3);
        //HOME BUTTON
        ImageButton homebtn=(ImageButton)findViewById(R.id.homebtn_forthlevel_3);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        final MySQLliteHelper m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_forthlevel_3);
        textView.setText(m.getChildScore()+"" );
        //PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id.previous_forthlevel_3);
        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );
        //NEXT BUTTON
        Button goButton=(Button) findViewById(R.id.forthlevel_3_next);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_forthlevel_3", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(57,"Jupiter");
                            SharedPreferences pref = getSharedPreferences("pref_forthlevel_3", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );
    }
    public void openPreviousActivity(){

        Intent intent=new Intent(this,fourthlevel_video.class); //MUST GO BACK TO WHAT ?
        startActivity(intent);

    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, fourthlevel_4.class);
        startActivity(intent); }
}
