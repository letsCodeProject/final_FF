package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class seconlevel_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconlevel_8);
        MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        //HOME BUTTON
        ImageButton homebtnres=(ImageButton) findViewById(R.id.homebtn_secondlevel8);
        homebtnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //TO VIEW SCORE
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_8);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );
    }
}
