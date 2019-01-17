package com.example.a96653.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_2);



        Button goButton = (Button)findViewById(R.id.button2);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        openSecondActivity();
                    }

                }

        );
        }

    public void openSecondActivity(){
        Intent intent=new Intent(this,welcome_3.class);
        startActivity(intent);


}}
