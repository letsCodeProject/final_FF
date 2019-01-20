package com.example.a96653.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class welcome_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_6);
        ImageView next = (ImageView)findViewById(R.id.imageView30);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openSecondActivity();
                    }

                }

        );


        ImageView previous = (ImageView)findViewById(R.id.imageView24);

        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );

    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,welcome_7.class);
        startActivity(intent);
    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,welcome_5.class);
        startActivity(intent);

    }




}
