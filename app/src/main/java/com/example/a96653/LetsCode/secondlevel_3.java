package com.example.a96653.LetsCode;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class secondlevel_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_3);

        final MySQLliteHelper m=new MySQLliteHelper(this);

        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox_firstlevel3);
        scoredisplay.setText(m.getChildScore()+"" );



        ImageButton homebtn10=(ImageButton)findViewById(R.id.homebtn10);

        homebtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });

        ImageView previous4=(ImageView) findViewById(R.id.previous4);
        previous4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });


ImageView next4=(ImageView)findViewById(R.id.next4);
next4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        GoNext();

    }
});


    }//end of oncreate

    public void  GoNext(){
        Intent gonext=new Intent(getApplicationContext(),secondlevel_4.class);
        startActivity(gonext);
    }


    public void GoToprevious (){
        Intent goback=new Intent(getApplicationContext(),secondlevel_2.class);
        startActivity(goback);
    }
}
