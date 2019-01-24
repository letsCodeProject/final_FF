package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class firstlevel_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_3);




        ImageView pre = (ImageView)findViewById(R.id.prebtn);

        pre.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );


      //  nextbtn
        ImageView next = (ImageView)findViewById(R.id.nextbtn);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openSecondActivity();
                    }

                }

        );

    }




    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_2.class);
        startActivity(intent);

    }


    public void openSecondActivity(){
        Intent intent=new Intent(this,firstlevel_4.class);
        startActivity(intent);
    }










}
