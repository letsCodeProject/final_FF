package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class secondlevel_17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_17);
        MySQLliteHelper m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_secondleve_l7);
        textView.setText(m.getChildScore()+"" );


        //HOME BUTTON
        ImageButton homebtn3=(ImageButton)findViewById(R.id.homebtn_secondlevel7);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
    }
}
