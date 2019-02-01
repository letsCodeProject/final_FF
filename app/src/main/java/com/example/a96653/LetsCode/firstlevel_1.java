package com.example.a96653.LetsCode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class firstlevel_1 extends AppCompatActivity  {
 //Lesson l1=new Lesson(1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_1);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        SharedPreferences prefs = getSharedPreferences("prefs1", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
           // m.addLesson(l1);
            SharedPreferences pref = getSharedPreferences("prefs1", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();
        }

        TextView t=(TextView)findViewById(R.id.textView17);
       // access a=access.getinstance(this);
        //List<String> name=a.getChildName();
        //a.close();
     //  t.setText((name.get(0)));

        Button goButton = (Button)findViewById(R.id.button3);
        //home button
      ImageButton homebtn=(ImageButton)findViewById(R.id.homebtn);

       homebtn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
               startActivity(HomePage);
            }
        });

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref2", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(2,"Ploto");
                            SharedPreferences pref = getSharedPreferences("prefs2", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }

                }

        );
    }





    public void openSecondActivity() {

        Intent intent = new Intent(this, firstlevel_2.class);
        startActivity(intent);

    }








//android:layout_alignBottom="@+id/imageView40"



}
