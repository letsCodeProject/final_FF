package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_2);

        //scoreBox_firstlevel8
        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_firstlevel8);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn14);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });





        ImageView previous3=(ImageView)findViewById(R.id.previous7);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

        ImageView next3=(ImageView)findViewById(R.id.next71);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoNext();
            }
        });
    }//End of Oncreate


    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_1.class);
        startActivity(goBack);
    }

    public void GoNext(){
        Intent gonext=new Intent(getApplicationContext(),thirdlevel_3.class);
        startActivity(gonext);
    }

}