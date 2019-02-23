package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_10 extends AppCompatActivity {
    ImageView next ,prevoius;
    MySQLliteHelper mySqliteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_10);
        mySqliteOpenHelper=new MySQLliteHelper(this);


        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_thirdlevel_10);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );


        next = (ImageView)findViewById(R.id.next_thirdlevel_10);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                    }

                }

        );

        prevoius = (ImageView)findViewById(R.id.previous_thirslevel_10);
        prevoius.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                         openPreviousActivity();
                    }

                }

        );


    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,thirdlevel_11.class);
        startActivity(intent);

    }

    public void openPreviousActivity(){

        Intent intent=new Intent(this,thirdlevel_9.class);
        startActivity(intent);

    }

    public void btnHome(View view) {

        Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(HomePage);

    }

}
