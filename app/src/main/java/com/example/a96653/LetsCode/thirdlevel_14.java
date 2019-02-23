package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_14);


        //scoreBox
        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.ScoreBox_thirdlevel_14);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn_thirdlevel14);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });
        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel14);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

        ImageView next3=(ImageView)findViewById(R.id.nextBTN_thirdlevel14);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoNext();
            }
        });
    }//End of Oncreate


    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_13_feedback.class);
       startActivity(goBack);
    }

    public void GoNext(){
       Intent gonext=new Intent(getApplicationContext(),thirdlevel_15.class);
       startActivity(gonext);
    }

}


