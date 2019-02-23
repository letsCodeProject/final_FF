package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_12 extends AppCompatActivity {
    ImageView next ,prevoius;
    MySQLliteHelper mySqliteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_12);
        mySqliteOpenHelper=new MySQLliteHelper(this);

        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_thirdlevel_12);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );




        prevoius = (ImageView)findViewById(R.id.previous_thirslevel_12);
        prevoius.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        openPreviousActivity();
                    }

                }

        );

    }

    public void showme_theanswer(View view) {
        TextView textView=(TextView)findViewById(R.id.textView106);
        textView.setVisibility(View.VISIBLE);

        Intent feedback=new Intent(getApplicationContext(),thirdlevel_13_feedback.class);
        startActivity(feedback);

    }

    public void openPreviousActivity(){

        Intent intent=new Intent(this,thirdlevel_11.class);
        startActivity(intent);

    }

    public void btnHome(View view) {

        Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(HomePage);

    }
}
