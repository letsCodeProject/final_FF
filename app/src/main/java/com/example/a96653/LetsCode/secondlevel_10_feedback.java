package com.example.a96653.LetsCode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class secondlevel_10_feedback extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_10_feedback);
        MySQLliteHelper m=new MySQLliteHelper(this);
        ///to show result
        TextView ResultBox=(TextView)findViewById(R.id.ResultBox_secondlevel_10);
        ResultBox.setText("لبيب");
        ResultBox.setTextColor(R.color.Shadwo_purple);


        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_10);
        textView.setText(m.getChildScore()+"" );


        //HOME BUTTON
        ImageButton homebtn3=(ImageButton)findViewById(R.id.homebtn_secondlevel10);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //PREVIOUS BUTTON
        ImageView previous = (ImageView)findViewById(R.id. previous_seconlevel_10);
        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );


    }//END onCREATE

    public void openPreviousActivity(){

        Intent intent=new Intent(this,secondlevel_9.class);
        startActivity(intent);

    }


}

