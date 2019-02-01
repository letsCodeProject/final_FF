package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class welcome_7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_7);
        ImageView next = (ImageView)findViewById(R.id.imageView34);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        mySqliteOpenHelper.UpdateWelcomingTable("main",1);
                        openSecondActivity();
                    }

                }

        );


        ImageView previous = (ImageView)findViewById(R.id.imageView35);

        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );

    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,welcome_6.class);
        startActivity(intent);

    }




}
