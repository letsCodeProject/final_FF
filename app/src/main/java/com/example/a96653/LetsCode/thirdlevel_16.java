package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_16);


        //scoreBox
        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.ScoreBox_thirdlevel_16);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn_thirdlevel16);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);

            }
        });
        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel16);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

        ImageView next3=(ImageView)findViewById(R.id.nextBTN_thirdlevel16);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoNext();
            }
        });
    }//End of Oncreate


    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_15.class);
          startActivity(goBack);
    }

    public void GoNext(){
        Intent gonext=new Intent(getApplicationContext(),thirdlevel_17.class);
      startActivity(gonext);
    }

}
