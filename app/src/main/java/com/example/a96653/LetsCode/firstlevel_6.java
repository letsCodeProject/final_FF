package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;



// i hate git hub
public class firstlevel_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_6);

        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn6);

        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

      //  next2


        ImageView next = (ImageView)findViewById(R.id.next2);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openSecondActivity();
                    }

                }

        );

    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,firstlevel_7.class);
        startActivity(intent);
    }








}
