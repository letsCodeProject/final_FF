package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class welcome_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_3);


    ImageView next = (ImageView)findViewById(R.id.imageView18);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        mySqliteOpenHelper.UpdateWelcomingTable("welcome4",1);
                        openSecondActivity();
                    }

                }

        );


        }



    public void openSecondActivity() {
        Intent intent = new Intent(this, welcome_4.class);
        startActivity(intent);


    }}
