package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class firstlevel_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_3);

        ImageButton homebtn2=(ImageButton)findViewById(R.id.homebtn2);

        homebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });



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
