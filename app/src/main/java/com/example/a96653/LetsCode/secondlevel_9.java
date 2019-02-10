package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class secondlevel_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_9);
        MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        //HOME BUTTON
        ImageButton homebtnres=(ImageButton) findViewById(R.id.homebtn_secondlevel9);
        homebtnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //TO VIEW SCORE
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_9);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );
    }
}
