package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class secondlevel_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_1);


        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_firstlevel);
        scoredisplay.setText(m.getChildScore()+"" );


        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn6);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });
        //


//TALI BUTTON
        Button talibutton=(Button)findViewById(R.id.talibutton);
        talibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoNext();
            }
        });
    }//oncreate method closing.

    //METHOD FOR TALI
    public void GoNext(){
        Intent gonext=new Intent(getApplicationContext(),secondlevel_20.class);
        startActivity(gonext);
    }
}

