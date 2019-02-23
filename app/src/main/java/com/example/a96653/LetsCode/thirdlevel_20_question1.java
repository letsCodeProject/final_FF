package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_20_question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_20_question1);

//scoreBox
        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        //TextView scoredisplay=(TextView) findViewById(R.id.ScoreBox_thirdlevel_20);
       /* scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
       // ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn_thirdleve20);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });*/

       /* ImageView next3=(ImageView)findViewById(R.id.next_thirdlevel_20);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoNext();
            }
        });*/
    }//End of Oncreate



    public void GoNext(){
        Intent gonext=new Intent(getApplicationContext(),thirdlevel_21.class);
        startActivity(gonext);
    }

}

