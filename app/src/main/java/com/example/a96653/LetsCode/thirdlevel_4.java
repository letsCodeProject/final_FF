package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_4);


        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_firstlevel10);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn16);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });




        ImageView previous3=(ImageView)findViewById(R.id.previous9);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

        ImageView next3=(ImageView)findViewById(R.id.next9);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoNext();
            }
        });
    }

    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_3.class);
        startActivity(goBack);
    }

    public void GoNext(){
        //Intent gonext=new Intent(getApplicationContext(),thirdlevel_5.class);
        // startActivity(gonext);
    }




}
