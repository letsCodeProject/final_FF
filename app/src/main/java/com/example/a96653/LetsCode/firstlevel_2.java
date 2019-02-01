package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class firstlevel_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_2);

        final MySQLliteHelper m=new MySQLliteHelper(this);
        SharedPreferences prefs = getSharedPreferences("prefs3", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
        //m.addLesson(l2);

            SharedPreferences pref = getSharedPreferences("prefs3", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();}
        ImageButton homebtn3=(ImageButton)findViewById(R.id.homebtn3);

        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

        ImageView next = (ImageView)findViewById(R.id.imageView41);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        SharedPreferences prefs = getSharedPreferences("pref4", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(3,"Ploto");
                            SharedPreferences pref = getSharedPreferences("prefs4", MODE_PRIVATE);
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
        Intent intent=new Intent(this,firstlevel_3.class);
        startActivity(intent);
    }

    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_1.class);
        startActivity(intent);

    }








}
