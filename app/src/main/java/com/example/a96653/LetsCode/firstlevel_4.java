package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class firstlevel_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_4);



        ImageView next = (ImageView)findViewById(R.id.next);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openSecondActivity();
                    }

                }

        );

        ImageView previous = (ImageView)findViewById(R.id.previous);

        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );




    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,firstlevel_5.class);
        startActivity(intent);
    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_3.class);
        startActivity(intent);

    }




}
