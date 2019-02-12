package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class secondlevel_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_4);

        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_firstlevel4);
        scoredisplay.setText(m.getChildScore()+"" );


        //HOME BUTTON
        ImageButton homebtn11=(ImageButton)findViewById(R.id.homebtn11);
        homebtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });
///

        ImageView previous5=(ImageView)findViewById(R.id.previous5);
        previous5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

        ImageView next5=(ImageView)findViewById(R.id.next5);
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoNext();
            }
        });



    }//end of oncreate

    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),secondlevel_3.class);
        startActivity(goBack);
    }

    public void GoNext(){
        Intent gonext=new Intent(getApplicationContext(),secondlevel_5.class);
        startActivity(gonext);
    }
}
