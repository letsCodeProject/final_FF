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

public class thirdlevel_18feedback extends AppCompatActivity {

    MySQLliteHelper mySqliteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_18feedback);
        ImageView next_thirdlevel_=(ImageView) findViewById(R.id.next_thirdlevel_);

        ImageView previous_thirslevel_=(ImageView) findViewById(R.id.previous_thirslevel_);

       ImageButton gohome=(ImageButton) findViewById(R.id.homebtn20);
        mySqliteOpenHelper=new MySQLliteHelper(this);

        TextView textView = (TextView)findViewById(R.id.scoreBox_thirdlevel_);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );

        next_thirdlevel_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_18", MODE_PRIVATE);
                boolean firstStart = prefs.getBoolean("firstStart", true);
                if (firstStart){
                    mySqliteOpenHelper.UpdateNumOfLesson(46,"Saturn");
                    SharedPreferences pref = getSharedPreferences("pref_thirdLevel_18", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();}

                openSecondActivity();
            }
        });

        previous_thirslevel_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPreviousActivity();
            }
        });

        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
    }



    public void openSecondActivity(){
        Intent intent=new Intent(this,thirdlevel_19.class);
        startActivity(intent);
    }



    public void openPreviousActivity(){

        Intent intent=new Intent(this,thirdlevel_18.class);
        startActivity(intent);

    }



}
