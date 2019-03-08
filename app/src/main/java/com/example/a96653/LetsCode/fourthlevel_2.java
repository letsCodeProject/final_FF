package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class fourthlevel_2 extends AppCompatActivity {
    static MySQLliteHelper m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthlevel_2);
        m = new MySQLliteHelper(this);

        //HOME BUTTON
        ImageButton homebtn= (ImageButton) findViewById(R.id.homebtn_fourthlevel_2);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(HomePage);
            }
        });

        //TO VIEW SCORE ON BOX
        TextView textView = (TextView) findViewById(R.id.scorebox_fourthlevel_2);
        textView.setText(m.getChildScore() + "");


        //NEXT INTERFACE BUTTON
        Button next = (Button) findViewById(R.id.talibutton_fourthlevel_2);
        next.setOnClickListener(
                new ImageView.OnClickListener() {
                    public void onClick(View v) {

                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("fourthLevel_2", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(55,"Jupiter");
                            SharedPreferences pref = getSharedPreferences("fourthLevel_2", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }

                }

        );


    }

    public void openSecondActivity() {
        Intent intent = new Intent(this, fourthlevel_video.class);
        startActivity(intent);
    }



}
