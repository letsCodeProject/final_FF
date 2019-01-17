package com.example.a96653.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class firstlevel_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_2);



        ImageView next = (ImageView)findViewById(R.id.imageView41);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

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
