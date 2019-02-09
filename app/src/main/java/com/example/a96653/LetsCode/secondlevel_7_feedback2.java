package com.example.a96653.LetsCode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class secondlevel_7_feedback2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_7_feedback2);
        final MySQLliteHelper m=new MySQLliteHelper(this);
        ///to show result
        TextView ResultBox=(TextView)findViewById(R.id.ResultBox_secondlevel_7);
        ResultBox.setText("5");
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_7);
        textView.setText(m.getChildScore()+"" );


    }
}
